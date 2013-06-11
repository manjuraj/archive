package com.mycompany.app;

<<<<<<< HEAD
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.nio.ByteBuffer;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class App {

    public App() {
=======
import com.google.common.base.Function;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.primitives.UnsignedBytes;
import org.apache.commons.io.HexDump;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentSkipListMap;

public final class App {
    private static final Exception e = new RuntimeException("foo runtime exception");
    private static final Logger LOG = LoggerFactory.getLogger(App.class);

    private static final Comparator<byte[]> BYTES_COMPARATOR = UnsignedBytes.lexicographicalComparator();
    public App() {
        LOG.error("I am in App ctor 1: {0} 2: {1} 3: {2}", new Object[]{"manju", "hector", "anirudh"}, e);
>>>>>>> d0e475ec90108a27e704befeed2c604892f3600b
    }

    private String dumpHex(ByteBuffer byteBuffer) {
        byte[] byteArray = new byte[byteBuffer.remaining()];
        byteBuffer.duplicate().get(byteArray);

        String out = "";
        for (int i = 0; i < byteArray.length; i++) {
            if (i > 0) {
                out += " ";
            }
            out += String.format("%02X", byteArray[i] & 0xFF);
        }

        return out;
    }

<<<<<<< HEAD

    private void byteBuffer() {
        ByteBuffer b1 = ByteBuffer.allocate(8).putDouble(10.6);
        ByteBuffer b2 = ByteBuffer.allocate(8).putDouble(10.5);
        b1.rewind();
        b2.rewind();
=======
    private void formatter() {
        Double d = 0.0000000222333232232;
        System.out.println(String.format("%g", d));
    }

    private void concurrentSkipListMap() {
        // Store the map in the natural order of its keys
        Map<Integer, String> map = new ConcurrentSkipListMap<Integer, String>();

        map.put(3, "three");
        map.put(1, "one");
        map.put(2, "two");

        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }

    private void iterables() {
        List<Integer> l = Lists.newArrayList();
        l.add(1);
        l.add(100);
        l.add(10);

        System.out.println(Iterables.getLast(l) + " <--> " + l.get(l.size() - 1));

    }
    private void byteBuffer() {
        ByteBuffer b01 = ByteBuffer.allocate(8).putLong(1L);
        ByteBuffer b02 = ByteBuffer.allocate(8).putLong(2L);
        b01.rewind();
        b02.rewind();
        System.out.println("ByteBuffer dump: " + dumpHex(b01) + " : " + dumpHex(b02));

        Long l1 = 1L;
        Long l2 = 2L;
        Double d1 = l1.doubleValue();
        Double d2 = l2.doubleValue();
        System.out.println("Long: " + l1 + " Double: " + d1);
        System.out.println("Long: " + l2 + " Double: " + d2);

        ByteBuffer b1 = ByteBuffer.allocate(8).putDouble(l1);
        ByteBuffer b2 = ByteBuffer.allocate(8).putDouble(l2);
        b1.rewind();
        b2.rewind();
        System.out.println("ByteBuffer dump: " + dumpHex(b1) + " : " + dumpHex(b2));
>>>>>>> d0e475ec90108a27e704befeed2c604892f3600b

        boolean equal;
        equal = b1.equals(b2);
        System.out.println("ByteBuffer equals: " + dumpHex(b1) + " : " + dumpHex(b2) + " => " + equal);
        int compare = b1.compareTo(b2);
        System.out.println("ByteBuffer compareTo: " + dumpHex(b1) + " : " + dumpHex(b2) + " => " + compare);
        System.out.println(b1.compareTo(b2));

        ByteBuffer b3 = ByteBuffer.allocate(100);
        b3.put("0123".getBytes());
        System.out.println("Peeking into ByteBuffer: " + b3);
        b3.clear();
        System.out.println("Peeking into ByteBuffer: " + b3);
        b3.put("0123".getBytes());
        b3.mark();
        b3.put("4567".getBytes());
        System.out.println("Peeking into ByteBuffer with mark set: " + b3);
        b3.reset();
        System.out.println("Peeking into ByteBuffer with reset called: " + b3);

<<<<<<< HEAD
        ByteBuffer b4 = ByteBuffer.allocate(6);
        b4.put("1234".getBytes());
        b4.rewind();
        System.out.println("ByteBuffer = " + b4 + " asDoubleBuffer = " + b4.asDoubleBuffer().get());

=======
        ByteBuffer b4 = ByteBuffer.allocate(10);
        b4.put("12345".getBytes());
        byte[] b4Array = b4.array();
        System.out.println("Array backing Bytebuffer: ");
        try {
            HexDump.dump(b4Array, 0L, System.out, 0);
        } catch (IOException ioe) {
            System.out.println("caught ioexception: " + ioe);
        }
>>>>>>> d0e475ec90108a27e704befeed2c604892f3600b
    }

    private void list() {
        System.out.println("List:");

        List<Integer> l1 = Lists.newArrayList(0, 1, 2, 3, 4, 5);
        List<Integer> l2 = Lists.newArrayList(l1.subList(0, 3));

<<<<<<< HEAD
        System.out.println(l2);
=======
        List<String> listString = Lists.transform(l1, new Function<Integer, String>() {
            public String apply(Integer i) {
                return "m" + i.toString();
            }
        });
        System.out.println("listString: " + listString);

>>>>>>> d0e475ec90108a27e704befeed2c604892f3600b
    }

    private void maps() {
        System.out.println("LinkedHashMap:");

        Map<Integer, String> m1 = Maps.newLinkedHashMap();
        m1.put(10, "ten");
        m1.put(9, "nine");
        m1.put(11, "eleven");
        m1.put(9, "nine");
        m1.put(0, null);
        m1.put(11, "eleven'");
        m1.get(9);
        m1.put(null, "null");
        System.out.println("Iterate over m1 in insertion-order:");
        for (Map.Entry<Integer, String> entry : m1.entrySet()) {
            System.out.println(entry.getKey() + "  -> " + entry.getValue());
        }

        System.out.println("Iterate over m2 in access-order - LRU to MRU:");
        Map<Integer, String> m2 = new LinkedHashMap<Integer, String>(20, 0.80f, true);
        m2.put(10, "ten");
        m2.put(9, "nine");
        m2.put(11, "eleven");
        m2.put(9, "nine");
        m2.put(0, null);
        m2.put(11, "eleven'");
        m2.get(9);
        m2.put(null, "null");
        for (Map.Entry<Integer, String> entry : m2.entrySet()) {
            System.out.println(entry.getKey() + "  -> " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        App app = new App();

<<<<<<< HEAD
=======
        app.iterables();

        System.exit(1);
        app.concurrentSkipListMap();

        app.formatter();
>>>>>>> d0e475ec90108a27e704befeed2c604892f3600b
        app.byteBuffer();
//        app.list();
//        app.maps();
//
<<<<<<< HEAD
=======

>>>>>>> d0e475ec90108a27e704befeed2c604892f3600b
//        List<Integer> list = Lists.newArrayList();
//
//        list.add(12);
//        list.add(13);
//        System.out.println("list: " + list);
//
//        List<String> listString = Lists.transform(list, new Function<Integer, String>() {
//            public String apply(Integer i) {
//                return "m" + i.toString();
//            }
//        });
//        System.out.println("listString: " + listString);
//
//        List<Integer> singelElementList = Collections.singletonList(100);
//        System.out.println("singleElementList: " + singelElementList);
//
//        Map<String, Integer> map = Maps.newHashMapWithExpectedSize(12);
//
//        map.put("foo", 3);
//        map.put("bar", 3);
//        map.put("foobar", 6);
//
//        System.out.println("Print map: " + map);
//        for (Map.Entry<String, Integer> entry : map.entrySet()) {
//            String key = entry.getKey();
//            Integer value = entry.getValue();
//
//            System.out.println(key + " -> " + value);
//
//        }
//
//        ByteBuffer bb1 = ByteBuffer.wrap("Hello".getBytes());
//        ByteBuffer bb2 = ByteBuffer.wrap("Hello".getBytes());
//
//        if (bb1 != bb2) {
//            System.out.println("bb1 != bb2");
//        } else {
//            System.out.println("bb1 == bb2");
//        }
//        System.out.println("value = " + bb1.compareTo(bb2));
//
//        AppHelper appHelper = new AppHelper();
//        System.out.println("appHelper => strList: " + appHelper.strList + " intList: " + appHelper.intList);
//
//        final int numThreads = 10;
//        ExecutorService executorService =
//                Executors.newFixedThreadPool(numThreads, new ThreadFactoryBuilder().build());
//
//        for (int i = 0; i < numThreads; i++) {
//            executorService.submit(new AppThread());
//        }
    }
}
