package playground.leetcode3;

public class FindXValueofArrayI {
    int[] nums;
    long[] result;

    public long[] resultArray(int[] nums, int k) {
        this.nums = nums;
        result = new long[k];
        long[] prevEndings = new long[k];

        for (int i = 0; i < nums.length; i++) {
            long[] newEndings = extendByOneElement(prevEndings, nums[i], k);
            addToResult(result, newEndings, k);
            prevEndings = newEndings;
        }

        return result;
    }

    private long[] extendByOneElement(long[] prevEndings, int currentValue, int k) {
        long[] newEndings = new long[k];

        newEndings[currentValue % k] = 1;

        for (int remainder = 0; remainder < k; remainder++) {
            int newRemainder = (int) ((long) remainder * currentValue % k);
            newEndings[newRemainder] += prevEndings[remainder];
        }

        return newEndings;
    }

    private void addToResult(long[] result, long[] endings, int k) {
        for (int r = 0; r < k; r++) {
            result[r] += endings[r];
        }
    }

    public long[] slowResultArray(int[] nums, int k) {
        int n = nums.length;
        long[] result = new long[k];

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int x = productMod(nums, i, j, k);
                result[x]++;
            }
        }

        return result;
    }

    private int productMod(int[] nums, int i, int j, int k) {
        long product = 1;
        for (int idx = i; idx <= j; idx++) {
            product = (product * nums[idx]) % k;
        }
        return (int) product;
    }
}
