#!/bin/sh

name="$1"
url="$2"
branch="$3"
headid="$4"
files="$5"
gituser="$6"
gitpasswd="$7"
protocol=""

CERTFILE=".ubinuxcert.conf"
EXPECT="/usr/bin/expect"
RUN_CMD=exec_cmd

cleanup_and_exit()
{
	local err=$1

	cd $PWDDIR
	CDATE=`date +"%F-%H-%M-%S"`
	printf "\t\tERROR: move this $name to $name.$CDATE\n"
	mv $name $name.$CDATE

	exit $err
}

exec_cmd()
{
	local err=
	local errmsg=

	printf "\t%-100s:" "$1"
	$1 >/dev/null 2>&1
	err=$?

	if [ "x$err" != "x0" ]; then
		printf "** NG **\n"
		cleanup_and_exit $err
	else
		printf "OK\n"
	fi
}

exec_cmd_with_authentication()
{
	local err=
	local errmsg=

	printf "\t%-100s:" "$1"

$EXPECT <<EOF
	set timeout 60;
	log_user 0
	spawn $1
	expect {
		"not know" {send_user "[exec echo \"not know\"]";exit}
		"(yes/no)?" {send "yes\r";exp_continue}
		"*password:" { send "$gitpasswd\r" }
		"Permission denied, please try again." {
			send_user "[exec echo \"Error:Password is wrong\"]"
			exit
		}
		default {exit}
expect eof
	}
        expect eof
	catch wait result;
	exit [lindex \$result 3]
EOF
	err=$?
	if [ "x$err" != "x0" ]; then
		printf "** NG **\n"
		cleanup_and_exit $err
	else
		printf "OK\n"
	fi
}

create_new_repository()
{
	exec_cmd "git init $name"
	exec_cmd "cd $name"
	$RUN_CMD "git remote add -f --tags $name $url"
	exec_cmd "git config core.sparsecheckout true"
	
	printf "\tCreate .git/info/sparse-checkout\n"
	echo "$files" | sed 's/ /\n/g' >> .git/info/sparse-checkout

	$RUN_CMD "git fetch $name $branch"
	exec_cmd "git checkout -b $branch remotes/$name/$branch"
	exec_cmd "git reset --hard $headid"
	exec_cmd "cd $PWDDIR"
}

update_repository()
{
	local curbranch=

	cd $name
	curbranch=`git branch | grep "*" | awk '{print $2}'`
	cd $PWDDIR

	if [ "x$curbranch" = "x" ];then
		printf "$name is a bad repository: no active branch\n"
		printf "Re-create repository: $name\n"
		rm -rf $name
		create_new_repository
	elif [ "x$curbranch" != "x$branch" ]; then
		printf "\tUpdate .git/info/sparse-checkout\n"
		rm -rf .git/info/sparse-checkout
		echo "$files" | sed 's/ /\n/g' >> .git/info/sparse-checkout

		printf "Switch branch from $curbranch to $branch\n"
		exec_cmd "cd $name"
		$RUN_CMD "git fetch $name $branch"
		exec_cmd "git checkout -b $branch remotes/$name/$branch"
		exec_cmd "git reset --hard $headid"
		exec_cmd "cd $PWDDIR"
	else
		exec_cmd "cd $name"

		printf "\tUpdate .git/info/sparse-checkout\n"
		rm -rf .git/info/sparse-checkout
		echo "$files" | sed 's/ /\n/g' >> .git/info/sparse-checkout
		$RUN_CMD "git pull $url $branch:$branch"
		exec_cmd "git read-tree -mu $headid"
		exec_cmd "cd $PWDDIR"
	fi
}

check_proto_and_certification()
{
	protocol=`echo $url | awk -F "://" '{print $1}'`
	if [ "x$protocol" = "xssh" ]; then
		if [ "x$gituser" = "x" -o "x$gitpasswd" = "x" ]; then
			echo "***ERROR: Please input user and passwd"
			exit 22
		fi

		# Set url to ssh://user@hostname/path
		urlpath=`echo $url | awk -F "://" '{print $2}'`
		url="ssh://$gituser@$urlpath"

		RUN_CMD=exec_cmd_with_authentication
	fi
}

PWDDIR=`pwd`

check_proto_and_certification

if [ -d "$name" ]; then
	printf "Update exist repository: $name\n"
	update_repository
else
	printf "Create new repository: $name\n"
	create_new_repository
fi

