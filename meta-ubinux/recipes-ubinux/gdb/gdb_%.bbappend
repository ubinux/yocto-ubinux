DEPENDS += "readline7"
CPPFLAGS += "-I${STAGING_INCDIR}/readline7"
LDFLAGS += "-L${STAGING_LIBDIR}/readline7"

TARGET_CFLAGS_append = " -Wl,-rpath,${libdir}/readline7"

