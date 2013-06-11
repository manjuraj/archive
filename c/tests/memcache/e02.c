#include "common.h"

int
main(int argc, char **argv)
{
    int sd;
    int n;
    char buf[37372];
    char bigbuf[8 * 1024 * 1024];

    sd = connect_to_server(DEFAULT_IPADDR, 22123);
    assert(sd >= 0);

    memset(buf, 'r', sizeof(buf));

    sprintf(bigbuf, "set bar1 0 0 37372\r\n%s\r\nset foo2 0 0 37372\r\n%s\r\n", buf, buf);
    printf("write: %4d", strlen(bigbuf));
    n = writen(sd, bigbuf, strlen(bigbuf));
    if (n < 0) {
        perror("write");
    }
    assert(n == strlen(bigbuf));

    sleep(2);

    close(sd);

    return 0;
}
