package playground.leetcode2;

import java.util.HashSet;
import java.util.Set;

public class FindTheLengthofTheLongestCommonPrefix {

    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        Set<Integer> prefixes = getPrefixes(arr1);

        int max = 0;
        for (int val : arr2) {
            while (val > 0) {
                if (prefixes.contains(val)) {
                    max = Math.max(max, digitCount(val));
                    break;
                }
                val /= 10;
            }
        }

        return max;
    }

    private static Set<Integer> getPrefixes(int[] arr1) {
        Set<Integer> prefixes = new HashSet<>();

        for (int val : arr1) {
            while (val > 0) {
                prefixes.add(val);
                val /= 10;
            }
        }
        return prefixes;
    }

    private int digitCount(int n) {
        int c = 0;
        while (n > 0) {
            c++;
            n /= 10;
        }
        return c;
    }

    public int longestCommonPrefixSlow(int[] arr1, int[] arr2) {
        int max = 0;
        for (int val1 : arr1) {
            for (int val2 : arr2) {
                int c = countPref(val1, val2);
                max = Math.max(max, c);
            }
        }
        return max;
    }

    private int countPref(int val1, int val2) {
        while (val1 != val2) {
            if (val1 > val2) val1 /= 10;
            else val2 /= 10;
        }
        int c = 0;
        while (val1 > 0) {
            c++;
            val1 /= 10;
        }
        return c;
    }

}
