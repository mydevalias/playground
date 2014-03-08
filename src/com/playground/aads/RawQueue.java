package com.playground.aads;

/**
 * User: liviu
 * Date: 3/4/14
 * Time: 9:34 PM
 */
public class RawQueue<T> {

    Node<T> head, tail;

    public void enqueue(T data) {
        if (head == null) {
            head = new Node(data);
            tail = head;
        } else {
            tail.next = new Node(data);
            tail = tail.next;
        }
    }

    public T dequeue() {
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

}
