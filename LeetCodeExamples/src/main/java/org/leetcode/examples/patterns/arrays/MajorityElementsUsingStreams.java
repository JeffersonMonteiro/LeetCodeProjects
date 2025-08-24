package org.leetcode.examples.patterns.arrays;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

//### Explanation
//1. **`boxed()`**:
//        - Converts the `int` array to a Stream of . `Integer`
//        - This is necessary for using `Collectors.groupingBy` since primitive types cannot be used as keys in maps.
//
//        2. **`collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))`**:
//        - `groupingBy(Function.identity())`: Groups the numbers by their values.
//        - `Collectors.counting()`: Counts the occurrences of each number in the group.
//
//3. **`entrySet().stream()`**:
//        - Converts the resulting map of grouped elements (key: number, value: count) to a stream of entries.
//
//        4. **`max(Map.Entry.comparingByValue())`**:
//        - Finds the entry (key-value pair) with the maximum value (frequency).
//
//        5. **`.get().getKey()`**:
//        - Gets the key (the number) of the map entry that has the maximum frequency.



public class MajorityElementsUsingStreams {

    public int majorityElement(int[] nums) {
        // Find the majority element using Streams
        return Arrays.stream(nums)
                .boxed() // Convert int[] to Stream<Integer>
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting())) // Count occurrences
                .entrySet() // Get entrySet to iterate through key-value pairs
                .stream() // Create a new Stream from the entries
                .max(Map.Entry.comparingByValue()) // Find the entry with the maximum value (frequency)
                .get() // Get the entry (Optional is guaranteed to be present)
                .getKey(); // Return the key (majority element)
    }

    public static void main(String[] args) {
        MajorityElement obj = new MajorityElement();
        int[] numbers = {2, 2, 1, 1, 1, 2, 2};

        // Find and print the majority element
        System.out.println("Majority Element: " + obj.majorityElement(numbers));
    }

}
