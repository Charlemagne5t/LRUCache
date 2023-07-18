import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LRUCacheTest {
    @Test
    public void LRUCacheTest1(){
        LRUCache cache = new LRUCache(2);
        cache.put(1,1);
        cache.put(2,2);
        Assertions.assertEquals(1, cache.get(1));
        cache.put(3,3);
        Assertions.assertEquals(-1, cache.get(2));
        cache.put(4,4);
        Assertions.assertEquals(-1, cache.get(1));
        Assertions.assertEquals(3, cache.get(3));
        Assertions.assertEquals(4, cache.get(4));
    }
}
