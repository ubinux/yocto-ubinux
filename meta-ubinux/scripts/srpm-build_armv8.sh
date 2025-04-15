#!/bin/bash
bitbake libevent -f -c deploy_archives
bitbake swupdate -f -c deploy_archives
bitbake restool -f -c deploy_archives
bitbake openjdk-8 -f -c deploy_archives
bitbake giflib -f -c deploy_archives
bitbake libiodbc -f -c deploy_archives
bitbake pgpool2 -f -c deploy_archives
bitbake psqlodbc -f -c deploy_archives
bitbake unixodbc -f -c deploy_archives
bitbake libmemcached -f -c deploy_archives
bitbake libubootenv -f -c deploy_archives
