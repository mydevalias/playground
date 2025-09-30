package playground.leetcode;

import java.util.Arrays;

public class LargestPerimeterTriangle {

    public static boolean exists(int a, int b, int c) {
        if (a <= 0 || b <= 0 || c <= 0) {
            return false;
        }
        return (a + b > c) && (a + c > b) && (b + c > a);
    }

    public int largestPerimeter(int[] nums) {
        int largest = 0;
        Arrays.sort(nums);
        for(int i=nums.length-3;i>=0;i--){
            if(exists(nums[i], nums[i+1], nums[i+2])){
                return nums[i]+ nums[i+1]+ nums[i+2];
            }
        }
        return largest;
    }

}
