package com.playground.aads;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertTrue;

/**
 * User: liviu
 * Date: 5/16/14
 * Time: 11:28 PM
 */
public class MergeSortTest {
    MergeSort ms;

    @Before
    public void setup() {
        ms = new MergeSort();
    }

    @Test
    public void test() {
        int[] a = new int[]{2, 1, 3};
        System.out.println(ms.sort(a));
        assertTrue(Arrays.equals(new int[]{1, 2, 3}, a));

        a = new int[]{7, 2, 1, 9, 3, 1, 5, 5};
        System.out.println(ms.sort(a));
        System.out.println(Arrays.toString(a));
        assertTrue(Arrays.equals(new int[]{1, 1, 2, 3, 5, 5, 7, 9}, a));

        a = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        System.out.println(ms.sort(a));
        System.out.println(Arrays.toString(a));
        assertTrue(Arrays.equals(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}, a));

        a = new int[]{1, 3, 5, 2, 4, 6};
        System.out.println(ms.sort(a));
        System.out.println(Arrays.toString(a));
        assertTrue(Arrays.equals(new int[]{1, 2, 3, 4, 5, 6}, a));

        a = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 10};
        System.out.println(ms.sort(a));
        System.out.println(Arrays.toString(a));
        assertTrue(Arrays.equals(new int[]{1, 2, 3, 4, 5, 6,7,8,9,10}, a));
    }

}
