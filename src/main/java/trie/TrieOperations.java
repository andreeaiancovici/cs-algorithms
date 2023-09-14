package trie;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TrieOperations {

    public static void main(String[] args) {
        Trie trie = new Trie();

        trie.insert("programming");
        trie.insert("is");
        trie.insert("a");
        trie.insert("way");
        trie.insert("of");
        trie.insert("life");

        assertFalse(trie.find("b"));
        assertFalse(trie.find("vida"));
        assertTrue(trie.find("life"));
        assertTrue(trie.find("programming"));

        trie.delete("programming");

        assertFalse(trie.find("programming"));
    }
}
