package com.hfl.test.threadLocal;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * Created by hfl on 2017-5-23.
 * TheadLocal的实现原理还原
 *
 */
public class SimpleThreadLocal {

    private Map valueMap = Collections.synchronizedMap(new HashMap());

    public void set(Object newValue) {
        //①键为线程对象，值为本线程的变量副本
        valueMap.put(Thread.currentThread(), newValue);
    }

    public Object get() {
        Thread currentThread = Thread.currentThread();
        //②返回本线程对应的变量
        Object o = valueMap.get(currentThread);
        //③如果在Map中不存在，放到Map中保存起来
        if (o == null && !valueMap.containsKey(currentThread)) {
            o = initialValue();
            valueMap.put(currentThread, o);
        }
        return o;
    }

    public void remove() {
        valueMap.remove(Thread.currentThread());
    }

    public Object initialValue() {
        return null;
    }
}
