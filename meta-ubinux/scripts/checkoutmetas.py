#!/usr/bin/env python3
import configparser 
import string, os, sys
import getpass

def checkout_repository(name, url, branch, headid, files, user, passwd):
    command = "meta-ubinux/scripts/checkoutrepos.sh"
    command = command + " " + name
    command = command + " " + url
    command = command + " " + branch
    command = command + " " + headid
    command = command + " \"" + files + "\""
    command = command + " " + user
    command = command + " " + passwd

    os.system(command)

def checkout_all_repository():
    cf = configparser.ConfigParser()
    cf.read("meta-ubinux/conf/depend.metas")
    sec = cf.sections()

    metas = cf.get("DEPEND_META", "metas")
    saved_ipstr = ''
    for meta in metas.split():
        giturl = cf.get(meta, "GITURL")
        if giturl.startswith('ssh://'):
            ipstr = giturl[6:]
            ipstr = ipstr[0:ipstr.find('/')]
            if saved_ipstr == '':
                saved_ipstr = ipstr
            if saved_ipstr != ipstr:
                print("Please make sure meta-ubinux/conf/depend.metas is correct")
                print("Please try to get all repository from [omame]")
                return

    print("------------------------------------------------------------")
    username = input('Please enter username@' + saved_ipstr + ': ')
    passwd = getpass.getpass('Password: ')
    print("------------------------------------------------------------")

    for meta in metas.split():
        giturl = cf.get(meta, "GITURL")
        branch = cf.get(meta, "BRANCH")
        headid = cf.get(meta, "HEADID")
        files  = cf.get(meta, "FILES")

        checkout_repository(meta, giturl, branch, headid, files, username, passwd)

def main():
    if len(sys.argv) == 1:
        checkout_all_repository()
    else:
        cf = configparser.ConfigParser()
        cf.read("meta-ubinux/conf/depend.metas")
        sec = cf.sections()
        metas = cf.get("DEPEND_META", "metas")

        for i in range(1, len(sys.argv)):
            for meta in metas.split():
                if sys.argv[i] == meta:
                    giturl = cf.get(meta, "GITURL")
                    branch = cf.get(meta, "BRANCH")
                    headid = cf.get(meta, "HEADID")
                    files  = cf.get(meta, "FILES")

                    if giturl.startswith('ssh://'):
                        ipstr = giturl[6:]
                        ipstr = ipstr[0:ipstr.find('/')]
                        print("------------------------------------------------------------")
                        username = input('Please enter username@' + ipstr + ': ')
                        passwd = getpass.getpass('Password: ')
                        print("------------------------------------------------------------")

                    checkout_repository(meta, giturl, branch, headid, files, username, passwd)

if __name__ == "__main__":
    try:
        ret = main()
    except Exception:
        ret = 1
        import traceback
        traceback.print_exc(5)
    sys.exit(ret)

