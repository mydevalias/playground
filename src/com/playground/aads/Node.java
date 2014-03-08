package com.playground.aads;

/**
 * User: liviu
 * Date: 3/6/14
 * Time: 10:34 PM
 */
public class Node<T> {
    T data;
    Node next;

    public Node(T data) {
        this.data = data;
    }

    public Node(T data, Node next) {
        this.data = data;
        this.next = next;
    }
}