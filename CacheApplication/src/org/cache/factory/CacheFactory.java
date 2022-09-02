package org.cache.factory;

import org.cache.Cache;
import org.cache.policy.LRUEvictionPolicy;
import org.cache.storage.HashMapBasedStorage;

public class CacheFactory<Key, Value> {
   public Cache<Key, Value> defaultCache(final int capacity){
       return new Cache<Key, Value>(new LRUEvictionPolicy<Key>(),
               new HashMapBasedStorage<Key, Value>(capacity));
   }
}
