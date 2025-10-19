package playground.leetcode;

import java.util.Arrays;
import java.util.SortedSet;
import java.util.TreeSet;

public class LexicographicallySmallestStringAfterApplyingOperations {

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public String findLexSmallestString(String s, int a, int b) {
        int values[] = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            values[i] = s.charAt(i) - '0';
        }

        TreeSet<String> sorted = new TreeSet<>();
        for (int k = 0; k < s.length() / gcd(s.length(), b); k++) {
            int[] copy = Arrays.copyOf(values, values.length);
            sorted.addAll(compute(copy, a));
            rotate(values, b);
        }

        return sorted.first();
    }

    public TreeSet<String> compute(int values[], int a) {

        TreeSet<String> sorted = new TreeSet<>();
        while (true) {
            if (!sorted.add(tos(values))) {
                break;
            }
            for (int i = 0; i < values.length; i++) {
                if (i % 2 == 1) {
                    values[i] = (values[i] + a) % 10;
                }
            }
        }

        return sorted;
    }

    private String tos(int[] values) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            sb.append(values[i]);
        }
        return sb.toString();
    }


    private void rotate(int[] values, int a) {
        int n = values.length;
        a = a % n;

        if (a == 0) return;

        int[] temp = new int[a];

        for (int i = 0; i < a; i++) {
            temp[i] = values[n - a + i];
        }

        for (int i = n - 1; i >= a; i--) {
            values[i] = values[i - a];
        }

        for (int i = 0; i < a; i++) {
            values[i] = temp[i];
        }
    }


    public static void main(String[] args) {
        new LexicographicallySmallestStringAfterApplyingOperations().findLexSmallestString("123", 1, 1);
    }
}
