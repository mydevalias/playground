package playground.leetcode2;

import java.util.*;

public class MaximumDistanceBetweenaPairOfValues {

    public int maxDistance(int[] nums1, int[] nums2) {
        int max = 0;
        for (int i = 0; i < nums1.length; i++) {
            if (i >= nums2.length) {
                break;
            }
            int pos = binarySearch(nums2, i,  nums1[i]);
            if(pos==-1){
                continue;
            }
            max = Math.max(max, pos-i);
        }
        return max;
    }

    private int binarySearch(int[] nums2, int from, int target) {
        int lo = from, hi = nums2.length - 1, best = -1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (nums2[mid] >= target) {
                best = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return best;
    }

    public int wrongUnderstandingMaxDistance(int[] nums1, int[] nums2) {
        Map<Integer, Integer> positions = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            positions.put(nums2[i], i);
        }
        int max = -1;
        for (int i = 0; i < nums1.length; i++) {
            Integer other = positions.get(nums1[i]);
            if (other == null) {
                continue;
            }
            if (other > i) {
                max = Math.max(max, other - i);
            }
        }

        return 0;
    }

}
