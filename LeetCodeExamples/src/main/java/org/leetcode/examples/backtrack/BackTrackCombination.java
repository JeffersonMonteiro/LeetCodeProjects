package org.leetcode.examples.backtrack;

import java.util.ArrayList;
import java.util.List;

public class BackTrackCombination {
    public static void C_n_k(int[] a, int n, int k, int start, int depth, List<Integer> curr, List<List<Integer>> ans) {
        /*
         Implement combination of k items out of n items
         start: the start of candidate
         depth: start from 0, and represent the depth of the search
         curr: the current partial solution
         ans: collect all the valid solutions
         */
        if (depth == k) { // end condition
            ans.add(new ArrayList<>(curr));
            return;
        }

        for (int i = start; i < n; i++) {
            // generate the next solution from curr
            curr.add(a[i]);
            // move to the next solution
            C_n_k(a, n, k, i + 1, depth + 1, curr, ans);

            // backtrack to previous partial state
            curr.remove(curr.size() - 1);
        }
    }
}
