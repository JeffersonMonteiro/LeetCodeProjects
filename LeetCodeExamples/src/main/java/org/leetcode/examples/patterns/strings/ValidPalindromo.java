package org.leetcode.examples.patterns.strings;

import java.util.List;

public class ValidPalindromo {


    public boolean isPalindrome(String s) {
        // Remove all non-alphanumeric characters (including spaces)
        String cleanedS = s.replaceAll("[^a-zA-Z0-9]", "");


        List<Character> cleanedSCharacters = cleanedS.toLowerCase().chars().mapToObj(c -> (char)c).toList();
        StringBuilder strReversed = new StringBuilder();
        strReversed.append(cleanedS);
        List<Character> cleanedSCharactersReverse =  strReversed.reverse().toString().toLowerCase().chars().mapToObj(c -> (char)c).toList();

        for (int i = 0; i < cleanedSCharacters.size(); i++) {
            if (cleanedSCharacters.get(i) != cleanedSCharactersReverse.get(i)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        ValidPalindromo solver = new ValidPalindromo();
        String s = "A man, a plan, a canal: Panama";
        System.out.println("Is palindromo: " + solver.isPalindrome(s));
    }

}
