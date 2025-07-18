package playground.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/minimum-difference-in-sums-after-removal-of-elements/description
 */
public class MinimumDifferenceSumsAfterRemovalElements {

    public long minimumDifference(int[] nums) {
        int n = nums.length / 3;
        //sumfirst - sumsecond
        long[] partFirst = firstPart(nums, n);
        long[] partSecond = secondPart(nums, n);
        long res = Long.MAX_VALUE;
        for (int i = n - 1; i < nums.length - n; i++) {
            var cur = partFirst[i] - partSecond[i+1];
            res = Math.min(res, cur);
        }
        return res;
    }

    private static long[] firstPart(int[] nums, int n) {
        long[] partFirst = new long[nums.length];
        PriorityQueue<Integer> left = new PriorityQueue<>(Comparator.reverseOrder());
        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            left.add(nums[i]);
            if (left.size() > n) {
                int r = left.poll();
                sum = sum - r;
            }
            partFirst[i] = sum;
        }
        return partFirst;
    }

    private static long[] secondPart(int[] nums, int n) {
        PriorityQueue<Integer> right = new PriorityQueue<>();
        long[] partSecond = new long[nums.length];
        long sum = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            sum += nums[i];
            right.add(nums[i]);
            if (right.size() > n) {
                int r = right.poll();
                sum = sum - r;
            }
            partSecond[i] = sum;
        }
        return partSecond;
    }

    public long minimumDifferenceWrong(int[] nums) {
        int n = nums.length / 3;
        int[] sumsFromLeft = sumFromLeft(nums);
        int[] sumsFromRight = sumFromRight(nums);

        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(sumsFromLeft));
        System.out.println(Arrays.toString(sumsFromRight));

        int min = Integer.MAX_VALUE;
        int total = sumsFromRight[0];
        for (int i = 0; i < nums.length - n + 1; i++) {
            int removeEnd = sumsFromLeft[i + n - 1];
            int removeStart = (i - 1 < 0) ? 0 : sumsFromLeft[i - 1];
            int remove = removeEnd - removeStart;
            int leftArray;
            int rightArray;
            if (i < 2 * n - 1) {
                leftArray = total - remove - sumsFromRight[nums.length - n];
                rightArray = sumsFromRight[nums.length - n];
            } else {
                leftArray = sumsFromLeft[n - 1];
                rightArray = total - remove - leftArray;
            }
            int current = leftArray - rightArray;
            if (current < min) {
                min = current;
            }
            System.out.println(remove + " " + leftArray + " " + rightArray + " " + current);
        }

        return min;
    }

    private static int[] sumFromRight(int[] nums) {
        int[] sumsFromRight = new int[nums.length];
        sumsFromRight[nums.length - 1] = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            sumsFromRight[i] = sumsFromRight[i + 1] + nums[i];
        }
        return sumsFromRight;
    }

    private static int[] sumFromLeft(int[] nums) {
        int[] sumsFromLeft = new int[nums.length];
        sumsFromLeft[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sumsFromLeft[i] = nums[i] + sumsFromLeft[i];
        }
        return sumsFromLeft;
    }

    public static void main(String[] args) {
        MinimumDifferenceSumsAfterRemovalElements x = new MinimumDifferenceSumsAfterRemovalElements();
        System.out.println(x.minimumDifference(new int[]{7, 9, 5, 8, 1, 3}));
        System.out.println(x.minimumDifference(new int[]{3, 1, 2}));
    }

}
