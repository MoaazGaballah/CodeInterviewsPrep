package AlgoExpret.LinkedLists.LRUCache;

import java.util.*;

public class LRUCache {
    /*


        Implement an LRUCache class for a Least Recently Used (LRU)
        cache. The class should support:
        *     Inserting key-value pairs with the insertKeyValuePair method.
        *     Retrieving a key's value with the getValueFromKey method.
        *     Retrieving the most recently used (the most recently inserted or
    retrieved) key with the getMostRecentKey method.


        Each of these methods should run in constant time.

        Additionally, the LRUCache class should store a maxSize property set to the size of the cache, which is passed in
        as an argument during instantiation. This size represents the maximum number
        of key-value pairs that the cache can store at once. If a key-value pair is
        inserted in the cache when it has reached maximum capacity, the least recently
        used key-value pair should be evicted from the cache and no longer
        retrievable; the newly added key-value pair should effectively replace it.


        Note that inserting a key-value pair with an already existing key should
        simply replace the key's value in the cache with the new value and shouldn't
        evict a key-value pair if the cache is full. Lastly, attempting to retrieve a
        value from a key that isn't in the cache should return None / null.

        Sample Usage:
        // All operations below are performed sequentially.
        LRUCache(3): - // instantiate an LRUCache of size 3
        insertKeyValuePair("b", 2): -
        insertKeyValuePair("a", 1): -
        insertKeyValuePair("c", 3): -
        getMostRecentKey(): "c" // "c" was the most recently inserted key
        getValueFromKey("a"): 1
        getMostRecentKey(): "a" // "a" was the most recently retrieved key
        insertKeyValuePair("d", 4): - // the cache had 3 entries; the least recently used one is evicted
        getValueFromKey("b"): None // "b" was evicted in the previous operation
        insertKeyValuePair("a", 5): - // "a" already exists in the cache so its value just gets replaced
        getValueFromKey("a"): 5

    */
    static int maxSize;

    static LinkedHashMap<String, Integer> cache = new LinkedHashMap<String, Integer>() {
        @Override
        protected boolean removeEldestEntry(Map.Entry<String, Integer> eldest) {
            return size() > maxSize;
        }
    };

    public LRUCache(int maxSize) {
        this.maxSize = maxSize > 1 ? maxSize : 1;
    }

    public void insertKeyValuePair(String key, int value) {
        // Write your code here.
        cache.put(key, value);
    }

    public static LRUResult getValueFromKey(String key) {
        // Write your code here.
        Integer value = cache.get(key);

        LRUResult result = new LRUResult(value != null, value != null ? value : -1);
        return result;
    }

    public static String getMostRecentKey() {
        // Write your code here.
        Integer entry = new LinkedList<>(cache.values()).getLast();
//        return entryList.get(entryList.size() - 1).getKey();
        return entry + "";
    }

    public static void
    getLast(LinkedHashMap<Integer, Integer> lhm) {
        int count = 1;

        for (Map.Entry<Integer, Integer> it :
                lhm.entrySet()) {

            if (count == lhm.size()) {

                System.out.println("Last Key-> " + it.getKey());
                System.out.println("Last Value-> " + it.getValue());
                return;
            }
            count++;
        }
    }

    static class LRUResult {
        boolean found;
        int value;

        public LRUResult(boolean found, int value) {
            this.found = found;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(3);

        lruCache.insertKeyValuePair("b", 2);
        lruCache.insertKeyValuePair("a", 1);
        lruCache.insertKeyValuePair("c", 3);
        System.out.println(getMostRecentKey());
        System.out.println(getValueFromKey("a").value);
        System.out.println(getMostRecentKey());
        lruCache.insertKeyValuePair("d", 4);
        lruCache.insertKeyValuePair("a", 5);
        System.out.println(getValueFromKey("a").value);
        System.out.println(getMostRecentKey());


//
//        // Creating(defining) a LinkedHashMap
//        LinkedHashMap<Integer, Integer> LHM
//                = new LinkedHashMap<>();
//
//        // Adding elements to above LinkedHashMap
//        LHM.put(2, 5);
//        LHM.put(14, 35);
//        LHM.put(36, 20);
//        LHM.put(34, 18);
//        LHM.put(52, 622);
//        LHM.put(2, 6);
//
//        // Calling getLast() method in main()
//        getLast(LHM);
    }
}


