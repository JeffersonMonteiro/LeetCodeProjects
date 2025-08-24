package org.leetcode.examples.patterns.arrays;

import java.util.Arrays;
import java.util.List;

public class MoveZeros {

    public void moveZeroes(int[] nums) {

        List<Integer> listNumsWithoutZero = new java.util.ArrayList<>(Arrays.stream(nums).filter(l -> l != 0).boxed().toList());
        List<Integer> listNumsWitZero = Arrays.stream(nums).filter(l -> l == 0).boxed().sorted().toList();

        listNumsWithoutZero.addAll(listNumsWitZero);

        for(int i=0; i<listNumsWithoutZero.size(); i++){
            nums[i] = listNumsWithoutZero.get(i);
        }


//        StringBuilder result = new StringBuilder();
//        result.append("[");
//        for(Integer item: listNumsWithoutZero){
//            result.append(item).append(",");
//
//        }
//        result.deleteCharAt(result.length()-1);
//         result.append("]");
//        nums = listNumsWithoutZero.stream().mapToInt(Integer::intValue).toArray();
        System.out.println(Arrays.toString(nums));

    }

    public static void main(String[] args) {
        MoveZeros solver = new MoveZeros();
        int[] nums = {0, 1, 0, 3, 12};
        solver.moveZeroes(nums);
        //System.out.println("Array after moving zeros: " + Arrays.toString(solver.moveZeroes(nums)));
    }
}
