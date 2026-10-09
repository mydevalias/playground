package playground.leetcode3;

public class RemoveOutermostParentheses {

    public String removeOuterParentheses(String s) {
        int count = 0;
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                count++;
                if (count > 1) {
                    sb.append(c);
                }
            } else {
                if (count > 1) {
                    sb.append(c);
                }
                count--;
            }
        }
        return sb.toString();
    }

}
