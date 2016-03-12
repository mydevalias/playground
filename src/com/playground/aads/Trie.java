package com.playground.aads;

import java.util.ArrayList;
import java.util.List;

/**
 * In computer science, a trie, also called digital tree and sometimes radix tree or prefix tree (as they can be searched
 * by prefixes), is an ordered tree data structure that is used to store a dynamic set or associative array where the
 * keys are usually strings.
 * <p>
 * In a trie indexing an alphabet of 26 letters, each node has 26 possible children and, therefore, 26 possible pointers.
 * Each node thus features an array of 26 (pointers to) sub-trees, where each value could either be null
 * (if there is no such child) or another node.
 * <p>
 * Created by liviu on 12.03.2016.
 */
public class Trie {

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        root.addWord(word.toLowerCase());
    }


    public List<String> getWords(String prefix) {
        TrieNode lastNode = root;
        for (int i = 0; i < prefix.length(); i++) {
            lastNode = lastNode.getNode(prefix.charAt(i));
            if (lastNode == null) {
                return new ArrayList<>();
            }
        }
        return lastNode.getWords();
    }

    private class TrieNode {
        private TrieNode parent;
        private TrieNode[] children;
        private boolean isLeaf;     //Quick way to check if any children exist
        private boolean isWord;     //Does this node represent the last character of a word
        private char character;     //The character this node represents

        public TrieNode() {
            children = new TrieNode[26];
            isLeaf = true;
            isWord = false;
        }

        public TrieNode(char character) {
            this();
            this.character = character;
        }

        private void addWord(String word) {
            isLeaf = false;
            int charPos = index(word.charAt(0));

            if (children[charPos] == null) {
                children[charPos] = new TrieNode(word.charAt(0));
                children[charPos].parent = this;
            }

            if (word.length() > 1) {
                children[charPos].addWord(word.substring(1));
            } else {
                children[charPos].isWord = true;
            }
        }

        private int index(char c) {
            return c - 'a';
        }

        private TrieNode getNode(char c) {
            return children[index(c)];
        }

        private List<String> getWords() {
            List<String> list = new ArrayList<>();
            if (isWord) {
                StringBuilder sb = new StringBuilder();
                toWord(sb);
                list.add(sb.toString());
            }

            if (!isLeaf) {
                for (int i = 0; i < children.length; i++) {
                    if (children[i] != null) {
                        list.addAll(children[i].getWords());
                    }
                }
            }
            return list;
        }

        private void toWord(StringBuilder sb) {
            if (parent != null) {
                parent.toWord(sb);
            }
            sb.append(character);
        }

    }
}
