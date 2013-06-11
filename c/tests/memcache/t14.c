#include "common.h"

int
main(int argc, char **argv)
{
    int sd;
    int n;
    int toread, a, b;
    char *str;
    char writebuf[8192 + 2];
    char readbuf[1024 * 1024];

    sd = connect_to_server(DEFAULT_IPADDR, DEFAULT_PORT);
    assert(sd >= 0);

    n = set_linger(sd, 2);
    assert(n == 0);

    memset(readbuf, 'r', sizeof(writebuf));

    str = "set bar 0 0 8192 \r\n";
    printf("write: %4d: %s", strlen(str), str);
    n = writen(sd, str, strlen(str));
    if (n < 0) {
        perror("write");
    }
    assert(n == strlen(str));

    memset(writebuf, 'b', 8192);
    writebuf[8192] = '\r';
    writebuf[8192 + 1] = '\n';
    printf("write: .<8192>\r\n");
    n = writen(sd, writebuf, sizeof(writebuf));
    if (n < 0) {
        perror("write");
    }
    assert(n == sizeof(writebuf));

    str = "set foo 0 0 8192 \r\n";
    printf("write: %4d: %s", strlen(str), str);
    n = writen(sd, str, strlen(str));
    if (n < 0) {
        perror("write");
    }
    assert(n == strlen(str));

    memset(writebuf, 'f', 8192);
    writebuf[8192] = '\r';
    writebuf[8192 + 1] = '\n';
    printf("write: .<8192>\r\n");
    n = writen(sd, writebuf, sizeof(writebuf));
    if (n < 0) {
        perror("write");
    }
    assert(n == sizeof(writebuf));

    str = "set foofoo 0 0 8192 \r\n";
    printf("write: %4d: %s", strlen(str), str);
    n = writen(sd, str, strlen(str));
    if (n < 0) {
        perror("write");
    }
    assert(n == strlen(str));

    memset(writebuf, '2', 8192);
    writebuf[8192] = '\r';
    writebuf[8192 + 1] = '\n';
    printf("write: .<8192>\r\n");
    n = writen(sd, writebuf, sizeof(writebuf));
    if (n < 0) {
        perror("write");
    }
    assert(n == sizeof(writebuf));

    str = "set barbar 0 0 8192 \r\n";
    printf("write: %4d: %s", strlen(str), str);
    n = writen(sd, str, strlen(str));
    if (n < 0) {
        perror("write");
    }
    assert(n == strlen(str));

    memset(writebuf, '3', 8192);
    writebuf[8192] = '\r';
    writebuf[8192 + 1] = '\n';
    printf("write: .<8192>\r\n");
    n = writen(sd, writebuf, sizeof(writebuf));
    if (n < 0) {
        perror("write");
    }
    assert(n == sizeof(writebuf));

    str = "get foo bar foofoo barbar \r\n";
    printf("write: %4d: %s", strlen(str), str);
    n = writen(sd, str, strlen(str));
    if (n < 0) {
        perror("write");
    }
    assert(n == strlen(str));

    n = shutdown(sd, SHUT_WR);
    assert(n == 0);

    return 0;
}
