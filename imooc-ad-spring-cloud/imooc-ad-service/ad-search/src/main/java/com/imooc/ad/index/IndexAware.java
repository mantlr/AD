package com.imooc.ad.index;

/**
 * @author Swallow
 */
public interface IndexAware<K,V>  {

    V get(K key);

    void add(K key, V value);
    void update(K key,V value);
    void delete(K key,V value);


}
