package org.leetcode.examples.patterns.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TripletsSum {

    public static void main(String[] args) {
        int[] input = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result = threeSum(input);

        for (List<Integer> item : result) {
            System.out.println(item);
        }
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        for (int num = 0; num < nums.length; num++) {
            if (num > 0 && nums[num] == nums[num - 1]) {
                continue;
            }

            int left = num + 1, right = nums.length - 1;
            while (left < right) {
                int sum = nums[num] + nums[left] + nums[right];
                if (sum > 0) {
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    res.add(Arrays.asList(nums[num], nums[left], nums[right]));
                    left++;
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                }
            }
        }
        return res;
    }

//    public static List<List<Integer>> threeSum(int[] nums) {
//        int left = 0;
//        int leftPlus = 1;
//        int right = nums.length -1;
//        Collections.sort(Arrays.asList(Arrays.stream(nums).boxed().toArray(Integer[]::new)));
//        List<List<Integer>> resultList = new ArrayList<>();
//
//        while(leftPlus != nums.length -1){
//            int sum = nums[left]+ nums[leftPlus] + nums[right];
//
//            // Move the pointer pointing to the shorter height
//            if (sum != 0) {
//                if(right == left || right == leftPlus){
//                    right--; // Move right pointer backward
//                }else{
//                    right--; // Move right pointer backward
//                    left++; // Move left pointer forward
//                    leftPlus++;
//                }
//            } else{
//                if(left != leftPlus && leftPlus != right && right != left){
//                    int [] triplets = {nums[left], nums[leftPlus], nums[right]};
//                    resultList.add(Arrays.asList(Arrays.stream(triplets).boxed().toArray(Integer[]::new)));
//                    if(right == left || right == leftPlus){
//                        right--; // Move right pointer backward
//                    }else{
//                        right--; // Move right pointer backward
//                        left++; // Move left pointer forward
//                        leftPlus++;
//                    }
//                }else{
//                    break;
//                }
//            }
//        }
//        return resultList;
//    }
}
