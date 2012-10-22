package com.mycompany.app;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.nio.ByteBuffer;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class App {

    public App() {
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


    private void byteBuffer() {
        ByteBuffer b1 = ByteBuffer.allocate(8).putDouble(10.6);
        ByteBuffer b2 = ByteBuffer.allocate(8).putDouble(10.5);
        b1.rewind();
        b2.rewind();

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

        ByteBuffer b4 = ByteBuffer.allocate(6);
        b4.put("1234".getBytes());
        b4.rewind();
        System.out.println("ByteBuffer = " + b4 + " asDoubleBuffer = " + b4.asDoubleBuffer().get());

    }

    private void list() {
        System.out.println("List:");

        List<Integer> l1 = Lists.newArrayList(0, 1, 2, 3, 4, 5);
        List<Integer> l2 = Lists.newArrayList(l1.subList(0, 3));

        System.out.println(l2);
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

        app.byteBuffer();
//        app.list();
//        app.maps();
//
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
