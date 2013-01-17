#include "common.h"

int
main(int argc, char **argv)
{
    int sd;
    int toread;
    int n;
    char writebuf[8192];
    char readbuf[1024 * 1024];
    char *str;

    sd = connect_to_server(DEFAULT_IPADDR, DEFAULT_PORT);
    assert(sd >= 0);

    str = "get foofoo barbar foofoofoo barbarbar foofoofoofoo barbarbarbar foofoofoofoofoo barbarbarbar foofoofoofoofoo barbarbarbarbar foofoofoofoofoofoo barbarbarbarbarbar foofoofoofoofoofoofoo barbarbarbarbarbarbar foofoofoofoofoofoofoofoo barbarbarbarbarbarbar\r\n";
    printf("write: %4d: %s", strlen(str), str);
    n = writen(sd, str, strlen(str));
    if (n < 0) {
        perror("write");
    }
    assert(n == strlen(str));

    toread = strlen("END") + strlen("\r\n");
    n = readn(sd, readbuf, toread);
    if (n < 0) {
        perror("read");
    }
    assert(n > 0);
    assert(n == toread);
    printf("read : %4d: %.*s", n, n, readbuf);

    close(sd);

    return 0;
}
