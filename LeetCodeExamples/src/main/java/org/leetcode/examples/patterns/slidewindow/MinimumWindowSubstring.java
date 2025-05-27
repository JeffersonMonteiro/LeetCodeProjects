package org.leetcode.examples.patterns.slidewindow;

import java.util.HashMap;

public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }

        // Step 1: Count frequencies of characters in t
        HashMap<Character, Integer> dictT = new HashMap<>();
        for (char c : t.toCharArray()) {
            dictT.put(c, dictT.getOrDefault(c, 0) + 1);
        }

        // Total unique characters in t that must match
        int required = dictT.size();

        // Sliding window variables
        int l = 0, r = 0;
        int formed = 0; // Keeps track of how many characters' frequencies are met
        HashMap<Character, Integer> windowCounts = new HashMap<>();

        // Variables for the result
        int[] ans = {-1, 0, 0}; // [window length, left, right]

        while (r < s.length()) {
            // Add the character from the right pointer
            char c = s.charAt(r);
            windowCounts.put(c, windowCounts.getOrDefault(c, 0) + 1);

            // Check if the current character's frequency matches the required frequency
            if (dictT.containsKey(c) && windowCounts.get(c).intValue() == dictT.get(c).intValue()) {
                formed++;
            }

            // Try to shrink the window
            while (l <= r && formed == required) {
                c = s.charAt(l); // Character at the left pointer

                // Save the smallest window
                if (ans[0] == -1 || (r - l + 1) < ans[0]) {
                    ans[0] = r - l + 1;
                    ans[1] = l;
                    ans[2] = r;
                }

                // Remove the character from the window
                windowCounts.put(c, windowCounts.get(c) - 1);
                if (dictT.containsKey(c) && windowCounts.get(c).intValue() < dictT.get(c).intValue()) {
                    formed--;
                }

                // Move the left pointer
                l++;
            }

            // Expand the window by moving the right pointer
            r++;
        }

        // Return the result
        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
    }

    public static void main(String[] args) {
        MinimumWindowSubstring solver = new MinimumWindowSubstring();
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(solver.minWindow(s, t)); // Output: "BANC"
    }
}

