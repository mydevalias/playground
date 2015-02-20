package com.playground.aads;

/**
 * User: liviu
 * Date: 3/4/14
 * Time: 9:09 PM
 */
public class RawStack<T> {

    private Node<T> root;

    public void push(T data) {
        root = new Node<>(data, root);
    }

    public T pop() {
        if (root != null) {
            T el = root.data;
            root = root.next;
            return el;
        }
        return null;
    }

}
