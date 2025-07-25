package org.leetcode.examples.binarysearch;

public class FindMinimumInRotatedSortedArray {
    public int findMin(int[] array) {
        int left = 0, right = array.length - 1;

        while (left < right) { // Continue until the search space narrows to one element
            int mid = left + (right - left) / 2; // Prevent integer overflow

            // Case 1: If the middle element is less than the rightmost element,
            // the minimum lies in the left half (including mid)
            if (array[mid] < array[right]) {
                right = mid;
            }
            // Case 2: Otherwise, the minimum lies in the right half (excluding mid)
            else {
                left = mid + 1;
            }
        }

        // At the end of the loop, 'left' points to the smallest element
        return array[left];
    }

    public static void main(String[] args) {
        FindMinimumInRotatedSortedArray solver = new FindMinimumInRotatedSortedArray();

        int[] arr1 = {4, 5, 6, 7, 0, 1, 2};
        System.out.println("Minimum: " + solver.findMin(arr1)); // Output: 0

        int[] arr2 = {3, 4, 5, 1, 2};
        System.out.println("Minimum: " + solver.findMin(arr2)); // Output: 1

        int[] arr3 = {11, 13, 15, 17};
        System.out.println("Minimum: " + solver.findMin(arr3)); // Output: 11
    }

}
