package playground.leetcode;

import java.util.*;

public class LexicographicallySmallestStringAfterApplyingOperations {

    public String findLexSmallestString(String s, int a, int b) {
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        String smallest = s;

        queue.offer(s);
        visited.add(s);

        while (!queue.isEmpty()) {
            String current = queue.poll();

            if (current.compareTo(smallest) < 0) {
                smallest = current;
            }

            String added = addToOdd(current, a);
            if (!visited.contains(added)) {
                visited.add(added);
                queue.offer(added);
            }

            String rotated = rotate(current, b);
            if (!visited.contains(rotated)) {
                visited.add(rotated);
                queue.offer(rotated);
            }
        }

        return smallest;
    }

    private String addToOdd(String s, int a) {
        char[] chars = s.toCharArray();
        for (int i = 1; i < chars.length; i += 2) {
            int digit = (chars[i] - '0' + a) % 10;
            chars[i] = (char) ('0' + digit);
        }
        return new String(chars);
    }

    private String rotate(String s, int b) {
        int n = s.length();
        b = b % n;
        return s.substring(n - b) + s.substring(0, n - b);
    }
}
