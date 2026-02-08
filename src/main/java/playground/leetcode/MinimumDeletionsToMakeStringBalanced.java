package playground.leetcode;

public class MinimumDeletionsToMakeStringBalanced {

    public int minimumDeletions(String s) {
        int totalA = 0;
        for (char c : s.toCharArray()) {
            if (c == 'a') {
                totalA++;
            }
        }

        int res = s.length();
        int currentB = 0;
        int currentA = totalA;

        for (char c : s.toCharArray()) {
            if (c == 'a') {
                currentA--;
            }

            res = Math.min(res, currentB + currentA);

            if (c == 'b') {
                currentB++;
            }
        }
        return res;
    }

}
