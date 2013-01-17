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

    str = "get foo bar\r\n";
    printf("write: %4d: %s", strlen(str), str);
    n = write(sd, str, strlen(str));
    if (n < 0) {
        perror("write");
    }
    assert(n == strlen(str));

    close(sd);

    return 0;
}
