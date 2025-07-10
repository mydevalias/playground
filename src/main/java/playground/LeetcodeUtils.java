package playground;

import java.util.HashMap;
import java.util.Map;

/**
 * I keep needing some methods while practicing on LeetCode.
 */
public class LeetcodeUtils {

    public static final int SZ = (int) 'z' - (int) 'A' + 1;
    public static final char ST = 'A';

    public static int[] countLetters(String s2) {
        int[] counter = new int[SZ];
        for (int i = 0; i < s2.length(); i++) {
            counter[s2.charAt(i) - ST]++;
        }
        return counter;
    }

    public static boolean isPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return true;
        }

        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    public static class BooleanSparseMatrix{
        private final int rows;
        private final int cols;
        private final Map<Integer, Boolean>[] data;

        @SuppressWarnings("unchecked")
        public BooleanSparseMatrix(int rows, int cols) {
            this.rows = rows;
            this.cols = cols;
            this.data = new Map[rows];
        }

        public void set(int row, int col, Boolean value) {
            if (row < 0 || row >= rows || col < 0 || col >= cols) {
                throw new IndexOutOfBoundsException("Index out of bounds");
            }

            if (value == null) {
                if (data[row] != null) {
                    data[row].remove(col);
                }
            } else {
                if (data[row] == null) {
                    data[row] = new HashMap<>();
                }
                data[row].put(col, value);
            }
        }

        public Boolean get(int row, int col) {
            if (row < 0 || row >= rows || col < 0 || col >= cols) {
                throw new IndexOutOfBoundsException("Index out of bounds");
            }
            return data[row] == null ? null : data[row].get(col);
        }
    }
}
