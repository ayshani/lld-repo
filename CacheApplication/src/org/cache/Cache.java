package org.cache;

import org.cache.exception.NotFoundException;
import org.cache.exception.StorageFullException;
import org.cache.policy.EvictionPolicy;
import org.cache.storage.Storage;

public class Cache<Key, Value> {
    private final EvictionPolicy<Key> evictionPolicy;
    private final Storage<Key,Value> storage;

    public Cache(EvictionPolicy<Key> evictionPolicy, Storage<Key,Value> storage){
        this.evictionPolicy = evictionPolicy;
        this.storage = storage;
    }

    public void put(Key key, Value value) throws NotFoundException {
        try{
            this.storage.add(key,value);
            this.evictionPolicy.keyAccessed(key);
        } catch(StorageFullException e){
            System.out.println("Got Storage full. Wil try to evict.");
            Key keyToRemove = evictionPolicy.evict();
            if(null == keyToRemove){
                throw  new RuntimeException("Unexpected State. Storage full and no key to evict.");
            }
            this.storage.remove(keyToRemove);
            System.out.println("Creating space by evicting item... "+ keyToRemove);
            put(key,value);
        }
    }

    public Value get(Key key){
        try{
            Value value = this.storage.get(key);
            this.evictionPolicy.keyAccessed(key);
            return value;
        } catch(NotFoundException e){
            System.out.println("Tried to access non-existing key");
            return null;
        }
    }
}
