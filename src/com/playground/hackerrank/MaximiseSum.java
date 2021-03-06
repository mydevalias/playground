package com.playground.hackerrank;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * ou are given an array of size N and another integer M. Your target is to find the maximum value of sum of subarray modulo M.
 * <p>
 * Subarray is a continuous subset of array elements.
 * <p>
 * Note that we need to find the maximum value of (Sum of Subarray)%M , where there are N×(N+1)/2N×(N+1)/2 possible subarrays.
 * <p>
 * For a given array A[]A[] of size NN, subarray is a contiguous segment from ii to jj where 0≤i≤j≤N0≤i≤j≤N
 * <p>
 * Input Format
 * First line contains T , number of test cases to follow. Each test case consists of exactly 2 lines. First line of each test case contain 2 space separated integers NN and MM, size of the array and modulo value M.
 * Second line contains N space separated integers representing the elements of the array.
 * <p>
 * Output Format
 * For every test case output the maximum value asked above in a newline.
 * <p>
 * Constraints
 * 2≤N≤1052≤N≤105
 * 1≤M≤10141≤M≤1014
 * 1≤elements of the array≤10181≤elements of the array≤1018
 * 2≤Sum of N over all test cases≤5000002≤Sum of N over all test cases≤500000
 * <p>
 * Sample Input
 * <p>
 * 1
 * 5 7
 * 3 3 9 9 5
 * Sample Output
 * <p>
 * 6
 * Explanation
 * <p>
 * Possible subarrays are
 * {3},{3},{9},{9},{5}{3},{3},{9},{9},{5}
 * {3,3},{3,9},{9,9},{9,5}{3,3},{3,9},{9,9},{9,5}
 * {3,3,9},{3,9,9},{9,9,5}{3,3,9},{3,9,9},{9,9,5}
 * {3,3,9,9},{3,3,9,9,5},{3,9,9,5}{3,3,9,9},{3,3,9,9,5},{3,9,9,5}
 * their sums modulo 77 are
 * <p>
 * 3,3,2,2,5,6,5,4,0,1,0,2,3,1,53,3,2,2,5,6,5,4,0,1,0,2,3,1,5 respectively.
 * Hence maximum possible sum taking Modulo 77 is 66 , and we can get 66 by adding first and second element of the array.
 * <p>
 * Created by liviu on 11.03.2016.
 */
public class MaximiseSum {

    public static void main(String... args) throws FileNotFoundException {
        HackeRrankUtils hru = new HackeRrankUtils();
        int testCaseCount = hru.scanner.nextInt();
        for (int t = 0; t < testCaseCount; t++) {
            int n = hru.scanner.nextInt();
            long m = hru.scanner.nextLong();
            long arry[] = new long[n];
            int newN = 0;
            for (int i = 0; i < n; i++) {
                long l = hru.scanner.nextLong() % m;
                if (l > 0) {
                    arry[i] = l;
                    newN++;
                }
            }

            solve(arry, m, hru, newN);
        }
        hru.printBuilder();
    }

    private static void solve(long[] arry, long m, HackeRrankUtils hru, int n) {
        long max = Long.MIN_VALUE;
        long sumArray[] = new long[n];
        long prev = 0;
        TreeSet<Long> treeSet = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            prev = (arry[i] + prev) % m;
            sumArray[i] = prev;
            max = Math.max(max, prev);
            treeSet.add(prev);

            Long higher = treeSet.higher(sumArray[i]);
            if (higher != null) {
                max = Math.max(max, (sumArray[i] - higher + m) % m);
            }
        }
        hru.output.append(max);
        hru.line();
    }

    public static class HackeRrankUtils {

        File file = new File("inputs/maximisesum/inL.txt");

        Scanner scanner = new Scanner(System.in);

        StringBuilder output = new StringBuilder();

        public HackeRrankUtils() throws FileNotFoundException {
            scanner = new Scanner(file);
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
