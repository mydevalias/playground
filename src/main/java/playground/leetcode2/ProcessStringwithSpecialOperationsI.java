package playground.leetcode2;

public class ProcessStringwithSpecialOperationsI {
    public String processStr(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == '*') {
                if (!sb.isEmpty()) {
                    sb.deleteCharAt(sb.length() - 1);
                }
            } else {
                if (c == '#') {
                    sb.append(sb.toString());
                } else {
                    if (c == '%') {
                        sb = sb.reverse();
                    } else {
                        sb.append(c);
                    }
                }
            }
        }
        return sb.toString();
    }
}
