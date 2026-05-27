package playground.leetcode2;

public class CheckifArrayIsSortedAndRotated {

    public boolean check(int[] nums) {
        boolean inf = false;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] >= nums[i - 1]) {
                continue;
            }
            if (inf) {
                return false;
            }
            inf = true;
        }
        if (inf) {
            return nums[nums.length - 1] <= nums[0];
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new CheckifArrayIsSortedAndRotated().check(new int[]{2, 1, 3, 4}));
    }

}
