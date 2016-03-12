package com.playground.hackerrank;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by liviu on 12.03.2016.
 */
public class Contacts {

    public static void main(String... args) throws FileNotFoundException {
        HackeRrankUtils hru = new HackeRrankUtils();
        int sc = Integer.valueOf(hru.nextLine());
        Trie trie = new Trie();
        for (int i = 0; i < sc; i++) {
            String s = hru.nextLine();
            if (s.startsWith("add")) {
                trie.addWord(s.substring(s.indexOf(' ') + 1));
            } else {
                if (s.startsWith("find")) {
                    hru.output.append(trie.getWords(s.substring(s.indexOf(' ') + 1)));
                    hru.line();
                }
            }
        }
//        trie.addWord("s");
//        hru.output.append(trie.getWords("s"));
        hru.printBuilder();
    }

    public static class Trie {

        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void addWord(String word) {
            root.addWord(word, 0);
        }


        public int getWords(String prefix) {
            TrieNode lastNode = root;
            for (int i = 0; i < prefix.length(); i++) {
                lastNode = lastNode.getNode(prefix.charAt(i));
                if (lastNode == null) {
                    return 0;
                }
            }
            return lastNode.getWords();
        }

        private class TrieNode {
            private TrieNode[] children;
            private boolean isLeaf;
            private boolean isWord;
            int count = 0;

            public TrieNode() {
                children = new TrieNode[26];
                isLeaf = true;
                isWord = false;
            }

            public TrieNode(char character) {
                this();
            }

            private void addWord(String word, int i) {

                count++;
                isLeaf = false;
                int charPos = index(word.charAt(i));

                if (children[charPos] == null) {
                    children[charPos] = new TrieNode(word.charAt(i));
                }

                if (word.length() - 1 > i) {
                    children[charPos].addWord(word, i + 1);
                } else {
                    children[charPos].count++;
                    children[charPos].isWord = true;
                }
            }

            private int index(char c) {
                return c - 'a';
            }

            private TrieNode getNode(char c) {
                return children[index(c)];
            }

            private int getWords() {
                return count;
            }
        }
    }


    public static class HackeRrankUtils {

        File file = new File("inputs/contacts/in.txt");

        Scanner scanner = new Scanner(System.in);

        StringBuilder output = new StringBuilder();

        public HackeRrankUtils() throws FileNotFoundException {
            scanner = new Scanner(file);
        }

        void printBuilder() {
            System.out.print(output.toString());
        }

        void line() {
            output.append(System.lineSeparator());
        }

        String nextLine() {
            return scanner.nextLine();
        }

    }

}
