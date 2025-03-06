package org.leetcode.examples.binarysearch;

//Nearly every one have used the Multiplication Table. But could you find out the k-th smallest number quickly
//from the multiplication table? Given the height m and the length n of a m * n Multiplication Table,
//and a positive integer k, you need to return the k-th smallest number in this table.
//
//        Example :
//
//Input: m = 3, n = 3, k = 5
//Output: 3
//Explanation:
//The Multiplication Table:
//        1	2	3
//        2	4	6
//        3	6	9
//
//The 5-th smallest number is 3 (1, 2, 2, 3, 3).
//
//For Kth-Smallest problems like this, what comes to our mind first is Heap. Usually we can maintain
//a Min-Heap and just pop the top of the Heap for k times. However, that doesn't work out in this problem.
//We don't have every single number in the entire Multiplication Table, instead, we only have the height
//and the length of the table. If we are to apply Heap method, we need to explicitly calculate
//these m * n values and save them to a heap. The time complexity and space complexity of
//this process are both O(mn), which is quite inefficient. This is when binary search comes in.
//Remember we say that designing condition function is the most difficult part? In order to find
//the k-th smallest value in the table, we can design an enough function, given an input num, determine whether
//there're at least k values less than or equal to num. The minimal num satisfying
//enough function is the answer we're looking for. Recall that the key to binary search is discovering monotonicity.
//In this problem, if num satisfies enough, then of course any value larger than num can satisfy. This monotonicity
//is the fundament of our binary search algorithm.
//
//Let's consider search space. Obviously the lower bound should be 1, and the upper bound should be the largest
//value in the Multiplication Table, which is m * n, then we have search space [1, m * n]. The overwhelming advantage
//of binary search solution to heap solution is that it doesn't need to explicitly calculate all numbers in that table,
//all it needs is just picking up one value out of the search space and apply enough function to this value, to determine
//should we keep the left half or the right half of the search space. In this way, binary search solution only requires
//constant space complexity, much better than heap solution.

public class KthSmallestNumberInMultiplicationTable {

    public int findKthNumber(int m, int n, int k) {
        int left = 1, right = n * m;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (enough(mid, m, n, k)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean enough(int num, int m, int n, int k) {
        int count = 0;
        for (int val = 1; val <= m; val++) {
            int add = Math.min(num / val, n);
            if (add == 0) {
                break; // early exit
            }
            count += add;
        }
        return count >= k;
    }
}
