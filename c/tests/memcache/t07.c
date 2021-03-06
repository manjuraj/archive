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

    str = "set foo 0 0 3\r\n333\r\n";
    printf("write: %4d: %s", strlen(str), str);
    n = write(sd, str, strlen(str));
    if (n < 0) {
        perror("write");
    }
    assert(n == strlen(str));

    str = "set bar 0 0 4\r\n4444\r\n";
    printf("write: %4d: %s", strlen(str), str);
    n = write(sd, str, strlen(str));
    if (n < 0) {
        perror("write");
    }
    assert(n == strlen(str));

    str = "get foo bar\r\n";
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
