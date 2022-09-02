package org.cache.storage;


import org.cache.exception.NotFoundException;
import org.cache.exception.StorageFullException;

public interface Storage<Key, Value> {
    void add(Key key, Value value) throws StorageFullException;
    void remove(Key key) throws NotFoundException;
    Value get(Key key) throws NotFoundException;
}
