package com.playground.aads;

import java.util.Arrays;

/**
 * User: liviu
 * Date: 3/8/14
 * Time: 10:34 PM
 */
public class HighSchoolBackTracking {

    int x[];

    public void back(int n) {
        x = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = -1;
        }
        int k = 0;
        do {
            while (x[k] < n - 1) {//max number on level
                x[k]++;
                if (shouldContinue(k, n)) {
                    if (k == n - 1) {
                        System.out.println(Arrays.toString(x));
                    } else {
                        k++;
                    }
                }
            }
            x[k] = -1;
            k--;
        }
        while (k != -1);
    }

    private boolean shouldContinue(int k, int n) {
        return true;
    }

    public static void main(String... arg) {
        new HighSchoolBackTracking().back(3);
    }
}
