PACKAGECONFIG:append = " fips "

EXTRA_OECONF:remove = " \
    --enable-openssl-compatibility \
"
EXTRA_OECONF += " \
    --disable-openssl-compatibility \
"
