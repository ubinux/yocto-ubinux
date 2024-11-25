#!/usr/bin/env python3
import configparser 
import string, os, sys
import getpass
import glob
import subprocess

def checkout_repository(name, url, branch, headid, files):
    command = "meta-ubinux/scripts/checkoutrepos.sh"
    command = command + " " + name
    command = command + " " + url
    command = command + " " + branch
    command = command + " " + headid
    command = command + " \"" + files + "\""

    os.system(command)

def checkout_all_repository():
    cf = configparser.ConfigParser()
    cf.read("meta-ubinux/conf/depend.metas")
    sec = cf.sections()

    metas = cf.get("DEPEND_META", "metas")
    saved_ipstr = ''

    for meta in metas.split():
        giturl = cf.get(meta, "GITURL")
        branch = cf.get(meta, "BRANCH")
        headid = cf.get(meta, "HEADID")
        files  = cf.get(meta, "FILES")

        checkout_repository(meta, giturl, branch, headid, files)

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

                    checkout_repository(meta, giturl, branch, headid, files)

    patch_files = glob.glob(os.path.join(r"./patches-layers", "*.patch"))
    if not patch_files:
        print(f"No patch files found in ./patches-layers")
        return

    for patch_file in patch_files:
        try:
            print(f"Applying patch: {patch_file}")
            result = subprocess.run(['patch', '-p0', '-i', patch_file], capture_output=True, text=True, check=True, cwd="./")
            print(result.stdout) #Print successful patch application output

        except subprocess.CalledProcessError as e:
            print(f"Error applying patch {patch_file}:")
            print(e.stderr)
            return False #Fail if any patch application fails
        except FileNotFoundError:
            print(f"Error: patch utility not found. Please ensure 'patch' is installed and in your PATH.")
            return False

if __name__ == "__main__":
    try:
        ret = main()
    except Exception:
        ret = 1
        import traceback
        traceback.print_exc(5)
    sys.exit(ret)

