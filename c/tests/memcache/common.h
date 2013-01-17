#ifndef _COMMON_H_
#define _COMMON_H_

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdint.h>
#include <stdbool.h>
#include <inttypes.h>
#include <math.h>

#include <unistd.h>
#include <fcntl.h>
#include <signal.h>
#include <errno.h>
#include <getopt.h>
#include <stdarg.h>
#include <assert.h>
#include <time.h>
#include <getopt.h>

#include <sys/types.h>
#include <sys/time.h>
#include <sys/resource.h>
#include <sys/socket.h>
#include <sys/ioctl.h>
#include <sys/epoll.h>
#include <sys/uio.h>

#include <netinet/in.h>
#include <netinet/tcp.h>
#include <arpa/inet.h>

#define DEFAULT_IPADDR  "127.0.0.1"
#define DEFAULT_PORT    22122

static int
connect_to_server(char *addr, uint16_t port)
{
    int sd;
    int status;
    struct sockaddr_in sockaddr;
    socklen_t socklen;

    sd = socket(AF_INET, SOCK_STREAM, 0);
    if (sd < 0) {
        perror("socket");
        return sd;
    }

    socklen = sizeof(sockaddr);
    memset(&sockaddr, 0, socklen);

    sockaddr.sin_family = AF_INET;
    sockaddr.sin_port = htons(port);

    status = inet_aton(addr, &sockaddr.sin_addr);
    if (status == 0) {
        perror("inet_aton");
        return -1;
    }

    status = connect(sd, (struct sockaddr *)&sockaddr, socklen);
    if (status != 0) {
        perror("connect");
        return -1;
    }

    return sd;
}

/*
 * write n bytes to a descriptor
 */
ssize_t
writen(int fd, const void *vptr, size_t n)
{
    size_t nleft;
    ssize_t	nwritten;
    const char *ptr;

    ptr = vptr;
    nleft = n;
    while (nleft > 0) {
        nwritten = write(fd, ptr, nleft);
        if (nwritten < 0) {
            if (errno == EINTR) {
                continue; /* call write again */
            }
            return nwritten;
        }
        if (nwritten == 0) {
            return -1;
        }

        nleft -= nwritten;
        ptr += nwritten;
    }

    return n;
}

/*
 * read n bytes from a descriptor
 */
ssize_t
readn(int fd, void *vptr, size_t n)
{
	size_t nleft;
	ssize_t	nread;
	char *ptr;

	ptr = vptr;
	nleft = n;
	while (nleft > 0) {
        nread = read(fd, ptr, nleft);
        if (nread < 0) {
            if (errno == EINTR) {
                continue; /* call read again */
            }
            return nread;
        }
        if (nread == 0) { /* eof */
            break;
        }

        nleft -= nread;
        ptr += nread;
    }

    return (n - nleft);
}

int
set_linger(int sd, int time)
{
    struct linger linger;

    linger.l_onoff = 1;
    linger.l_linger = time;

    return setsockopt(sd, SOL_SOCKET, SO_LINGER, (const void *)&linger, sizeof(linger));
}

#endif
