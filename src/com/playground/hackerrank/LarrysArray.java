package com.playground.hackerrank;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by liviu on 19.03.2016.
 */
public class LarrysArray {

    public static void main(String... args) throws FileNotFoundException {
        HackeRrankUtils hru = new HackeRrankUtils();
        int testCaseCount = hru.scanner.nextInt();
        for (int t = 0; t < testCaseCount; t++) {
            int n = hru.scanner.nextInt();
            int v[] = new int[n];
            for (int i = 0; i < n; i++) {
                v[i] = hru.scanner.nextInt();
            }
            boolean test = perm(v, 0);
            if (test) {
                hru.output.append("YES");
            } else {
                hru.output.append("NO");
            }
            hru.line();
        }
        hru.printBuilder();
    }

    private static boolean perm(int[] v, int k) {
        if (k == v.length - 2) {
            for (int i = 0; i < v.length - 1; i++) {
                if (v[i] > v[i + 1]) {
                    return false;
                }
            }
            return true;
        }

        for (int i = k; i < v.length - 2; i++) {
            swap(v, i);
            if (testSwap(v, i) && perm(v, k + 1)) {
                return true;
            }
            swap(v, i);
            if (testSwap(v, i) && perm(v, k + 1)) {
                return true;
            }
            swap(v, i);
            if (testSwap(v, i) && perm(v, k + 1)) {
                return true;
            }

        }
        return false;
    }

    private static void swap(int[] v, int i) {
        int aux = v[i];
        v[i] = v[i + 1];
        v[i + 1] = v[i + 2];
        v[i + 2] = aux;
    }

    private static boolean testSwap(int[] v, int i) {
        return v[i] <= v[i + 1] && v[i + 1] <= v[i + 2];
    }


    public static class HackeRrankUtils {

        File file = new File("inputs/maximumsubarray/in.txt");

        Scanner scanner = new Scanner(System.in);

        StringBuilder output = new StringBuilder();

        public HackeRrankUtils() throws FileNotFoundException {
            // scanner = new Scanner(file);
        }

        void printBuilder() {
            System.out.print(output.toString());
        }

        void line() {
            output.append(System.lineSeparator());
        }

        String nextLine() {
            return scanner.nextLine();
        }

    }


}
