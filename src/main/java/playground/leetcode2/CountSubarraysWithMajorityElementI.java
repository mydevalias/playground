package playground.leetcode2;

public class CountSubarraysWithMajorityElementI {

    public int countMajoritySubarrays(int[] nums, int target) {
        int count = 0;
        for(int i=0;i<nums.length;i++){
            int current = 0;
            for(int j=i;j<nums.length;j++){
                if(nums[j] == target){
                    current++;
                }
                int l = j - i + 1;
                if (current > l - current) {
                    count++;
                }
            }
        }
        return count;
    }

}
