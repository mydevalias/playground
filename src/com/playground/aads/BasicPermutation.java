package com.playground.aads;

import java.util.Arrays;

/**
 * User: liviu
 * Date: 3/8/14
 * Time: 9:54 PM
 */
public class BasicPermutation {

    public static void main(String... arg) {
        int n = 4;

        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = i;
        }
        perm(a, 0);
    }

    public static void perm(int a[], int k) {
        if (k == a.length) {
            System.out.println(Arrays.toString(a));
        }
        for (int i = k; i < a.length; i++) {
            swap(a, k, i);
            perm(a, k + 1);
            swap(a, k, i);
        }
    }

    private static void swap(int[] a, int k, int i) {
        int aux = a[k];
        a[k] = a[i];
        a[i] = aux;
    }

}
