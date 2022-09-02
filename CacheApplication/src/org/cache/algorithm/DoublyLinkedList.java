package org.cache.algorithm;

import org.cache.exception.InvalidElementException;

public class DoublyLinkedList<E> {
    DoublyLinkedListNode<E> head;
    DoublyLinkedListNode<E> tail;

    public DoublyLinkedList(){
        head = new DoublyLinkedListNode<>(null);
        tail = new DoublyLinkedListNode<>(null);
        head.next = tail;
        tail.prev = head;
    }
    /**
     * Helper method to add an element at the end.
     *
     * @param element Element to be added.
     * @return Reference to new node created for the element.
     */
    public DoublyLinkedListNode<E> addElementAtLast(E element){
        if(element == null){
            throw new InvalidElementException();
        }
        DoublyLinkedListNode<E> node = new DoublyLinkedListNode<>(element);
        addNodeAtLast(node);
        return node;

    }
    /**
     * Helper method to add a node at the end of the list.
     *
     * @param node Node to be added.
     */
    public  void addNodeAtLast(DoublyLinkedListNode<E> node) {
        DoublyLinkedListNode<E> tailPrev = tail.prev;
        tailPrev.next = node;
        node.prev = tailPrev;
        node.next = tail;
        tail.prev = node;
    }
    /*
     * Method to detach a random node from the doubly linked list. The node itself will not be removed from the memory.
     * Just that it will be removed from the list and becomes orphaned and will be garbage collected

     */
    public void detachNode(DoublyLinkedListNode<E> node){
        if(node != null){
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
    }

    public boolean isCacheEmpty(){
        return head.next == tail;
    }

    public DoublyLinkedListNode getFirstNode(){
        if(isCacheEmpty())
            return null;

        return head.next;
    }

    public DoublyLinkedListNode getLastNode() {
        if(isCacheEmpty())
            return null;

        return tail.prev;
    }
}
