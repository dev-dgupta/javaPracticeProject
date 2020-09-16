package collectionsExample;

import java.util.*;

public class LRUCacheExample {

    public static void main(String[] args) {
        // write your code here

        LRUCache lruCache = new LRUCache(3);
//        lruCache.put();
    }
}

class LRUCache {
    int cacheSize;
    Map<Integer,Integer> hm;
    Deque<Integer> dq;

    public LRUCache(int size) {
        cacheSize = size;
        hm = new HashMap();

        dq = new LinkedList<>();
    }

    public int get(int key) {
        return hm.get(key);
    }


    public void put(int key, int value) {
        if (!hm.containsKey(key)) {
            if (cacheSize == dq.size()) {
                int last = dq.removeLast();
                hm.remove(last);
            }
            else {
                dq.remove(key);
            }
        }
        hm.put(key, value);
        dq.push(key);

    }
}


