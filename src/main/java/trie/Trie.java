package trie;

public class Trie {
    private final TrieNode root;

    Trie() {
        root = new TrieNode();
    }

    void insert(String word) {
        TrieNode node = root;

        for (char c : word.toCharArray()) {
            node.wordsUsingNode++;
            if (node.children[c - 'a'] == null) node.children[c - 'a'] = new TrieNode();
            node = node.children[c - 'a'];
        }

        node.isWord = true;
    }

    boolean find(String word) {
        TrieNode node = root;

        for (char c : word.toCharArray()) {
            if (node.children[c - 'a'] == null) return false;
            node = node.children[c - 'a'];
        }

        return node.isWord;
    }

    void delete(String word) {
        TrieNode node = root;
        TrieNode prev = root;

        for (char c : word.toCharArray()) {
            node = node.children[c - 'a'];
            node.wordsUsingNode--;

            if (node.wordsUsingNode == 0) {
                prev.children[c - 'a'] = null;
                return;
            }

            prev = node;
        }
    }

    static class TrieNode {

        private final TrieNode[] children;
        private int wordsUsingNode;
        private boolean isWord;

        TrieNode() {
            children = new TrieNode[26];
        }
    }
}
