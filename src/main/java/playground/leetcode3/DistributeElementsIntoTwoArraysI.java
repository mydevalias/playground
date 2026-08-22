package playground.leetcode3;

import java.util.ArrayList;
import java.util.List;

public class DistributeElementsIntoTwoArraysI {

    public int[] resultArray(int[] nums) {
        List<Integer> a1 = new ArrayList<>();
        List<Integer> a2 = new ArrayList<>();
        a1.add(nums[1]);
        a2.add(nums[2]);
        for(int i=3;i<nums.length;i++){
            if(a1.get(a1.size()-1)>a2.get(a2.size()-1)){
                a1.add(nums[i]);
            }else{
                a2.add(nums[i]);
            }
        }
        a1.addAll(a2);
        return a1.stream().mapToInt(Integer::intValue).toArray();
    }

}
