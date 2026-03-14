package playground.leetcode2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FindUniqueBinaryString {

    public String findDifferentBinaryString(String[] nums) {
        int n = nums.length;
        long num = 1L << n;
        Set<String> all = new HashSet<>();
        all.addAll(Arrays.asList(nums));
        for (long i = num; i < 1L << (n + 1); i++) {
            String binary = Long.toBinaryString(i);
            String padded = ("0".repeat(n) + binary).substring(binary.length());
            if (!all.contains(padded)) {
                return padded;
            }
        }
        return "";
    }

}
