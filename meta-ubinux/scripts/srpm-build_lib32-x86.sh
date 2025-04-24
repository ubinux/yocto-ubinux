#!/bin/bash
bitbake lib32-open-iscsi-user -f -c deploy_archives
bitbake lib32-jssocket -f -c deploy_archives
bitbake  lib32-libjs-jquery-cookie -f -c deploy_archives
bitbake  lib32-libjs-jquery-custom-scrollbar -f -c deploy_archives
bitbake  lib32-libjs-jquery-dropkick -f -c deploy_archives
bitbake  lib32-libjs-jquery-globalize -f -c deploy_archives
bitbake  lib32-libjs-jquery-icheck -f -c deploy_archives
bitbake  lib32-libjs-jquery-mousewheel -f -c deploy_archives
bitbake  lib32-libjs-jquery-ui -f -c deploy_archives
bitbake  lib32-smarty -f -c deploy_archives
bitbake  lib32-apcupsd -f -c deploy_archives
