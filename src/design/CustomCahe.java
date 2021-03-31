package design;

import java.util.Hashtable;
import java.util.Map;

public class CustomCahe implements MyCache {

    private final Map<String,String> internalStore;
    private final int maxSize;

    public CustomCahe(int maxSize) {
        this.maxSize = maxSize;
        this.internalStore = new Hashtable<>();
    }

    @Override
    public void put(String key, String val) {
        if (internalStore.size()==maxSize){
            throw new RuntimeException("Max limit of the cache reached!");
        }
        this.internalStore.put(key,val);
    }

    @Override
    public String get(String key) {
        return this.internalStore.get(key);
    }
}
