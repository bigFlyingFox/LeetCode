class TrieNode {
    // Initialize your data structure here.
    boolean eow;
    TrieNode[] next;
    
    public TrieNode() {
        this.eow = false;
        this.next = new TrieNode[26];
        
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }
    
    private TrieNode put(TrieNode x, String str, int d) {
        if (x == null)  x = new TrieNode();
        if (d == str.length()) {
            x.eow = true;
            return x;
        }
        int c = str.charAt(d) - 'a';
        x.next[c] = put(x.next[c], str, d+1);
        return x;
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        root = put(root, word, 0);
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode x = get(root, word, 0);
        if (x == null) return false;
        else           return x.eow;
    }
    
    private TrieNode get(TrieNode x, String str, int d) {
        if (x == null)  return null;
        if (d == str.length())  return x;
        int c = str.charAt(d) - 'a';
        return get(x.next[c], str, d+1);
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode x = get(root, prefix, 0);
        if (x == null)  return false;
        else            return true;
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");