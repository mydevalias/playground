package com.playground.hackerrank;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * ou are given an array of size N and another integer M. Your target is to find the maximum value of sum of subarray modulo M.

 Subarray is a continuous subset of array elements.

 Note that we need to find the maximum value of (Sum of Subarray)%M , where there are N×(N+1)/2N×(N+1)/2 possible subarrays.

 For a given array A[]A[] of size NN, subarray is a contiguous segment from ii to jj where 0≤i≤j≤N0≤i≤j≤N

 Input Format
 First line contains T , number of test cases to follow. Each test case consists of exactly 2 lines. First line of each test case contain 2 space separated integers NN and MM, size of the array and modulo value M.
 Second line contains N space separated integers representing the elements of the array.

 Output Format
 For every test case output the maximum value asked above in a newline.

 Constraints
 2≤N≤1052≤N≤105
 1≤M≤10141≤M≤1014
 1≤elements of the array≤10181≤elements of the array≤1018
 2≤Sum of N over all test cases≤5000002≤Sum of N over all test cases≤500000

 Sample Input

 1
 5 7
 3 3 9 9 5
 Sample Output

 6
 Explanation

 Possible subarrays are
 {3},{3},{9},{9},{5}{3},{3},{9},{9},{5}
 {3,3},{3,9},{9,9},{9,5}{3,3},{3,9},{9,9},{9,5}
 {3,3,9},{3,9,9},{9,9,5}{3,3,9},{3,9,9},{9,9,5}
 {3,3,9,9},{3,3,9,9,5},{3,9,9,5}{3,3,9,9},{3,3,9,9,5},{3,9,9,5}
 their sums modulo 77 are

 3,3,2,2,5,6,5,4,0,1,0,2,3,1,53,3,2,2,5,6,5,4,0,1,0,2,3,1,5 respectively.
 Hence maximum possible sum taking Modulo 77 is 66 , and we can get 66 by adding first and second element of the array.
 *
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
        for (int i = 1; i <= n; i++) {//max number of elements in array
            long tmpMax = max(arry,n, m, i);
            if (max < tmpMax) {
                max = tmpMax;
            }
            if (max == m - 1) {
                break;
            }
        }
        hru.output.append(max);
        hru.line();
    }

    private static long max(long[] arry,int n, long m, int currentLength) {
        long max = Long.MIN_VALUE;
        for (int i = 0; i < n - currentLength + 1; i++) {
            long sum = sum(arry, i, currentLength) % m;
            if (max < sum) {
                max = sum;
            }
        }
        return max;
    }

    private static long sum(long[] arry, int start, int length) {
        long sum = 0;
        for (int i = start; i < start + length; i++) {
            sum += arry[i];
        }
        return sum;
        //System.out.println();
    }

    public static class HackeRrankUtils {

        File file = new File("in.txt");

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
