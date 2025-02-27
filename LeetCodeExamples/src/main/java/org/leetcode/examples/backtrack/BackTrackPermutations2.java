package org.leetcode.examples.backtrack;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class BackTrackPermutations2 {

    //Given a collection of numbers that might contain duplicates, return all possible unique permutations.
    public List<List<Integer>> permuteUnique(int[] nums) {
        // here we need a global wise list, each time we just append to the result
        List<List<Integer>> result = new ArrayList<>();

        dfs(new ArrayList<>(), nums, result);
        return result;
    }

    private void dfs(List<Integer> temp, int[] elements, List<List<Integer>> result) {
        // gather result
        if (elements.length == 0) {
            result.add(new ArrayList<>(temp)); // still remember to use temp[:]
        }

        HashSet<Integer> uniqueElements = new HashSet<>();
        for (int e : elements) { // this is the only difference
            if (!uniqueElements.contains(e)) {
                uniqueElements.add(e);
                temp.add(e);

                // backtrack
                List<Integer> nextElements = new ArrayList<>();
                for (int elem : elements) {
                    if (elem != e) {
                        nextElements.add(elem);
                    }
                }

                dfs(temp, nextElements.stream().mapToInt(i -> i).toArray(), result);
                temp.remove(temp.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2};

        BackTrackPermutations2 backTrackPermutations2 = new BackTrackPermutations2();
        //List<Integer> list = backTrackAllSubsetsSolution.subsets(nums).stream().flatMap(Collection::stream).collect(Collectors.toList());
        //List<Integer> list = backTrackAllSubsetsSolution.subsets(nums).stream().flatMap(Collection::stream).toList();

        List<List<Integer>> list = backTrackPermutations2.permuteUnique(nums);

        for (List<Integer> item : list) {
            System.out.println(item);
        }

    }
}
