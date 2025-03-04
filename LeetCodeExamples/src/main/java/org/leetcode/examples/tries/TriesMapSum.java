package org.leetcode.examples.tries;

import java.util.HashMap;
import java.util.Map;

public class TriesMapSum {
    private class Trie {

        private class TrieNode {
            Map<Character, TrieNode> edges;
            boolean isWordEnd;
            int value;
            int prefixSum;

            TrieNode() {
                edges = new HashMap<>();
                isWordEnd = false;
                value = 0;
                prefixSum = 0;
            }
        }

        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word, int value) {
            int currentValue = getWordValue(word);
            int difference = value - currentValue;

            TrieNode currentNode = root;
            for (char c : word.toCharArray()) {
                if (!currentNode.edges.containsKey(c))
                    currentNode.edges.put(c, new TrieNode());
                currentNode = currentNode.edges.get(c);
                currentNode.prefixSum += difference;
            }
            currentNode.isWordEnd = true;
            currentNode.value = value;
        }

        public int getWordValue(String word) {
            TrieNode currentNode = root;
            for (char c : word.toCharArray()) {
                if (!currentNode.edges.containsKey(c))
                    return 0;
                currentNode = currentNode.edges.get(c);
            }
            return currentNode.value;
        }

        public int getPrefixSum(String prefix) {
            TrieNode currentNode = root;
            for (char c : prefix.toCharArray()) {
                if (!currentNode.edges.containsKey(c))
                    return 0;
                currentNode = currentNode.edges.get(c);
            }
            return currentNode.prefixSum;
        }
    }

    Trie trie;

    /**
     * Initialize your data structure here.
     */
    public TriesMapSum() {
        trie = new Trie();
    }

    public void insert(String key, int val) {
        trie.insert(key, val);
    }

    public int sum(String prefix) {
        return trie.getPrefixSum(prefix);
    }

    public static void main(String[] args) {
        TriesMapSum triesMapSum = new TriesMapSum();
        triesMapSum.insert("apple", 3);
        System.out.println(triesMapSum.sum("ap"));           // return 3 (apple = 3)
        triesMapSum.insert("app", 2);
        System.out.println(triesMapSum.sum("ap"));           // return 5 (apple + app = 3 + 2 = 5)
        triesMapSum.insert("ap", 1);
        System.out.println(triesMapSum.sum("ap"));           // return 5 (apple + app + ap = 3 + 2 + 1 = 6)
    }
}
