package org.leetcode.examples.tries;

import org.leetcode.examples.tries.model.TrieNode;

public class TriePrefixTree extends TrieOperations{

//    private TrieNode root;
//
//    /** Initialize your data structure here. */
//    public TriePrefixTree() {
//        root = new TrieNode();
//    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix, TrieNode node) {
        TrieNode currentNode = node;
        for (char c : prefix.toCharArray()) {
            if (!currentNode.edges.containsKey(c))
                return false;
            currentNode = currentNode.edges.get(c);
        }
        return true;
    }

    public static void main(String[] args) {

        TriePrefixTree trie = new TriePrefixTree();
        TrieNode root = new TrieNode();
        trie.insert(root, "Compact");

        if (trie.search(root, "Compacted")) {
            System.out.println("Found");
        } else {
            System.out.println("Not Found");
        }

        if (trie.startsWith("Com", root)) {
            System.out.println("Found");
        } else {
            System.out.println("Not Found");
        }
    }
}
