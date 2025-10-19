package playground.leetcode;

public class Trie {

    public static final int SZ = 'z' - 'a' + 1;
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode current = root;
        for (int c : word.toCharArray()) {
            TrieNode nd = getTrieNode(c, current);
            current = nd;
        }
        current.word = true;
    }

    private TrieNode getTrieNode(int c, TrieNode from) {
        TrieNode nd = from.children[c - 'a'];
        if (nd == null) {
            nd = new TrieNode();
            from.children[c - 'a'] = nd;
        }
        return nd;
    }

    public boolean search(String word) {
        TrieNode current = root;
        for (int c : word.toCharArray()) {
            TrieNode nd = current.children[c - 'a'];
            if (nd == null) {
                return false;
            }
            current = nd;
        }
        return current.word;
    }

    public boolean startsWith(String prefix) {
        TrieNode current = root;
        for (int c : prefix.toCharArray()) {
            TrieNode nd = current.children[c - 'a'];
            if (nd == null) {
                return false;
            }
            current = nd;
        }
        return true;
    }

    class TrieNode {
        char c;
        boolean word = false;
        TrieNode[] children = new TrieNode[SZ];
    }
}
