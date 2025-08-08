package playground.leetcode;


/**
 * https://leetcode.com/problems/find-the-maximum-number-of-fruits-collected/description
 */
public class FindMaximumNumberFruitsCollected {

    public int maxCollectedFruits(int[][] fruits) {
        int answ = 0;
        int n = fruits.length;
        for (int i = 0; i < n; ++i) {
            answ += fruits[i][i];
        }
        int[] prev = new int[n];
        int[] curr = new int[n];
        java.util.Arrays.fill(prev, Integer.MIN_VALUE);
        java.util.Arrays.fill(curr, Integer.MIN_VALUE);
        prev[n - 1] = fruits[0][n - 1];
        for (int i = 1; i < n - 1; i++) {// n-1 because the first kid already reached n-1,n-1
            for (int j = n - 1; j > i; j--) {
                int best = Math.max(prev[j], prev[j - 1]);
                if (j + 1 < n) best = Math.max(best, prev[j + 1]);
                curr[j] = best + fruits[i][j];
            }
            int[] temp = prev;
            prev = curr;
            curr = temp;
        }
        answ += prev[n - 1];

        prev = new int[n];
        curr = new int[n];
        java.util.Arrays.fill(prev, Integer.MIN_VALUE);
        java.util.Arrays.fill(curr, Integer.MIN_VALUE);
        prev[n - 1] = fruits[n - 1][0];
        for (int i = 1; i < n - 1; i++) {// n-1 because the first kid already reached n-1,n-1
            for (int j = n - 1; j > i; j--) {
                int best = Math.max(prev[j], prev[j - 1]);
                if (j + 1 < n) best = Math.max(best, prev[j + 1]);
                curr[j] = best + fruits[j][i];
            }
            int[] temp = prev;
            prev = curr;
            curr = temp;
        }
        answ += prev[n - 1];
        return answ;
    }

    public static void main(String[] args) {
        FindMaximumNumberFruitsCollected dm = new FindMaximumNumberFruitsCollected();
        System.out.println(dm.maxCollectedFruits(new int[][]{
                {1, 2, 3, 4}, {5, 6, 8, 7}, {9, 10, 11, 12}, {13, 14, 15, 16}}
        ));
    }


}
