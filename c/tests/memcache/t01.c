#include "common.h"

int
main(int argc, char **argv)
{
    int sd;
    int n;
    char buf[1024];
    char *str;

    sd = connect_to_server(DEFAULT_IPADDR, DEFAULT_PORT);
    assert(sd >= 0);

    close(sd);

    return 0;
}
