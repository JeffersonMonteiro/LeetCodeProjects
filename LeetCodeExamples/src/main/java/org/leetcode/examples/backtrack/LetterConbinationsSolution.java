package org.leetcode.examples.backtrack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LetterConbinationsSolution {
    public List<String> letterCombinations(String digits) {
        HashMap<Character, String> numberToLettersMapping = new HashMap<>();
        numberToLettersMapping.put('2', "abc");
        numberToLettersMapping.put('3', "def");
        numberToLettersMapping.put('4', "ghi");
        numberToLettersMapping.put('5', "jkl");
        numberToLettersMapping.put('6', "mno");
        numberToLettersMapping.put('7', "pqrs");
        numberToLettersMapping.put('8', "tuv");
        numberToLettersMapping.put('9', "wxyz");

        List<Character> inputDigits = String.copyValueOf(digits.toCharArray())
                .chars()
                .mapToObj(i -> (char) i)
                .toList();

        return combine(new ArrayList<>(), new ArrayList<>(inputDigits), numberToLettersMapping);
    }

    //Given a digit string, return all possible letter combinations that the number could represent.
    private List<String> combine(List<String> rst, List<Character> remainDigits, HashMap<Character, String> mapping) {
        if (remainDigits.isEmpty()) {
            return rst;
        }
        if (rst.isEmpty()) {
            rst.add("");
        }
        List<String> nxtRst = new ArrayList<>();
        char digit = remainDigits.remove(0);
        for (String rstItem : rst) {
            for (char mappingItem : mapping.get(digit).toCharArray()) {
                nxtRst.add(rstItem + mappingItem);
            }
        }
        return combine(nxtRst, remainDigits, mapping);
    }

    public static void main(String[] args) {
        LetterConbinationsSolution letterConbinationsSolution = new LetterConbinationsSolution();
        letterConbinationsSolution.letterCombinations("24").forEach(System.out::println);
    }
}
