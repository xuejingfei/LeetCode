package com.xjf.leetcode.lruCache;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Description:
 * Author: xuejingfei
 * E-mail: xue.jingfei@immomo.com
 * Date: 8/3/21 6:25 PM
 */
class LruCache<K,V> {
    private LinkedHashMap<K,V> map;
    private int size;
    private int maxSize;

    public LruCache(int maxSize) {
        this.maxSize = maxSize;
        map = new LinkedHashMap(0,0.75f,true);
    }

    public V put(K key,V value) {
        if(key == null || value == null) {
            throw new RuntimeException("key and value must not null");
        }
        V previous;
        synchronized(this) {
            size += safeSizeOf(key,value);
            previous = map.put(key,value);
            if(previous != null) {
                size -= safeSizeOf(key,previous);
            }
        }

        trimToSize(maxSize);
        return previous;
    }

    public V get(K key) {
        if (key == null) {
            throw new NullPointerException("key == null");
        }
        return map.get(key);
    }

    /**
     * 调整缓存大小
     * @param maxSize
     */
    private void trimToSize(int maxSize) {
        while(true) {
            K key;
            V value;
            synchronized(this) {
                if(size < 0 || (map.isEmpty() && size == 0)) {
                    throw new IllegalArgumentException("出现错误");
                }
                if(size <= maxSize || map.isEmpty()) {
                    break;
                }
                Map.Entry<K, V> entry = map.entrySet().iterator().next();
                key = entry.getKey();
                value = entry.getValue();
                map.remove(key);
                size -= safeSizeOf(key,value);
            }
        }
    }


    private int safeSizeOf(K key,V value) {
        int size = sizeOf(key,value);
        if(size <0) {
            throw new IllegalStateException("Negative size: " + key + "=" + value);
        }
        return size;
    }


    private int sizeOf(K key,V value) {
        return 1;
    }
}
