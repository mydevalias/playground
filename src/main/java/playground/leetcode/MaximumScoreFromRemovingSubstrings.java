package playground.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * https://leetcode.com/problems/maximum-score-from-removing-substrings/description/
 */
public class MaximumScoreFromRemovingSubstrings {

    public int maximumGain(String s, int x, int y) {
        String removeFirst = "ab";
        String removeSecond = "ba";
        if (y > x) {
            removeFirst = "ba";
            removeSecond = "ab";
        }
        int score = 0;
        String afterFirstPass = remove(removeFirst, s);
        score = score + ((s.length() - afterFirstPass.length()) / 2 * Math.max(x, y));
        String afterSecondPass = remove(removeSecond, afterFirstPass);
        score = score + ((afterFirstPass.length() - afterSecondPass.length()) / 2 * Math.min(x, y));
        return score;
    }

    private String remove(String remove, String s) {
        Deque<Character> stack = new ArrayDeque<>();

        char secondChar = remove.charAt(1);
        char firstChar = remove.charAt(0);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (secondChar == c &&
                    !stack.isEmpty() && firstChar == stack.peek()) {
                stack.poll();
            } else {
                stack.push(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.removeLast());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        MaximumScoreFromRemovingSubstrings msrs = new MaximumScoreFromRemovingSubstrings();
        System.out.println(msrs.maximumGain("cdbcbbaaabab", 4, 5));
        System.out.println(msrs.maximumGain("aabbaaxybbaabb", 5, 4));
//cdbcbbaaabab
//bacbdc
    }

}
