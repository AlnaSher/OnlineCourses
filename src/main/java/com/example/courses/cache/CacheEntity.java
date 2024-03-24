package com.example.courses.cache;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@NoArgsConstructor
public class CacheEntity<K, V>{
    Map<K, V> cache = new HashMap<>();
    private static final int CAPACITY = 100;
    public V get(K key) {
        return cache.get(key);
    }

    public void put(K key, V value) {
        if (cache.size() >= CAPACITY)
            removeOldestEntry();
        cache.put(key, value);
    }

    public void remove(K key) {
        cache.remove(key);
    }
    public void clear() {
        cache.clear();
    }
    public boolean containsKey(K key) {
        return cache.containsKey(key);
    }
    private void removeOldestEntry() {
        if (!cache.isEmpty()) {
            K oldestKey = cache.keySet().iterator().next();
            cache.remove(oldestKey);
        }
    }
}
