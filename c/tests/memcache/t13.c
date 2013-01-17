#include "common.h"

int
main(int argc, char **argv)
{
    int sd;
    int n;
    int toread;
    char writebuf[8192];
    char readbuf[1024 * 1024];
    char *str;

    sd = connect_to_server(DEFAULT_IPADDR, DEFAULT_PORT);
    assert(sd >= 0);

    str = "cas foo 0 0 3 1\r\nbar\r\n";
    printf("write: %4d: %s", strlen(str), str);
    n = write(sd, str, strlen(str));
    if (n < 0) {
        perror("write");
    }
    assert(n == strlen(str));

    n = read(sd, readbuf, 1);
    if (n < 0) {
        perror("read");
    }
    assert(n == 1);
    printf("read : %4d: %.*s", n, n, readbuf);

    if (readbuf[0] == 'S') {
        toread = strlen("STORED") + strlen("\r\n") - 1;
    } else if (readbuf[0] == 'E') {
        toread = strlen("EXISTS") + strlen("\r\n") - 1;
    } else if (readbuf[0] == 'N') {
        toread = strlen("NOT_FOUND") + strlen("\r\n") - 1;
    } else {
        assert(0);
    }

    n = readn(sd, readbuf, toread);
    if (n < 0) {
        perror("read");
    }
    assert(n > 0);
    printf("%.*s", n, readbuf);

    close(sd);

    return 0;
}
