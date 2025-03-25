package org.leetcode.examples.greedyAlgorithms;

import java.util.Arrays;
import java.util.Comparator;

//Problem 2: Fractional Knapsack Problem
//A knapsack has a maximum weight, and it can only
//accommodate a certain set of items. These items have a weight and a value.
//The aim is to fill the knapsack with the items that have the highest total values
//and do not exceed the maximum weight capacity.

public class FractionalKnapsackProblem {
    public static void main(String[] args) {
        int[] weight = {10, 6, 2};
        int[] profit = {40, 30, 6};
        int maxWeight = 17;
        int selectedWt = 0;
        double maxProfit = 0;

        double[] ratio = new double[profit.length];
        for (int i = 0; i < profit.length; i++) {
            ratio[i] = (double) profit[i] / weight[i];
        }

        Integer[] indices = new Integer[profit.length];
        for (int i = 0; i < profit.length; i++) {
            indices[i] = i;
        }

        Arrays.sort(indices, Comparator.comparingDouble(i -> -ratio[i]));

        for (int i : indices) {
            if (selectedWt + weight[i] <= maxWeight) {
                selectedWt += weight[i];
                maxProfit += profit[i];
            } else {
                double fracWt = (double) (maxWeight - selectedWt) / weight[i];
                double fracValue = profit[i] * fracWt;
                maxProfit += fracValue;
                selectedWt += (maxWeight - selectedWt);
                break;
            }
        }

        System.out.printf("The maximum profit that can be made from each item is: %.2f euros%n", maxProfit);
    }
}
