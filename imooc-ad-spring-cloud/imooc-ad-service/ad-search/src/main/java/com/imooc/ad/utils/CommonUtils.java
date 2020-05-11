package com.imooc.ad.utils;

import java.util.Map;
import java.util.function.Supplier;

/**
 * @auther BoHanMa
 * @date 2020/4/26 15:08
 */
public class CommonUtils {

    public static <K,V> V getorCreate(K key, Map<K,V> map,
                                      Supplier<V> factory){
        return map.computeIfAbsent(key,k ->factory.get());
    }
}
