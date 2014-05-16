package com.playground.aads;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

/**
 * User: liviu
 * Date: 5/16/14
 * Time: 11:20 PM
 */
public class MergeSort {

    private long sort(int[] a, int[] aux, int low, int hi) {
        if (hi <= low) return 0;
        int mid = low + (hi - low) / 2;
        long left = sort(a, aux, low, mid);
        long right = sort(a, aux, mid + 1, hi);
        long inv = merge(a, aux, low, mid, hi);
        return left + right + inv;
    }

    private long merge(int[] a, int[] aux, int low, int mid, int hi) {
        for (int k = low; k <= hi; k++) {
            aux[k] = a[k];
        }
        int i = low, j = mid + 1;
        long inversion = 0;
        for (int k = low; k <= hi; k++) {
            if (i > mid) {
                a[k] = aux[j++];
            } else if (j > hi) {
                a[k] = aux[i++];
            } else {
                if (aux[j] < aux[i]) {
                    a[k] = aux[j++];
                    inversion = inversion + (mid + 1 - i);
                } else {
                    a[k] = aux[i++];
                }
            }
        }
        return inversion;
    }

    public long sort(int[] a) {
        int[] aux = new int[a.length];
        return sort(a, aux, 0, a.length - 1);
    }

    public static void main(String... args) throws IOException {
        List<String> data = Files.readAllLines(Paths.get("d:\\IntegerArray.txt"), StandardCharsets.UTF_8);
        int a[] = new int[data.size()];
        for (int i = 0; i < data.size(); i++) {
            a[i] = Integer.parseInt(data.get(i));
        }
        System.out.println(new MergeSort().sort(a));
        System.out.println(Arrays.toString(a));
        System.out.println(a.length);

    }

}
