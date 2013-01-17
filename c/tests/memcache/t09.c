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

    memset(readbuf, 'r', sizeof(writebuf));

    str = "set bar 0 0 8192\r\n";
    printf("write: %4d: %s", strlen(str), str);
    n = writen(sd, str, strlen(str));
    if (n < 0) {
        perror("write");
    }
    assert(n == strlen(str));

    memset(writebuf, 'b', sizeof(writebuf));
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

    str = "set foo 0 0 8192\r\n";
    printf("write: %4d: %s", strlen(str), str);
    n = writen(sd, str, strlen(str));
    if (n < 0) {
        perror("write");
    }
    assert(n == strlen(str));

    memset(writebuf, 'f', sizeof(writebuf));
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

    toread = strlen("STORED") + strlen("\r\n") +
        strlen("STORED") + strlen("\r\n") + 
        strlen("VALUE foo 0 8192\r\n") + 8192 + strlen("\r\n") +
        strlen("VALUE bar 0 8192\r\n") + 8192 + strlen("\r\n") +
        strlen("END\r\n");
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
