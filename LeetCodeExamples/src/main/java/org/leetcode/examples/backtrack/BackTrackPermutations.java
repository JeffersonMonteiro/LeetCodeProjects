package org.leetcode.examples.backtrack;

import java.util.ArrayList;
import java.util.List;

public class BackTrackPermutations {

    public List<List<Integer>> permute(int[] nums) {
        // here we need a global wise list, each time we just append to the result
        List<List<Integer>> resultList = new ArrayList<>();

        dfs(new ArrayList<>(), nums, resultList); // first is the current result
        return resultList;
    }

    private void dfs(List<Integer> tempList, int[] elements, List<List<Integer>> resultList) {
        // gather resultList
        if (elements.length == 0) {
            resultList.add(new ArrayList<>(tempList)); // still remember to use temp[:]
        }
        for (int e : elements) {
            tempList.add(e);
            // backtrack
            List<Integer> nextElements = new ArrayList<>();
            for (int element : elements) {
                if (element != e) {
                    nextElements.add(element);
                }
            }
            dfs(tempList, nextElements.stream().mapToInt(Integer::intValue).toArray(), resultList);
            tempList.remove(tempList.size() - 1);
        }
    }


    public static void main(String[] args) {
        int[] nums = {1, 2, 3};

        BackTrackPermutations backTrackPermutations = new BackTrackPermutations();
        //List<Integer> list = backTrackAllSubsetsSolution.subsets(nums).stream().flatMap(Collection::stream).collect(Collectors.toList());
        //List<Integer> list = backTrackAllSubsetsSolution.subsets(nums).stream().flatMap(Collection::stream).toList();

        List<List<Integer>> list = backTrackPermutations.permute(nums);

        for (List<Integer> item : list) {
            System.out.println(item);
        }

    }
}



