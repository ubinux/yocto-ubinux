inherit  multilib_header

do_install:append(){
	oe_multilib_header unixodbc.h unixODBC/config.h unixODBC/unixodbc_conf.h
}