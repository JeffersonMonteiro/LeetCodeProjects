package org.leetcode.examples.backtrack;

import java.util.ArrayList;
import java.util.List;

public class BackTrackAllPathSolutions {
    public static void allPaths(List<List<Integer>> g, int s, List<Integer> path, List<List<Integer>> ans) {
        ans.add(new ArrayList<>(path));
        for (int v : g.get(s)) {
            path.add(v);
            System.out.println(path);
            allPaths(g, v, path, ans);
            path.remove(path.size() - 1);
            System.out.println(path);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> al = new ArrayList<>();
        al.add(List.of(1));
        al.add(List.of(2));
        al.add(List.of(4));
        al.add(new ArrayList<>());
        al.add(List.of(3, 5));
        al.add(List.of(6));
        al.add(new ArrayList<>());

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        path.add(0);
        allPaths(al, 0, path, ans);
    }
}
