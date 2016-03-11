package com.playground.aads;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * User: liviu
 * Date: 3/2/14
 * Time: 3:35 PM
 */
public class BinarySearchTest {

    @Test
    public void testFind() throws Exception {
        ArrayList<Integer> lst = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        assertEquals(0, BinarySearch.find(1, lst));
        assertEquals(1, BinarySearch.find(2, lst));
        assertEquals(2, BinarySearch.find(3, lst));
        assertEquals(3, BinarySearch.find(4, lst));
        assertEquals(4, BinarySearch.find(5, lst));
    }

}
