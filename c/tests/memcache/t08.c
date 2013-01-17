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

    memset(writebuf, 'w', sizeof(writebuf));
    memset(readbuf, 'r', sizeof(writebuf));

    str = "delete bar noreply\r\n";
    printf("write: %4d: %s", strlen(str), str);
    n = writen(sd, str, strlen(str));
    if (n < 0) {
        perror("write");
    }
    assert(n == strlen(str));

    str = "set foo 0 0 8192 noreply\r\n";
    printf("write: %4d: %s", strlen(str), str);
    n = writen(sd, str, strlen(str));
    if (n < 0) {
        perror("write");
    }
    assert(n == strlen(str));

    printf("write: .<8192>\r\n");
    n = writen(sd, writebuf, 8192);
    if (n < 0) {
        perror("write");
    }
    assert(n == 8192);

    str = "\r\n";
    printf("write: %4d: %s", strlen(str), str);
    n = writen(sd, str, strlen(str));
    if (n < 0) {
        perror("write");
    }
    assert(n == strlen(str));

    str = "get foo bar\r\n";
    printf("write: %4d: %s", strlen(str), str);
    n = writen(sd, str, strlen(str));
    if (n < 0) {
        perror("write");
    }
    assert(n == strlen(str));

    toread = strlen("VALUE foo 0 8192\r\n\r\nEND\r\n") + 8192;
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
