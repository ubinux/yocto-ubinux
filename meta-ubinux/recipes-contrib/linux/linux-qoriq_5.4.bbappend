FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI_append = "file://0001-perf-bench-Share-some-global-variables-to-fix-build-with-gcc.patch \
                  file://0001-perf-tests-bp-account-Make-global-variable-static.patch \
                  file://0001-perf-cs-etm-Move-definition-of-traceid_list-global-v.patch \
                  file://libtraceevent-fix-build-with-binutils-25.patch \
                 "
