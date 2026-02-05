package playground.leetcode;

public class TrionicArrayI {

    //0 < p < q < n − 1
    public boolean isTrionic(int[] nums) {
        int i = 1;
        while (i < nums.length && nums[i - 1] < nums[i]) {
            i++;
        }
        int p = i - 1;
        while (i < nums.length && nums[i - 1] > nums[i]) {
            i++;
        }
        int q = i - 1;
        while (i < nums.length && nums[i - 1] < nums[i]) {
            i++;
        }
        return p > 0 && p != q && q < nums.length - 1 && i == nums.length ;
    }

}
