package org.leetcode.examples.binarysearch;


//Implement int sqrt(int x). Compute and return the square root of x,
//where x is guaranteed to be a non-negative integer. Since the return type is an integer,
//the decimal digits are truncated and only the integer part of the result is returned.
//
//
//Example:
//
//
//Input: 4
//Output: 2
//Input: 8
//Output: 2


//Easy one. First we need to search for minimal k satisfying condition k^2 > x,
//then k - 1 is the answer to the question. We can easily come up with the solution.
//Notice that I set right = x + 1 instead of right = x to deal with special input cases like x = 0 and x = 1.

public class Sqrt {

    public int mySqrt(int x) {
        int left = 0, right = x + 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (mid * mid > x) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left - 1; // `left` is the minimum k value, `k - 1` is the answer
    }

    public static void main(String[] args) {
        System.out.println( new Sqrt().mySqrt(144));
    }
}
