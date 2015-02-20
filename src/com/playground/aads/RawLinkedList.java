package com.playground.aads;

/**
 * User: liviu
 * Date: 3/6/14
 * Time: 10:20 PM
 */
public class RawLinkedList<T> {

    private Node<T> head, tail;

    public void add(T data) {
        if (head == null) {
            head = new Node(data);
            tail = head;
        } else {
            tail.next = new Node(data);
            tail = tail.next;
        }
    }

    public T removeFirst() {
        if (head != null) {
            T data = head.data;
            head = head.next;
            if (head == null) {
                tail = null;
            }
            return data;
        }
        return null;
    }

    public T get(int index) {
        Node<T> n = head;
        int i = 0;
        while (n != null) {
            if(i == index){
                return n.data;
            }
            i++;
            n = n.next;
        }
        return null;
    }

}
