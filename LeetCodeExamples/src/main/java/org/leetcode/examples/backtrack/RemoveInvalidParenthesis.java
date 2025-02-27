package org.leetcode.examples.backtrack;

import java.util.ArrayList;
import java.util.List;

public class RemoveInvalidParenthesis {

    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();

        int[] count = getCount(s);
        int leftCount = count[0];
        int rightCount = count[1];

        dfs(s, 0, leftCount, rightCount, result);
        return result;
    }

    private boolean isValid(String s) {
        int leftParenCount = 0;
        for (char character : s.toCharArray()) {
            if (character == '(') {
                leftParenCount += 1;
            } else if (character == ')') {
                if (leftParenCount == 0) {
                    return false;
                }
                leftParenCount -= 1;
            }
        }
        return leftParenCount == 0;
    }

    private int[] getCount(String s) {
        int leftCount = 0;
        int rightCount = 0; // count extra right parentheses
        for (char character : s.toCharArray()) {
            leftCount += (character == '(') ? 1 : 0;
            if (character == ')') {
                if (leftCount == 0) {
                    rightCount += 1;
                } else {
                    leftCount -= 1;
                }
            }
        }
        return new int[]{leftCount, rightCount};
    }

    private void dfs(String s, int index, int leftCount, int rightCount, List<String> result) {
        if (leftCount == 0 && rightCount == 0) {
            if (isValid(s)) {
                result.add(s);
            }
            return;
        }
        // delete extra left or right, every time we only delete one
        for (int i = index; i < s.length(); i++) {
            char character = s.charAt(i);
            if (i > index && character == s.charAt(i - 1)) { // to avoid duplication
                continue;
            }
            if (character == ')') {
                String newString = s.substring(0, i) + s.substring(i + 1);
                dfs(newString, i, leftCount, rightCount - 1, result);
            }
            if (character == '(') {
                String newString = s.substring(0, i) + s.substring(i + 1);
                dfs(newString, i, leftCount - 1, rightCount, result);
            }
        }
    }
}
