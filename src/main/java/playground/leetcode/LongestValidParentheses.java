package playground.leetcode;

public class LongestValidParentheses {

    private String s;
    private int max = 0;

    public int longestValidParentheses(String s) {
        this.s = s;
        max = 0;
        for (int i = 0; i < s.length(); i++) {
            maxValid(i);
            if(max> s.length()-i){
                break;
            }
        }
        return max;
    }

    public void maxValid(int start) {
        int n = s.length();

        char[] stack = new char[n];
        int top = -1;
        int currentMax = 0;
        for (int i = start; i < n; i++) {
            char c = s.charAt(i);
            currentMax++;
            if (c == '(' || c == '[' || c == '{') {
                stack[++top] = c;
            } else {
                if (top == -1) {
                    return;
                }
                char open = stack[top--];
                if ((c == ')' && open != '(') ||
                        (c == ']' && open != '[') ||
                        (c == '}' && open != '{')) {
                    return;
                } else {
                    if (top == -1) {
                        max = Math.max(currentMax, max);
                    }
                }
            }
        }
        if (top == -1) {
            max = Math.max(currentMax, max);
        }
    }

    public static void main(String[] args) {
        System.out.println(new LongestValidParentheses().longestValidParentheses(")()())"));
    }
}
