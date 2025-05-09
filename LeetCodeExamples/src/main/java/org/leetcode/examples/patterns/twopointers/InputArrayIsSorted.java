package org.leetcode.examples.patterns.twopointers;

//Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order,
// find two numbers such that they add up to a specific target number. Let these two numbers be numbers[index1]
// and numbers[index2] where 1 <= index1 < index2 <= numbers.length.
//Return the indices of the two numbers, index1 and index2, added by one as an integer array [index1, index2] of length 2.
//
//The tests are generated such that there is exactly one solution. You may not use the same element twice.
//
//Your solution must use only constant extra space.
//
//Example 1:
//
//Input: numbers = [2,7,11,15], target = 9
//Output: [1,2]
//Explanation: The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2. We return [1, 2].

public class InputArrayIsSorted {

    public static void main(String[] args) {
        int[] input = {-10,-8,-2,1,2,5,6};
        int[] result = twoSum(input, 0);

        for (Integer item : result) {
            System.out.println(item);
        }
    }

    public static int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        int [] result = new int [2];

        while(left < right){
            int sum = numbers[left] + numbers[right];

            // Move the pointer pointing to the shorter height
            if (sum > target) {
                right--; // Move right pointer backward
            } else if (sum < target){
                left++; // Move left pointer forward
            }else{
                result[0] = left + 1;
                result[1] = right + 1;
                break;
            }
        }
        return result;
    }

    //Brute Force
    public static int[] twoSumBruteForce(int[] numbers, int target) {
        int left = 0; // Pointer for placing non-zero elements
        int[] result = new int[2];
        // Iterate with right pointer
        loop:
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == target) {
                    if (numbers[i] == numbers[j] && (numbers[i] > 0 && numbers[j] > 0)) {
                        result[0] = i + 1;
                        result[1] = j + 2;
                    } else if (numbers[i] == numbers[j] && (numbers[i] < 0 && numbers[j] < 0)) {
                        result[0] = i + 1;
                        result[1] = j + 1;
                    } else {
                        result[0] = i + 1;
                        result[1] = j + 1;
                    }
                    break loop;
                }
            }
        }
        return result;
    }
}

