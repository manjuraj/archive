#ifndef _DEBUG_H_
#define _DEBUG_H_

#include <stdio.h>

#define __DEBUG

#ifdef __DEBUG

/*
 * ASSERT
 *  - asserts, when boolean condition '__x' is true
 */
#define ASSERT(__x) do {            \
  if (!(__x)) {                     \
    fprintf(stderr, "[ASSERT] Assertion '%s' failed @ (%s, %d)\n",\
        #__x, __FILE__, __LINE__);  \
    fflush(stderr);                 \
  }                                 \
} while(0)

#else

#define ASSERT(x) do{ } while(0)

#endif

/* interfaces */
void hex_dump(u32bits ofs, const void *buf_, size_t size, bool ascii);
#endif

