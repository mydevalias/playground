package playground.leetcode;

public class MaximumProductSubarray {

    long max;

    public void maxProduct(int[] nums, int start, int end) {
        if (start == end) {
            return;
        }
        if (end - start == 1) {
            return;
        }
        long product = 1;

        long product2 = 1;
        int length = 0;
        boolean first = false;

        for (int i = start; i < end; i++) {
            product = product * nums[i];

            if (!first && nums[i] < 0) {
                first = true;
                continue;
            }
            if (first) {
                product2 = product2 * nums[i];
                length++;
            }
        }
        max = Math.max(product, max);
        if (product > 0) {
            return;
        }

        if (length > 0) {
            max = Math.max(product2, max);
        }
        product = 1;
        first = false;
        length = 0;
        for (int i = end - 1; i >= start; i--) {
            if (!first && nums[i] < 0) {
                first = true;
                continue;
            }
            if (first) {
                length++;
                product = product * nums[i];
            }
        }
        if (length > 0) {
            max = Math.max(product, max);
        }

    }

    public int maxProduct(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int start = 0;
        max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            if (nums[i] == 0) {
                maxProduct(nums, start, i);
                start = i + 1;
            }
            if (i == nums.length - 1) {
                if (nums[i] == 0) {
                    break;
                }
                maxProduct(nums, start, i + 1);
                start = i + 1;
            }
        }
        return (int) max;
    }

    public static void main(String[] args) {
        var m = new MaximumProductSubarray();
//        System.out.println(m.maxProduct(new int[]{0}));
//        System.out.println(m.maxProduct(new int[]{-1,-1,0}));
//        System.out.println(m.maxProduct(new int[]{-3, -1, -1}));
        System.out.println(m.maxProduct(new int[]{0, -2, 0}));
//        System.out.println(m.maxProduct(new int[]{2, 3, -2, 4}));
//        System.out.println(m.maxProduct(new int[]{3, -1, 4}));
    }

}
