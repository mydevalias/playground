package playground.leetcode;

public class CountHillsValleysArray {

    public int countHillValley(int[] nums) {
        int hv = 0;
        for (int i = 1; i < nums.length - 1; i++) {
            int prev = nums[i - 1];
            int current = nums[i];
            int next = nums[i + 1];
            while (i < nums.length - 2 && current == next) {
                i++;
                next = nums[i + 1];
            }
            if (prev > current && current < next) {
                hv++;
            } else {
                if (prev < current && current > next) {
                    hv++;
                }
            }
        }
        return hv;
    }

}
