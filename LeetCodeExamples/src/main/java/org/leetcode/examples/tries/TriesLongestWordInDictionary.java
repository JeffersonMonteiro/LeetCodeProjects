package org.leetcode.examples.tries;

import org.leetcode.examples.tries.model.TrieNode;

public class TriesLongestWordInDictionary extends TrieOperations {

    private final TrieNode root;

    public TriesLongestWordInDictionary() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode currentNode = root;
        for (char c : word.toCharArray()) {
            if (!currentNode.edges.containsKey(c))
                currentNode.edges.put(c, new TrieNode());
            currentNode = currentNode.edges.get(c);
        }
        currentNode.isWordEnd = true;
    }

    public boolean canBeBuilt(String word) {
        TrieNode currentNode = root;
        for (char c : word.toCharArray()) {
            if (!currentNode.edges.containsKey(c))
                return false;
            currentNode = currentNode.edges.get(c);
            if (!currentNode.isWordEnd)
                return false;
        }
        return true;
    }

    public String longestWord(String[] words) {
        if (words == null || words.length == 0)
            return null;

        TriesLongestWordInDictionary trie = new TriesLongestWordInDictionary();
        for (String word : words)
            trie.insert(word);

        String answer = null;
        for (String word : words)
            if (trie.canBeBuilt(word))
                if (answer == null || answer.length() < word.length() || (answer.length() == word.length() && word.compareTo(answer) < 0)) {
                    answer = word;
                }

        return answer;
    }

    public static void main(String[] args) {
        TriesLongestWordInDictionary trie = new TriesLongestWordInDictionary();
        TrieNode root = new TrieNode();
        //trie.insert("Compact");

        if (trie.canBeBuilt("Compact")) {
            System.out.println("It can be built");
        } else {
            System.out.println("t can not be built");
        }

       String [] words = {"w","wo","wor","worl","world"};

        System.out.println(trie.longestWord(words));

        String [] words2 = {"a","banana","app","appl","ap","apply","apple"};

        System.out.println(trie.longestWord(words2));
    }
}
