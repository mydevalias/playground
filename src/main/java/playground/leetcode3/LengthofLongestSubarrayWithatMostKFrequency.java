package playground.leetcode3;

import java.util.*;

public class LengthofLongestSubarrayWithatMostKFrequency {

    public int maxSubarrayLength(int[] nums, int k) {
        if (nums.length == 0) {
            return 0;
        }
        IntFrequencyTracker ift = new IntFrequencyTracker();
        int left = 0;
        int max = 0;
        for (int right = 0; right < nums.length; right++) {
            ift.add(nums[right]);
            while (ift.getMaxCount() > k) {
                ift.remove(nums[left]);
                left++;
            }
            max = Math.max(max, right - left + 1);
        }
        return max;
    }


    class IntFrequencyTracker {
        Map<Integer, Integer> countByValue = new HashMap<>();
        TreeMap<Integer, Set<Integer>> valuesByCount = new TreeMap<>();

        public void add(int value) {
            int oldCount = countByValue.getOrDefault(value, 0);
            int newCount = oldCount + 1;
            countByValue.put(value, newCount);
            removeFromReverseMap(value, oldCount);
            valuesByCount.computeIfAbsent(newCount, k -> new HashSet<>()).add(value);
        }

        public void remove(int value) {
            Integer oldCount = countByValue.get(value);
            if (oldCount == null) {
                return;
            }

            removeFromReverseMap(value, oldCount);

            if (oldCount == 1) {
                countByValue.remove(value);
            } else {
                int newCount = oldCount - 1;
                countByValue.put(value, newCount);
                valuesByCount.computeIfAbsent(newCount, k -> new HashSet<>()).add(value);
            }
        }

        public int getMaxCount() {
            if (valuesByCount.isEmpty()) {
                return 0;
            }
            return valuesByCount.lastKey();
        }

        private void removeFromReverseMap(int value, int count) {
            Set<Integer> values = valuesByCount.get(count);
            if (values == null) {
                return;
            }
            values.remove(value);
            if (values.isEmpty()) {
                valuesByCount.remove(count);
            }
        }

    }
}
