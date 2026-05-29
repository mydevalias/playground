package playground.leetcode2;

import java.util.ArrayList;
import java.util.List;

public class LongestCommonSuffixQueries {

    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {
        int[] res = new int[wordsQuery.length];
        TrieNode root = new TrieNode();
        for (int i = 0; i < wordsContainer.length; i++) {
            root.add(new StringBuilder(wordsContainer[i]).reverse().toString(), i, wordsContainer[i].length());
        }
        for (int i = 0; i < wordsQuery.length; i++) {
            res[i] = root.best(new StringBuilder(wordsQuery[i]).reverse().toString());
        }
        return res;
    }

    public static class TrieNode {
        TrieNode[] children = new TrieNode['z' - 'a' + 1];
        int bestIndex = -1;
        int bestLength = Integer.MAX_VALUE;

        void add(String s, int index, int originalLength) {
            if (originalLength < bestLength) {
                bestLength = originalLength;
                bestIndex = index;
            }
            if (s.isEmpty()) {
                return;
            }
            char first = s.charAt(0);
            String rest = s.substring(1);
            TrieNode child = child(first);
            child.add(rest, index, originalLength);
        }

        public TrieNode child(char c) {
            TrieNode child = children[c - 'a'];
            if (child == null) {
                child = new TrieNode();
                children[c - 'a'] = child;
            }
            return child;
        }

        public int best(String s) {
            if (s.isEmpty()) {
                return bestIndex;
            }
            char first = s.charAt(0);
            String rest = s.substring(1);
            TrieNode child = children[first - 'a'];
            if (child == null) {
                return bestIndex;
            }
            return child.best(rest);
        }
    }

}
