package com.playground.aads;

import java.util.LinkedList;
import java.util.Queue;

/**
 * User: liviu
 * Date: 2/28/14
 * Time: 8:45 PM
 */
public class BinarySearchTree<K extends Comparable, V> {

    private TreeNode<K, V> root = null;

    public void insert(K key, V value) {
        if (root == null) {
            root = new TreeNode(key, value);
        } else {
            insert(root, key, value);
        }
    }

    public void insert(TreeNode<K, V> node, K key, V value) {
        if (node.getKey().compareTo(key) == 1) {
            if (node.left == null) {
                node.left = new TreeNode<K, V>(key, value);
            } else {
                insert(node.left, key, value);
            }
        } else {
            if (node.right == null) {
                node.right = new TreeNode<K, V>(key, value);
            } else {
                insert(node.right, key, value);
            }
        }
    }

    public void preOrder(NodeVisitor nv) {
        preOrder(root, nv);
    }

    public void preOrder(TreeNode<K, V> node, NodeVisitor nv) {
        if (node == null) {
            return;
        }
        nv.visit(node.getKey(), node.getValue());
        preOrder(node.left, nv);
        preOrder(node.right, nv);
    }

    public void inOrder(NodeVisitor nv) {
        inOrder(root, nv);
    }

    public void inOrder(TreeNode<K, V> node, NodeVisitor nv) {
        if (node == null) {
            return;
        }
        preOrder(node.left, nv);
        nv.visit(node.getKey(), node.getValue());
        preOrder(node.right, nv);
    }

    public void breadthFirst(NodeVisitor nv) {
        Queue<TreeNode<K, V>> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode<K, V> tn = q.poll();
            nv.visit(tn.getKey(), tn.getValue());
            if (tn.left != null) {
                q.add(tn.left);
            }
            if (tn.right != null) {
                q.add(tn.right);
            }
        }
    }


    public static class TreeNode<K extends Comparable, V> {

        private final Comparable<K> key;

        private final V value;

        private TreeNode<K, V> left;

        private TreeNode<K, V> right;

        public TreeNode(Comparable<K> key, V value) {
            this.key = key;
            this.value = value;
            left = null;
            right = null;
        }

        public Comparable<K> getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public TreeNode<K, V> getLeft() {
            return left;
        }

        public TreeNode<K, V> getRight() {
            return right;
        }

        public void setLeft(TreeNode<K, V> left) {
            this.left = left;
        }

        public void setRight(TreeNode<K, V> right) {
            this.right = right;
        }
    }

    public static interface NodeVisitor<K extends Comparable, V> {
        void visit(K key, V value);
    }


}
