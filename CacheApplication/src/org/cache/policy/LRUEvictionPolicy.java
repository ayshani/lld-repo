package org.cache.policy;

import org.cache.algorithm.DoublyLinkedList;
import org.cache.algorithm.DoublyLinkedListNode;

import java.util.HashMap;
import java.util.Map;

public class LRUEvictionPolicy<Key> implements EvictionPolicy<Key> {

    private DoublyLinkedList<Key> dll;
    private Map<Key, DoublyLinkedListNode<Key>> mapper;

    public LRUEvictionPolicy(){
        this.dll = new DoublyLinkedList<>();
        this.mapper = new HashMap<>();
    }
    @Override
    public void keyAccessed(Key key) {
        if(mapper.containsKey(key)){
            dll.detachNode(mapper.get(key));
            dll.addNodeAtLast(mapper.get(key));
        } else{
            DoublyLinkedListNode<Key> newNode = dll.addElementAtLast(key);
            mapper.put(key, newNode);
        }
    }

    @Override
    public Key evict() {
        DoublyLinkedListNode<Key> first = dll.getFirstNode();
        if(first == null)
            return null;
        dll.detachNode(first);
        mapper.remove(first.getElement());
        return first.getElement();
    }
}
