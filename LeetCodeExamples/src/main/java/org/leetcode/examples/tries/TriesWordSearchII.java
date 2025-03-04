package org.leetcode.examples.tries;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TriesWordSearchII {
    private class TrieNode {
        Map<Character, TrieNode> edges;
        Integer wordEndingHereIndex;

        TrieNode() {
            this.edges = new HashMap<Character, TrieNode>();
            this.wordEndingHereIndex = null;
        }
    }

    public List<String> findWords(char[][] board, String[] words) {
        List<String> foundWords = new ArrayList<>();
        if (board == null || board.length == 0 || board[0].length == 0 || words == null || words.length == 0)
            return foundWords;

        TrieNode root = new TrieNode();
        for (int i = 0; i < words.length; i++)
            addWord(root, words[i], i);

        boolean[] wordFound = new boolean[words.length];

        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[i].length; j++)
                if (root.edges.containsKey(board[i][j]))
                    search(i, j, root.edges.get(board[i][j]), board, wordFound);

        for (int i = 0; i < words.length; i++)
            if (wordFound[i])
                foundWords.add(words[i]);

        return foundWords;
    }

    private void addWord(TrieNode root, String word, int wordIndex) {
        TrieNode currentNode = root;
        for (char c : word.toCharArray()) {
            if (!currentNode.edges.containsKey(c))
                currentNode.edges.put(c, new TrieNode());
            currentNode = currentNode.edges.get(c);
        }
        currentNode.wordEndingHereIndex = wordIndex;
    }

    private void search(int i, int j, TrieNode currentNode, char[][] board, boolean[] wordFound) {
        if (currentNode.wordEndingHereIndex != null)
            wordFound[currentNode.wordEndingHereIndex] = true;

        char currentLetter = board[i][j];
        board[i][j] = '.';

        final int[] di = {-1, 1, 0, 0};
        final int[] dj = {0, 0, -1, 1};
        for (int k = 0; k < 4; k++) {
            int newI = i + di[k];
            int newJ = j + dj[k];
            if (newI < 0 || newI >= board.length || newJ < 0 || newJ >= board[newI].length)
                continue;

            char newChar = board[newI][newJ];
            if (!currentNode.edges.containsKey(newChar))
                continue;

            search(newI, newJ, currentNode.edges.get(newChar), board, wordFound);
        }

        board[i][j] = currentLetter;
    }
}
