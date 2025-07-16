package playground.leetcode;

/**
 * https://leetcode.com/problems/valid-parentheses/description/
 */
public class ValidParentheses {

    public boolean isValid(String s) {
        int n = s.length();
        if (n % 2 != 0) return false;

        char[] stack = new char[n / 2 + 4];
        int top = -1;

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (top > n / 2 + 2 && i > n / 2 + 1) {
                return false;
            }

            if (c == '(' || c == '[' || c == '{') {
                stack[++top] = c;
            } else {
                if (top == -1) return false;
                char open = stack[top--];
                if ((c == ')' && open != '(') ||
                        (c == ']' && open != '[') ||
                        (c == '}' && open != '{')) {
                    return false;
                }
            }
        }
        return top == -1;
    }

    public static void main(String[] args) {
        ValidParentheses vp = new ValidParentheses();
        System.out.println(vp.isValid("([])"));
    }
}
