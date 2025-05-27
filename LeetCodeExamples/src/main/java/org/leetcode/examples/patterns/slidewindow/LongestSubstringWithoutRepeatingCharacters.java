package org.leetcode.examples.patterns.slidewindow;

//Here’s the idea:
//
//Use two pointers, left and right, to represent the boundaries of the current substring.
// Use a HashSet to store the characters in the current substring for quick lookup of duplicates.
//
//Start with both pointers at the beginning of the string.
//
//Expand the window by moving the right pointer one step at a time, and adding characters to the set.
//
//If a duplicate character is encountered (already in the Set),
// shrink the window by moving the left pointer until the duplicate is removed from the substring.
//
//By shrinking the window with the left pointer, we ensure that the substring remains valid.
//
//After each adjustment, calculate the length of the current substring (right - left + 1)
// and update the maximum length if needed.
//
//When the right pointer reaches the end, return the maximum length of the substring.


import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }

    public static int lengthOfLongestSubstring(String s){
        Set<Character> set = new HashSet<>(); // To track the characters in the current SubString
        int maxLength = 0; //Store the maximum length of substring found
        int left = 0; //left pointer of the window

        //Right pointer expands the window
        for (int right = 0; right < s.length(); right++){
            char currentChar = s.charAt(right);

            //if duplicate is found, shrink the window from the left
            while (set.contains(currentChar)){
                set.remove(s.charAt(left));
                left++;

            }

            //Add the current character to the set
            set.add(currentChar);

            maxLength = Math.max(maxLength, right - left +1);

        }

        return maxLength;



    }

}
