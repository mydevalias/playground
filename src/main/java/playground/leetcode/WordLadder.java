package playground.leetcode;

import java.util.*;

public class WordLadder {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> space = new HashSet<>(wordList);
        if (!space.contains(endWord)) {
            return 0;
        }
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        Set<String> visited = new HashSet<>();
        int round = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String current = queue.poll();

                for (int pos = 0; pos < current.length(); pos++) {
                    for (char c = 'a'; c <= 'z'; c++) {
                        String newWord = current.substring(0, pos) + c + current.substring(pos + 1);
                        if (!space.contains(newWord)) {
                            continue;
                        }
                        if (newWord.equals(endWord)) {
                            return round + 1;
                        }
                        if (visited.contains(newWord)) {
                            continue;
                        }
                        visited.add(newWord);
                        queue.add(newWord);
                    }
                }

            }

            round++;
        }

        return 0;
    }
}
