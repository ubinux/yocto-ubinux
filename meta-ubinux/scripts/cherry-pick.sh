#!/bin/sh

no_msg_command()
{
	local cmd="$1"
	local savederr=

	printf "\t%-70s"  "Execute [$cmd]:"
	$cmd >> "$LOGFILE" 2>&1
	savederr=$?
	if [ "x$savederr" != "x0" ]; then
		printf "NG\n"
	else
		printf "OK\n"
	fi
	return $savederr
}

exec_command()
{
	local cmd="$1"
	local savederr=

	printf "\t%-70s"  "Execute [$cmd]:"
	$cmd
	savederr=$?
	if [ "x$savederr" != "x0" ]; then
		printf "NG\n"
	else
		printf "OK\n"
	fi
	return $savederr
}

do_cherry_pick()
{
	echo "X. Save the current branch"
	curbranch=`git branch | grep "^\*" | awk '{print $2}'`

	echo "X. Get commits from source branch [$ORIG_BRANCH]"
	no_msg_command "git checkout $ORIG_BRANCH"
	if [ "x$?" != "x0" ]; then
		return 1;
	fi

	printf "\t%-70s" "get commits of [$AUTHOR] since [$SINCE]"
	COMMITS=`git log --author="$AUTHOR" --no-merges --after="{$SINCE}" | grep "^commit" | awk '{print $2}'`
	savederr="$?"
	if [ "x$savederr" != "x0" ]; then
		printf "NG\n"

		echo "X. Restore to branch [$curbranch]"
		no_msg_command "git checkout $curbranch"
	elif [ "x$COMMITS" = "x" ]; then
		printf "No commit\n"

		echo "X. Restore to branch [$curbranch]"
		no_msg_command "git checkout $curbranch"
	else
		printf "OK\n"
		echo "$COMMITS" >> "$LOGFILE"
		COMMITS=`echo $COMMITS | awk '{for(i=NF; i>0; i--) print $i}'`

		no_msg_command "git checkout $curbranch"
		if [ "x$?" = "x0" ];then
			echo "X. cherry-pick commits: obtain details from detail logfile [$LOGFILE]"
			printf "\t%-70s" "git cherry-pick COMMITS"
			git cherry-pick $COMMITS >> "$LOGFILE"  2>&1
			if [ "x$?" != "x0" ]; then
				no_msg_command "git cherry-pick --abort"
				printf "NG\n"
			else
				printf "OK\n"
			fi
		fi
	fi
}

if [ "x$#" != "x3" ];then
	echo "Usage: cherry-pick \$branch \$after \$author"
	echo "		\$branch: which branch you want get commit from"
	echo "		\$after:  the commits after \$after will be cherry-pick-ed, such as 2014-11-1"
	echo "		\$author: specify whose patch will be cherry-pick-ed."
	exit
fi

ORIG_BRANCH="$1"
SINCE="$2"
AUTHOR="$3"

LOGFILE=`echo $AUTHOR | awk '{print $1}'`-$SINCE.log
rm -rf "$LOGFILE"
touch "$LOGFILE"

do_cherry_pick

echo "X. Please Obtain Detail From Log [$LOGFILE]"
