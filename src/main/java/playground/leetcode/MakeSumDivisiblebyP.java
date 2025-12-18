package playground.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class MakeSumDivisiblebyP {

    public int minSubarray(int[] nums, int p) {
        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        int target = (int) (sum % p);
        if (target == 0) {
            return 0;
        }

        Map<Integer, Integer> seen = new HashMap<>();
        seen.put(0, -1);  // Empty prefix has remainder 0 at position -1

        long prefixSum = 0;
        int minLen = nums.length;

        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];
            int currentRemainder = (int) (prefixSum % p);

            int need = currentRemainder - target;
            if (need < 0) {
                need += p;  // Make it positive
            }

            if (seen.containsKey(need)) {
                int j = seen.get(need);
                minLen = Math.min(minLen, i - j);
            }

            seen.put(currentRemainder, i);
        }

        return minLen == nums.length ? -1 : minLen;
    }

    public int minSubarraySlow(int[] nums, int p) {
        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % p == 0) {
            return 0;
        }
        int minLen = nums.length;

        for (int i = 0; i < nums.length; i++) {
            long cs = 0;
            for (int j = i; j < nums.length; j++) {
                cs += nums[j];
                if ((sum - cs) % p == 0) {
                    minLen = Math.min(j - i + 1, minLen);
                }
            }
            if (minLen < nums.length - i + 1 || minLen == 1) {
                break;
            }
        }
        if (minLen == nums.length) {
            return -1;
        }
        return minLen;
    }
}
