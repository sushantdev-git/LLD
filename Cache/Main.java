import cache.Cache;
import cache.policies.LRUEvictionPolicy;

public class Main {
    public static void main(String[] args){
        Cache<String,String> lru = new Cache<String,String>(new LRUEvictionPolicy<String>());

        lru.put("Sushant", "10");
        lru.put("Sushant1", "100");
        lru.put("Sushant2", "1000");
        lru.get("Sushant");
        lru.get("Sushant2");
        lru.put("Sushant3", "20");
    }
}