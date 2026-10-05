package playground.leetcode3;

public class MaximumNestingDepthofTwoValidParenthesesStrings {

    public int[] maxDepthAfterSplit(String seq) {
        int res[] = new int[seq.length()];
        int d = 0;
        int i = 0;
        for (char c : seq.toCharArray()) {
            if (c == '(') {
                d++;
                res[i] = d % 2;
            } else {
                res[i] = d % 2;
                d--;
            }
            i++;
        }

        return res;
    }

}
