package org.leetcode.examples.binarysearch;




public class FirstBadVersion {

    //Basic Binary Search
    public static int binarySearch(int[] array) {
        int left = Integer.MIN_VALUE; // set min value based on your search space
        int right = Integer.MAX_VALUE; // set max value based on your search space

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (condition(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static boolean condition(int value) {
        // Implement condition logic here
        return false; // placeholder
    }

//You are a product manager and currently leading a team to develop a new product.
//Since each version is developed based on the previous version, all the versions after
//a bad version are also bad. Suppose you have n versions [1, 2, ..., n]
//and you want to find out the first bad one, which causes all the following ones to be bad.
//You are given an API bool isBadVersion(version) which will return whether version is bad.


//Given n = 5, and version = 4 is the first bad version.
//
//        call isBadVersion(3) -> false
//call isBadVersion(5) -> true
//call isBadVersion(4) -> true
//
//Then 4 is the first bad version.


//First, we initialize left = 1 and right = n to include all possible values.
//Then we notice that we don't even need to design the condition function.
//It's already given by the isBadVersion API. Finding the first bad version is equivalent
//to finding the minimal k satisfying isBadVersion(k) is True. Our template can fit in very nicely:

    public int firstBadVersion(int n) {
        int left = 1, right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean isBadVersion(int mid) {
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new FirstBadVersion().firstBadVersion(5));
    }
}
