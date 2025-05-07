package org.leetcode.examples.bubleSort;

public class PatientWaitList {


    public static void orderByPriorityAndTime(String[] list, int items) {
        boolean swapped;
        for (int i = 0; i < items - 1; i++) {
            swapped = false;
            for (int j = 0; j < items - i - 1; j++) {
                if (Integer.parseInt(list[j].split(":")[1]) < Integer.parseInt(list[j + 1].split(":")[1])) {
                    String temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                    swapped = true;
                } else if (Integer.parseInt(list[j].split(":")[1]) == Integer.parseInt(list[j + 1].split(":")[1])) {
                    if (Integer.parseInt(list[j].split(":")[2]) < Integer.parseInt(list[j + 1].split(":")[2])) {
                        String temp = list[j];
                        list[j] = list[j + 1];
                        list[j + 1] = temp;
                        swapped = true;
                    }
                }
            }
            if (!swapped) {
                break;
            }
        }
    }

    // Function to print an array
    static void printArray(String arr[], int size){
        int i;
        for (i = 0; i < size; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }


    public static void main(String[] args) {
        String[] list = {"P4:5:110", "P2:4:115", "P3:8:224", "P1:9:789", "P7:5:115", "P9:4:147"};
        int items = list.length;
        orderByPriorityAndTime(list, items);
        printArray(list, items);
    }
}
