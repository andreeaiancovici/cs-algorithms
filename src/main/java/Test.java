import java.io.IOException;

public class Test {
    private static final Trie trie = new Trie();

    // d wmo diz xv v b o sxxw

    public static void main(String[] args) throws IOException {
        System.out.println(minExtraChar("dwmodizxvvbosxxw",
                new String[]{"ox", "lb", "diz", "gu", "v", "ksv", "o", "nuq", "r", "txhe", "e", "wmo", "cehy", "tskz", "ds", "kzbu"}));
    }

    public static int minExtraChar(String s, String[] dictionary) {
        for (String word : dictionary) trie.insert(word);

        return dp(s, 0, trie.root);
    }

    private static int dp(String s, int index, TrieNode node) {
        if (index == s.length()) {
            return 0;
        }

        int minChars = Integer.MAX_VALUE;

        minChars = dp(s, index + 1, trie.root) + 1;

        char c = s.charAt(index);

        if (index == 1) {
            System.out.println();
        }

        if (node.children[c - 'a'] != null) {
            if (node.children[c - 'a'].isWord) {
                minChars = Math.min(minChars, dp(s, index + 1, trie.root));
            }

            minChars = Math.min(minChars, dp(s, index + 1, node.children[c - 'a']));
        }


        return minChars;
    }

    static class TrieNode {

        private final TrieNode[] children;
        private boolean isWord;

        TrieNode() {
            children = new TrieNode[26];
        }
    }

    static class Trie {

        private final TrieNode root;

        Trie() {
            root = new TrieNode();
        }

        private void insert(String word) {
            TrieNode node = root;

            for (char c : word.toCharArray()) {
                if (node.children[c - 'a'] == null) node.children[c - 'a'] = new TrieNode();

                node = node.children[c - 'a'];
            }

            node.isWord = true;
        }
    }
}
