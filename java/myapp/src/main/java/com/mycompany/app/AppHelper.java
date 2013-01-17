package com.mycompany.app;

import com.google.common.collect.Lists;

import java.util.List;

public class AppHelper {

    public final List<Integer> intList;
    public List<String> strList;

    public AppHelper() {
        intList = Lists.newArrayList();
    }

    public AppHelper(int size) {
        intList = Lists.newArrayListWithCapacity(size);
    }
}
