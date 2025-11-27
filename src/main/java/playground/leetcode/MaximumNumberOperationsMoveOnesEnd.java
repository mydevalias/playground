package playground.leetcode;

public class MaximumNumberOperationsMoveOnesEnd {


    public int maxOperations(String s) {
        int zeros = 0;
        int res = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '1') {
                res += zeros;
            }else{
                zeros++;
            }

        }
        return res;
    }

    public int maxOperations2(String s) {
        int res = 0;
        int i = 0;
        int ones = 0;
        while (i < s.length()) {
            if (s.charAt(i) == '0') {
                while (i + 1 < s.length() && s.charAt(i + 1) == '0') {
                    i++;
                }
                res += ones;
            } else {
                ones++;
            }
            i++;
        }
        return res;
    }
}
