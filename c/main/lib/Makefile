lib_SRCS = bitmap.c debug.c list.c hash.c
lib_OBJS = $(patsubst %.c, %.o, $(lib_SRCS))
lib_DEPS = $(patsubst %.c, .%.d, $(lib_SRCS))

.PHONY: all
all: lib

$(lib_OBJS): %.o : %.c
	$(CC) -c $(CFLAGS) $< -o $@

$(lib_DEPS): .%.d : %.c
	$(CC) -MM $(CFLAGS) $< > $@

include $(lib_DEPS)

lib: $(lib_OBJS)

.PHONY: clean
clean:
	- rm -f *.o *~ core *.dump *.tar
