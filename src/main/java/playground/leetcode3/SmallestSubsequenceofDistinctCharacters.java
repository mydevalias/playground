package playground.leetcode3;

import java.util.ArrayDeque;
import java.util.Deque;

public class SmallestSubsequenceofDistinctCharacters {

    public String smallestSubsequence(String s) {
        int[] lasts = lasta(s);

        Deque<Character> stack = new ArrayDeque<>();
        boolean[] added = new boolean[26];
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            char c = s.charAt(i);
            if (added[index]) {
                continue;
            }
            while (!stack.isEmpty() && stack.peek() > c && lasts[stack.peek()-'a'] > i) {
                added[stack.pop() - 'a'] = false;
            }
            stack.push(c);
            added[index] = true;
        }

        StringBuilder sb = new StringBuilder();
        for (Character c : stack) {
            sb.append(c);
        }

        return sb.reverse().toString();
    }

    private static int[] lasta(String s) {
        int[] lasts = new int[26];
        for (int i = 0; i < s.length(); i++) {
            lasts[s.charAt(i) - 'a'] = i;
        }
        return lasts;
    }

    private static String missunderstnading(String s) {
        int[] counts = new int['z' - 'a' + 1];
        int max = 0;
        String res = "";
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            counts[s.charAt(i) - 'a']++;
            while (counts[s.charAt(i) - 'a'] > 1) {
                counts[s.charAt(left) - 'a']--;
                left++;
            }
            if (i - left + 1 >= max) {
                max = i - left + 1;
                String substring = s.substring(left, i + 1);
                if (res.length() < substring.length()) {
                    res = substring;
                } else {
                    if (substring.compareTo(res) < 0) {
                        res = substring;
                    }
                }

            }
        }
        return res;
    }


}
