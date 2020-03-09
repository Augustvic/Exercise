package OtherTest.Cache;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class LFUCache<K, V> {
    private int cacheSize;
    private Map<K, V> cache;
    private Map<K, HitValue> count;

    public LFUCache(int cacheSize) {
        this.cacheSize = cacheSize;
        this.cache = new HashMap<>(16, 1);
        this.count = new HashMap<>(16, 1);
    }

    public void put(K key, V value) {
        if (cacheSize <= cache.size()) {
            removeEldest();
        }
        V oldValue = cache.get(key);
        HitValue hitValue;
        if (oldValue == null) {
            cache.put(key, value);
            hitValue = new HitValue(key,1, System.nanoTime());
            count.put(key, hitValue);
        }
        else {
            hitValue = count.get(key);
            hitValue.incr();
            hitValue.now();
        }
    }

    public V get(K key) {
        V oldValue = cache.get(key);
        if (oldValue != null) {
            HitValue hitValue = count.get(key);
            hitValue.incr();
            hitValue.now();
        }
        return oldValue;
    }

    public boolean containsKey(K key) {
        return cache.containsKey(key);
    }

    public void remove(K key) {
        cache.remove(key);
        count.remove(key);
    }

    private void removeEldest() {
        HitValue hitValue = Collections.min(count.values());
        cache.remove(hitValue.key);
        count.remove(hitValue.key);
    }

    //内部类
    class HitValue implements Comparable<HitValue>{
        K key;
        int hitCount;
        long lastTime;

        HitValue(K key, int hitCount, long lastTime) {
            this.key = key;
            this.hitCount = hitCount;
            this.lastTime = lastTime;
        }

        void incr() {
            this.hitCount++;
        }

        void now() {
            this.lastTime = System.nanoTime();
        }

        @Override
        public int compareTo(HitValue o) {
            int compare = Integer.compare(this.hitCount, o.hitCount);
            return compare == 0 ? Long.compare(this.lastTime, o.lastTime) : compare;
        }
    }
}
