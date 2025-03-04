package org.leetcode.examples.tries.model;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {
    public Map<Character, TrieNode> edges;
    public boolean isWordEnd;

    public TrieNode() {
        this.edges = new HashMap<>();
        this.isWordEnd = false;
    }

}
