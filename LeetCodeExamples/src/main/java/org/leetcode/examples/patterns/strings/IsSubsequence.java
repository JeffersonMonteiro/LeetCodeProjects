package org.leetcode.examples.patterns.strings;

//The problem **"Is Subsequence"** involves determining
// if one string (`s`) is a subsequence of another string (`t`).
// A subsequence of a string is a sequence that can be derived from
// the string by deleting some or no characters without changing
// the order of the remaining characters.
//        Here’s a simplified and efficient approach:


public class IsSubsequence {

    public boolean isSubsequence(String s, String t) {
        // Pointers for both strings
        int pointerS = 0, pointerT = 0;

        // Traverse string t while comparing with s
        while (pointerS < s.length() && pointerT < t.length()) {
            // If characters match, move the pointer for s
            if (s.charAt(pointerS) == t.charAt(pointerT)) {
                pointerS++;
            }
            // Always move the pointer for t
            pointerT++;
        }

        // If pointerS reaches the end of s, it means all characters of s were found in t in order
        return pointerS == s.length();
    }

    public static void main(String[] args) {
        IsSubsequence solver = new IsSubsequence();
        String s = "abc", t = "ahbgdc";
        System.out.println("Is subsequence: " + solver.isSubsequence(s, t));
    }

}
