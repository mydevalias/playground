package com.playground.hackerrank;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * Given an array A={a1,a2,…,aN}A={a1,a2,…,aN} of NN elements, find the maximum possible sum of a
 * <p>
 * Contiguous subarray
 * Non-contiguous (not necessarily contiguous) subarray.
 * Empty subarrays/subsequences should not be considered.
 * <p>
 * Input Format
 * <p>
 * First line of the input has an integer TT. TT cases follow.
 * Each test case begins with an integer NN. In the next line, NN integers follow representing the elements of array AA.
 * <p>
 * Constraints:
 * <p>
 * 1≤T≤101≤T≤10
 * 1≤N≤1051≤N≤105
 * −104≤ai≤104−104≤ai≤104
 * The subarray and subsequences you consider should have at least one element.
 * <p>
 * Output Format
 * <p>
 * Two, space separated, integers denoting the maximum contiguous and non-contiguous subarray. At least one integer should be selected and put into the subarrays (this may be required in cases where all elements are negative).
 * <p>
 * Sample Input
 * <p>
 * 2
 * 4
 * 1 2 3 4
 * 6
 * 2 -1 2 3 4 -5
 * Sample Output
 * <p>
 * 10 10
 * 10 11
 * Explanation
 * <p>
 * In the first case:
 * The max sum for both contiguous and non-contiguous elements is the sum of ALL the elements (as they are all positive).
 * <p>
 * In the second case:
 * [2 -1 2 3 4] --> This forms the contiguous sub-array with the maximum sum.
 * For the max sum of a not-necessarily-contiguous group of elements, simply add all the positive elements.
 * <p>
 * <p>
 * Created by liviu on 11.03.2016.
 */
public class MaximumSubarray {
    public static void main(String... args) throws FileNotFoundException {
        HackeRrankUtils hru = new HackeRrankUtils();
        int testCaseCount = hru.scanner.nextInt();
        for (int t = 0; t < testCaseCount; t++) {
            int n = hru.scanner.nextInt();
            int arry[] = new int[n];
            for (int i = 0; i < n; i++) {
                arry[i] = hru.scanner.nextInt();
            }

            long res = solve(arry);
            hru.output.append(res).append(" ").append(sumPos(arry));
            hru.line();
        }
        hru.printBuilder();

    }

    private static long sumPos(int[] arry) {
        int max = Arrays.stream(arry).max().getAsInt();
        if (max < 0) {
            return max;
        }
        return Arrays.stream(arry).filter(e -> e > 0)
                .sum();
    }

    private static long solve(int[] arry) {
        long maxSum = Long.MIN_VALUE;
        long currentSum = 0;
        for (int i = 0; i < arry.length; i++) {
            currentSum = Math.max(currentSum + arry[i], arry[i]);
            if (currentSum > maxSum) {
                maxSum = currentSum;
            }
        }
        return maxSum;
    }


    public static class HackeRrankUtils {

        File file = new File("inputs/maximumsubarray/in.txt");

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
