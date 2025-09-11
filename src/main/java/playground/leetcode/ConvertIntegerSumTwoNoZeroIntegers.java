package playground.leetcode;

public class ConvertIntegerSumTwoNoZeroIntegers {

    private static boolean hasZero(int val) {
        while (val > 0) {
            if (val % 10 == 0) {
                return true;
            }
            val = val / 10;
        }

        return false;
    }

    public int[] getNoZeroIntegers(int n) {
        for (int i = 1; i < n; i++) {
            int v1 = n - i;
            int v2 = i;
            if (hasZero(v1) || hasZero(v2)) {
                continue;
            } else {
                return new int[]{v1, v2};
            }
        }
        return new int[]{0, 0};
    }

}
