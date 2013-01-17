# Makefile
# @author: manj@cs.stanford.edu

CC = gcc
LIBS =
CFLAGS = -O -Wall -g -Wno-pointer-sign
LDFLAGS = -g
PFLAGS =

main_SRCS = main.c
main_OBJS = $(patsubst %.c, %.o, $(main_SRCS))
main_DEPS = $(patsubst %.c, .%.d, $(main_SRCS))

lib_SRCS = bitmap.c debug.c
lib_OBJS = $(patsubst %.c, lib/%.o, $(lib_SRCS))

.PHONY: all
all: main

$(main_OBJS): %.o : %.c
	$(CC) -c $(CFLAGS) $< -o $@

$(main_DEPS): .%.d : %.c
	$(CC) -MM $(CFLAGS) $< > $@

$(lib_OBJS):
	$(MAKE) -C lib

include $(main_DEPS)

main: $(main_OBJS) $(lib_OBJS)
	$(CC) $(CFLAGS) -o main $(main_OBJS) $(lib_OBJS) $(LIBS)

.PHONY: clean
clean:
	- rm -f *.o *~ core *.dump *.tar main
