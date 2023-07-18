import java.util.*;

public class LRUCache {
    int capacity;
    int currentCapacity = 0;
    LinkedHashMap<Integer, Integer> cache;


    public LRUCache(int capacity) {
        cache = new LinkedHashMap<>(0, 0.75f, true);
        this.capacity = capacity;
    }

    public int get(int key) {

        return cache.getOrDefault(key, - 1);

    }

    public void put(int key, int value) {
        if(cache.containsKey(key)){
            cache.put(key, value);
            cache.get(key);
        }else{
            if(currentCapacity < capacity) {
                cache.put(key, value);
                cache.get(key);
                currentCapacity++;
            }else if(currentCapacity == capacity){
                Iterator<Map.Entry<Integer, Integer>> iterator = cache.entrySet().iterator();

                if (iterator.hasNext()) {
                    iterator.next();
                    iterator.remove();
                }
                cache.put(key, value);
                cache.get(key);
            }
        }
    }
}


