import com.google.common.base.Functions;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.ImmutableMap
import com.google.common.collect.ImmutableList
import com.google.common.collect.ImmutableSet;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Iterables;
import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.common.collect.Sets;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;

import java.lang.StringBuilder;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.TimeUnit;

import com.twitter.common.collections.Pair;

import com.twitter.util.Duration;
import com.twitter.util.Function;
import com.twitter.util.Function0;
import com.twitter.util.Future;
import com.twitter.util.Promise;
import com.twitter.util.Return;

import org.apache.commons.codec.binary.Hex
import org.apache.thrift.TException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@Test
@Override
@Nullable
@Provides

@NotNull
@CmdLine

@Inject
@VisibleForTesting

String.valueOf(Object)
String.format("Hello %s", "world")

Boolean.toString(value);
Boolean.parseBoolean(boolString);

Long.toString(value);
Long.parseLong(longString);
Long.MAX_VALUE;

Integer.parseInt(intString);
Integer.toString(value);

long ts = System.currentTimeMillis();
long ts = System.nanoTime();

long msec = TimeUnit.SECONDS.toMillis(secs);

Random rand = new Random();
int randInt = rand.nextInt(size);

AtomicBoolean bool = new AtomicBoolean(true);
AtomicInteger integer = new AtomicInteger(0);
AtomicReference<T> reference = Atomics.newReference(null);

AtomicBoolean bool = new AtomicBoolean(true);
AtomicReference<T> reference = new AtomicReference<T>();

List<T> list = Lists.newArrayList();
List<T> list = Lists.newArrayListWithExpectedSize(expectedSize);

Map<T> map = Maps.newConcurrentMap();
HashMultiMap<K, V> multimap = HashMultiMap.create();

Set<T> set = Sets.newLinkedHashSet();
Set<T> set = Sets.newHashSet();

List<T> list = Collections.emptyList();
Set<T> set = Collections.emptySet();

Set<T> list = Collections.singleton(T);
List<T> list = Collections.singletonList(T);

List<T> list = new ArrayList<T>();
List<T> list = new ArrayList<T>(size);

for (Map.Entry<T> entry : entries) {
}

for (Map.Entry<K, V> entry : map.entrySet()) {
  K key = entry.getKey();
  V value = entry.getValue();
}

Comparator<MyClass> comparator = new Comparator<MyClass>() {
  @Override
  public int compare(MyClass first, MyClass second) {
    if (first.getValue() < second.getValue()) {
      return -1;
    } else if (first.getValue() > second.getValue()) {
      return 1;
    } else {
      return 0;
    }
  }
};

/**
 * MyClass, MyObject in myapp
 *
 */
package com.mycompany.myapp

import ...

public static class MyObject {}
public class MyClass {}
public class MyClass extends MySuperClass {
  private static final Logger LOG = LoggerFactory.getLogger(MyClass.class);
  private final static int HEADER_SIZE = 1024;
  private final ByteBuffer HEADER = ByteBuffer.allocate(HEADER_SIZE);
  private int myInt;

  public MyClass() {
    super();
    myInt = 2;
  }

  public MyClass(int myInt) {
    if (myInt <= 0) {
      throw new IllegalArgumentException();
    }
    this();
    this.myInt = myInt;
    LOG.info("runnning with myInt: {}", myInt);
  }
}

private static final String HELLO_MESSAGE = "Hello World";
private final String msg;

public class MyException extends Exception {
  public MyException(String message) {
    super(message);
  }

  public MyException(String message, Throwable cause) {
    super(message, cause)
  }

  public MyException(Throwable cause) {
    super(cause)
  }
}
