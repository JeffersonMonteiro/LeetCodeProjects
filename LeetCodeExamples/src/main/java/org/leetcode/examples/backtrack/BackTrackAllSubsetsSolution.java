package org.leetcode.examples.backtrack;

import java.util.ArrayList;
import java.util.List;

public class BackTrackAllSubsetsSolution {

    //Given a set of distinct integers, nums, return all possible subsets (the power set).
    public List<List<Integer>> subsets(int[] inputNums) {
        List<List<Integer>> rslt = new ArrayList<>();

        dfs(new ArrayList<>(), 0, inputNums, rslt);
        return rslt;
    }

    private void dfs(List<Integer> temp, int index, int[] inputNums, List<List<Integer>> resultSubSetList) {
        resultSubSetList.add(new ArrayList<>(temp)); // pass a shallow copy of temp

        for (int i = index; i < inputNums.length; i++) {
            temp.add(inputNums[i]);
            // backtrack
            dfs(temp, i + 1, inputNums, resultSubSetList);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6};

        BackTrackAllSubsetsSolution backTrackAllSubsetsSolution = new BackTrackAllSubsetsSolution();
        //List<Integer> list = backTrackAllSubsetsSolution.subsets(nums).stream().flatMap(Collection::stream).collect(Collectors.toList());
        //List<Integer> list = backTrackAllSubsetsSolution.subsets(nums).stream().flatMap(Collection::stream).toList();

        List<List<Integer>> list = backTrackAllSubsetsSolution.subsets(nums);

        for (List<Integer> item : list) {
            System.out.println(item);
        }

    }
}
