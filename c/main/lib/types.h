#ifndef _TYPES_H_
#define _TYPES_H_

#include "bool.h"

typedef signed char s08bits;
typedef unsigned char u08bits;

typedef signed short int s16bits;
typedef unsigned short int u16bits;

typedef signed long int s32bits;
typedef unsigned long int u32bits;

typedef signed long long s64bits;
typedef unsigned long long u64bits;

#define offsetof(TYPE, MEMBER) ((size_t) &((TYPE *) 0)->MEMBER)

#endif
