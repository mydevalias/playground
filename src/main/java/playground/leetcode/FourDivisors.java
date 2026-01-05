package playground.leetcode;

import java.util.HashMap;

public class FourDivisors {

    public static int findDivisors(int n) {
        int sum = 0;
        int count = 0;
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                sum += i;
                count++;
                if (i != n / i) {
                    sum += n / i;
                    count++;
                }
                if (count > 4) {
                    return -1;
                }
            }
        }
        if (count == 4) {
            return sum;
        }
        return -1;
    }

    public int sumFourDivisors(int[] nums) {
        int sum = 0;
        HashMap<Integer, Integer> cache = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer cv = cache.get(nums[i]);
            if (cv == null) {
                int d = findDivisors(nums[i]);
                cache.put(nums[i], d);
                if (d != -1) {
                    sum = sum + d;
                }
            } else {
                if (cv != -1) {
                    sum = sum + cv;
                }
            }
        }
        return sum;
    }

}
