package Google;

public class DesignAddAndSearchDS {
    class TrieNode {
        TrieNode child[];
        boolean wordEnd;

        public TrieNode() {
            child = new TrieNode[26];
            wordEnd = false;
        }
    }

    TrieNode root;

    public DesignAddAndSearchDS() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode curr = root;
        for (char ch : word.toCharArray()) {
            if (curr.child[ch - 'a'] == null) {
                curr.child[ch - 'a'] = new TrieNode();
            }
            curr = curr.child[ch - 'a'];
        }
        curr.wordEnd = true;
    }

    public boolean searchRecur(String word, TrieNode root) {
        TrieNode curr = root;
        if (word.isEmpty())
            return curr.wordEnd;

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            // . to be handled as a wildcard
            if (ch == '.') {
                for (TrieNode childNode : curr.child) {
                    if (childNode != null && searchRecur(word.substring(i + 1), childNode)) {
                        return true;
                    }
                }
                return false;
            }
            if (curr.child[ch - 'a'] == null) {
                return false;
            }
            curr = curr.child[ch - 'a'];
        }

        return curr.wordEnd;
    }

    public boolean search(String word) {
        return searchRecur(word, root);
    }
}
