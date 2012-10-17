package com.mycompany.app;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Hello world!
 */
public final class App {

    private App() {
    }

    public static void main(String[] args) {

        List<Integer> list = Lists.newArrayList();

        list.add(12);
        list.add(13);
        System.out.println("list: " + list);

        List<String> listString = Lists.transform(list, new Function<Integer, String>() {
            public String apply(Integer i) {
                return "m" + i.toString();
            }
        });
        System.out.println("listString: " + listString);

        List<Integer> singelElementList = Collections.singletonList(100);
        System.out.println("singleElementList: " + singelElementList);

        Map<String, Integer> map = Maps.newHashMapWithExpectedSize(12);

        map.put("foo", 3);
        map.put("bar", 3);
        map.put("foobar", 6);

        System.out.println("Print map: " + map);
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();

            System.out.println(key + " -> " + value);

        }

        ByteBuffer bb1 = ByteBuffer.wrap("Hello".getBytes());
        ByteBuffer bb2 = ByteBuffer.wrap("Hello".getBytes());

        if (bb1 != bb2) {
            System.out.println("bb1 != bb2");
        } else {
            System.out.println("bb1 == bb2");
        }
        System.out.println("value = " + bb1.compareTo(bb2));

        AppHelper appHelper = new AppHelper();
        System.out.println("appHelper => strList: " + appHelper.strList + " intList: " + appHelper.intList);

        final int numThreads = 10;
        ExecutorService executorService =
                Executors.newFixedThreadPool(numThreads, new ThreadFactoryBuilder().build());

        for (int i = 0; i < numThreads; i++) {
            executorService.submit(new AppThread());
        }
    }
}
