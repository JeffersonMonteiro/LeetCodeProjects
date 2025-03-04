package org.leetcode.examples.tries;

import org.leetcode.examples.tries.model.TrieNode;

public class TrieOperations {

    /** Inserts a word into the trie. */
    protected void insert(TrieNode root, String word) {
        TrieNode currentNode = root;
        for (char c : word.toCharArray()) {
            if (!currentNode.edges.containsKey(c)) {
                currentNode.edges.put(c, new TrieNode());
            }
            currentNode = currentNode.edges.get(c);
        }
        currentNode.isWordEnd = true;
    }

    /** Returns if the word is in the trie. */
    protected boolean search(TrieNode root, String word) {
        TrieNode currentNode = root;
        for (char c : word.toCharArray()) {
            if (!currentNode.edges.containsKey(c)) {
                return false;
            }
            currentNode = currentNode.edges.get(c);
        }
        return currentNode.isWordEnd;
    }

    public static void main(String[] args) {

        TrieOperations trie = new TrieOperations();
        TrieNode root = new TrieNode();
        trie.insert(root, "Compact" );

        if(trie.search(root, "Compacted")){
            System.out.println("Found");
        }else{
            System.out.println("Not Found");
        }

    }

}
