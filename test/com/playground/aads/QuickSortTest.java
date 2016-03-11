package com.playground.aads;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * User: liviu
 * Date: 5/25/14
 * Time: 11:24 PM
 */
public class QuickSortTest {

    QuickSort qs;

    @Before
    public void setup() {
        qs = new QuickSort();
    }

    @Test
    public void test() {
        int[] a = new int[]{2, 1, 3};
        System.out.println(qs.sort(a));
        System.out.println(Arrays.toString(a));
        assertTrue(Arrays.equals(new int[]{1, 2, 3}, a));

        a = new int[]{7, 2, 1, 9, 3, 1, 5, 5};
        System.out.println(qs.sort(a));
        System.out.println(Arrays.toString(a));
        assertTrue(Arrays.equals(new int[]{1, 1, 2, 3, 5, 5, 7, 9}, a));

        a = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        System.out.println(qs.sort(a));
        System.out.println(Arrays.toString(a));
        assertTrue(Arrays.equals(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}, a));

        a = new int[]{1, 3, 5, 2, 4, 6};
        System.out.println(qs.sort(a));
        System.out.println(Arrays.toString(a));
        assertTrue(Arrays.equals(new int[]{1, 2, 3, 4, 5, 6}, a));

        a = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 10};
        System.out.println(qs.sort(a));
        System.out.println(Arrays.toString(a));
        assertTrue(Arrays.equals(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, a));
    }

    @Test
    public void testPartition() {
        int[] a = new int[]{3, 8, 2, 5, 1, 4, 7, 6};
        assertEquals(2, qs.partition(a, 0, a.length - 1));
        assertTrue(Arrays.equals(new int[]{1, 2, 3, 5, 8, 4, 7, 6}, a));

        a = new int[]{6, 7, 1, 3, 4};
        assertEquals(3, qs.partition(a, 0, a.length - 1));
        assertTrue(Arrays.equals(new int[]{4, 1, 3, 6, 7}, a));

        a = new int[]{2, 1, 3};
        assertEquals(1, qs.partition(a, 0, a.length - 1));
        System.out.println(Arrays.toString(a));
        assertTrue(Arrays.equals(new int[]{1, 2, 3}, a));
    }

}
