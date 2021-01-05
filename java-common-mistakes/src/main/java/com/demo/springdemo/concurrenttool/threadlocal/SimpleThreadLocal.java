package com.demo.springdemo.concurrenttool.threadlocal;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class SimpleThreadLocal {

    private Map valueMap = Collections.synchronizedMap(new HashMap<>());

    public void set(Object newValue) {
        // 1. 键为线程对象，值为本线程的变量副本
        valueMap.put(Thread.currentThread(), newValue);
    }

    public Object get() {
        Thread currentThread = Thread.currentThread();
        // 2. 返回本线程对应的变量
        Object o = valueMap.get(currentThread);

        // 3. 如果 Map 中不存在，则放在 Map 中保存起来
        if (o == null && !valueMap.containsKey(currentThread)) {
            o = initialValue();
            valueMap.put(currentThread, o);
        }
        return o;
    }

    public void remove() {
        valueMap.remove(Thread.currentThread());
    }

    protected Object initialValue() {
        return null;
    }
}
