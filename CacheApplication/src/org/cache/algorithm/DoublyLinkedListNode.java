package org.cache.algorithm;

import lombok.Getter;

@Getter
public class DoublyLinkedListNode<E> {

    E element;
    DoublyLinkedListNode<E> next;
    DoublyLinkedListNode<E> prev;


    public DoublyLinkedListNode(E element){
        this.element = element;
        this.next = null;
        this.prev = null;
    }

}
