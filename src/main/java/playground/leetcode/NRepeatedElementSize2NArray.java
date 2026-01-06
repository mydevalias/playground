package playground.leetcode;

public class NRepeatedElementSize2NArray {

    public int repeatedNTimes(int[] nums) {
        int counts[] = new int[nums.length / 2 + 1];
        for (int val : nums) {
            counts[val]++;
            if (counts[val] > 1) {
                return val;

            }
        }
        return -1;
    }

}
