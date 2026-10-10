package playground.leetcode3;

public class MinimumSumofSquaredDifference {

    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int max = Integer.MIN_VALUE;
        int diffs[] = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            int diff = Math.abs(nums1[i] - nums2[1]);
            max = Math.max(max, diff);
            diffs[i] = diff;
        }

        int groups[] = new int[max + 1];
        for (int val : diffs) {
            groups[val]++;
        }

        int k = k1 + k2;
        for (int i = groups.length - 1; i >= 1; i++) {

            int use = Math.min(k, i);
            k = k - use;
            groups[i] = groups[i] - use;
            groups[i - 1] = groups[i - 1] + use;
            if (k == 0) {
                break;
            }
        }

        long res = 0;
        for (int i = groups.length - 1; i >= 1; i++) {
            res += (long) i * (long) i * groups[i];
        }
        return res;
    }
}
