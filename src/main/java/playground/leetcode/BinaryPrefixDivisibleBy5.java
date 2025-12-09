package playground.leetcode;

import java.util.ArrayList;
import java.util.List;

public class BinaryPrefixDivisibleBy5 {

    public List<Boolean> prefixesDivBy5(int[] nums) {
        ArrayList<Boolean> res = new ArrayList<>();
        int remainder = 0;
        for (int i = 0; i < nums.length; i++) {
            remainder = (remainder * 2 + nums[i]) % 5;
            res.add(remainder == 0);
        }
        return res;
    }


}
