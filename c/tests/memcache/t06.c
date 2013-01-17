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

    str = "get foo bar foobar foofoobar foofoobarbar foofoofoobarbar foofoofoobarbarbar\r\n";
    printf("write: %4d: %s", strlen(str), str);
    n = write(sd, str, strlen(str));
    if (n < 0) {
        perror("write");
    }
    assert(n == strlen(str));

    n = read(sd, buf, sizeof(buf));
    if (n < 0) {
        perror("read");
    }
    assert(n > 0);
    printf("read : %4d: %.*s", n, n, buf);

    close(sd);

    return 0;
}
