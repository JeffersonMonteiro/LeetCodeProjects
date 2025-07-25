package org.leetcode.examples.patterns.breadthfirstsearchbfs;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // Step 1: Add all words from wordList into a set for fast lookup
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) return 0; // If endWord is not in the wordList, return 0

        // Step 2: Create a queue for BFS
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);

        // Step 3: Maintain a visited set to avoid revisiting words
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        // Step 4: Begin BFS with level count starting at 1
        int level = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String currentWord = queue.poll();

                // Try all possible single-character transformations
                char[] wordChars = currentWord.toCharArray();
                for (int j = 0; j < wordChars.length; j++) {
                    char originalChar = wordChars[j];

                    // Replace character with 'a' to 'z'
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == originalChar) continue; // Skip original character
                        wordChars[j] = c;
                        String transformedWord = new String(wordChars);

                        // Check if this word is the endWord
                        if (transformedWord.equals(endWord)) {
                            return level + 1; // We found the shortest path
                        }

                        // If the transformed word exists in the set and hasn't been visited, enqueue it
                        if (wordSet.contains(transformedWord) && !visited.contains(transformedWord)) {
                            visited.add(transformedWord);
                            queue.add(transformedWord);
                        }
                    }

                    // Restore the original character
                    wordChars[j] = originalChar;
                }
            }

            // Increment the level
            level++;
        }

        // If BFS completes and endWord is not found, return 0
        return 0;
    }

    public static void main(String[] args) {
        WordLadder solver = new WordLadder();

        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");

        int result = solver.ladderLength(beginWord, endWord, wordList);
        System.out.println("Shortest transformation length: " + result); // Output: 5
    }

}
