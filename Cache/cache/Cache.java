package cache;

import java.util.HashMap;
import java.util.Map;

import cache.policies.EvictionPolicy;

public class Cache<Key,Value> {

    final private EvictionPolicy<Key> evictionPolicy;
    final private Map<Key,Value> storage;
    final int size;
    private int currSize = 0;


    public Cache(EvictionPolicy<Key> evictionPolicy){
        this.evictionPolicy = evictionPolicy;
        storage = new HashMap<Key, Value>();
        this.size = 3;
    }
    
    public Value get(Key key){
        try {
            Value val = storage.get(key);
            evictionPolicy.keyAccessed(key);
            System.out.println("Key Accessed "+key+" : "+val);
            return val;
        } catch (Exception e) {
            System.out.println("Tried to access non-existing key.");
            return null;
        }
    }

    public void put(Key key, Value val){

        if(currSize == size){
            Key keyToRemove = evictionPolicy.evictKey();
            storage.remove(keyToRemove);
            System.out.println("Removed key "+keyToRemove);
        }

        storage.put(key, val);
        evictionPolicy.keyAccessed(key);
        System.out.println("Added key "+key+" with "+val);
        currSize++;
    }
}
