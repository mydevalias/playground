package playground.leetcode2;

import java.util.Arrays;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class MinimumCommonValue {
    public int getCommon(int[] nums1, int[] nums2) {
        for (int num1 : nums1) {
            int pos = Arrays.binarySearch(nums2, num1);
            if (pos > -1) {
                return num1;
            }
        }
        return -1;
    }
}
