package com.playground.aads;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * User: liviu
 * Date: 3/2/14
 * Time: 12:05 AM
 */
public class BinarySearchTreeTest {

    BinarySearchTree<Integer, String> bst;

    @Before
    public void setup() {
        bst = new BinarySearchTree<>();
        bst.insert(5, "A");
        bst.insert(3, "B");
        bst.insert(7, "C");
        bst.insert(1, "D");
        bst.insert(4, "E");
    }

    @Test
    public void basicPreOrder() {
        TestVisitor tv = new TestVisitor();
        bst.preOrder(tv);
        assertEquals(Arrays.asList(5, 3, 1, 4, 7), tv.data);
    }

    @Test
    public void inOrder() {
        TestVisitor tv = new TestVisitor();
        bst.inOrder(tv);
        assertEquals(Arrays.asList(3, 1, 4, 5, 7), tv.data);
    }

    @Test
    public void testBreadthFirst() {
        TestVisitor tv = new TestVisitor();
        bst.breadthFirst(tv);
        assertEquals(Arrays.asList(5, 3, 7, 1, 4), tv.data);
    }

    public static class TestVisitor<K extends Comparable, V> implements BinarySearchTree.NodeVisitor<K, V> {

        private List<K> data = new ArrayList<>();

        @Override
        public void visit(K key, V value) {
            data.add(key);
        }
    }
}
