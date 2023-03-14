inherit  multilib_header

do_install:append(){
	oe_multilib_header pg_config.h pg_config_ext.h ecpg_config.h postgresql/server/pg_config.h postgresql/server/pg_config_ext.h
}
