package playground.leetcode2;

import java.util.ArrayList;
import java.util.List;

public class PartitionArrayAccordingToGivenPivot {

    public int[] pivotArray(int[] nums, int pivot) {
        List<Integer> smaller = new ArrayList<>();
        List<Integer> higher = new ArrayList<>();
        int count = 0;
        for (int val : nums) {
            if (val < pivot) {
                smaller.add(val);
            } else {
                if (val > pivot) {
                    higher.add(val);
                } else {
                    count++;
                }
            }
        }
        int i = 0;
        for (int val : smaller) {
            nums[i] = val;
            i++;
        }
        for (int k = 0; k < count; k++) {
            nums[i] = pivot;
            i++;
        }
        for (int val : higher) {
            nums[i] = val;
            i++;
        }
        return nums;
    }

}
