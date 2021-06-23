package RedisCacheLRU;

import java.util.LinkedHashMap;
import java.util.Map;

/*
* 手写lru算法
* 底层 LinkedHashMap
* redis缓存删除策略之all keys-lru
* */
public class LruCache<k,v> extends LinkedHashMap<k,v> {
    private int initialCapacity;
    public LruCache(int initialCapacity) {
        super(initialCapacity,0.75F,true);
        this.initialCapacity=initialCapacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<k, v> eldest) {
        return super.size()>initialCapacity;
    }

    public static void main(String[] args) {
        LruCache lruCache=new LruCache(3);
        lruCache.put("a","a");
        lruCache.put("b","b");
        lruCache.put("c","c");
        System.out.println(lruCache.keySet());
        lruCache.put("d","d");
        System.out.println(lruCache.keySet());
    }
}
