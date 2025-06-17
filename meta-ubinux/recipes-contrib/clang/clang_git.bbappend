inherit multilib_header

do_install:append() {
    # Used for generating config files on target
    oe_multilib_header llvm/Config/llvm-config.h clang/Config/config.h
}
