package org.leetcode.examples.greedyAlgorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

//Problem 1 : Activity Selection Problem
//This problem contains a set of activities or tasks that need to be completed.
//Each one has a start and finish time. The algorithm finds the maximum number of activities
//that can be done in a given time without them overlapping.

public class ActivitySelectionProblem {

    public static void main(String[] args) {
        int[] start_time = {2, 6, 4, 10, 13, 7};
        int[] finish_time = {5, 10, 8, 12, 14, 15};
        String[] activity = {"Homework", "Presentation", "Term paper", "Volleyball practice", "Biology lecture", "Hangout"};

        ArrayList<String> selected_activity = new ArrayList<>();
        int n = finish_time.length;

        // Creating an array of activities
        Activity[] activities = new Activity[n];
        for (int i = 0; i < n; i++) {
            activities[i] = new Activity(start_time[i], finish_time[i], activity[i]);
        }

        // Sorting the activities based on finish time
        Arrays.sort(activities, Comparator.comparingInt(a -> a.finishTime));

        // By default, the first activity is inserted in the list of activities to be selected.
        selected_activity.add(activities[0].name);
        int lastFinishTime = activities[0].finishTime;

        for (int i = 1; i < n; i++) {
            if (activities[i].startTime >= lastFinishTime) {
                selected_activity.add(activities[i].name);
                lastFinishTime = activities[i].finishTime;
            }
        }

        System.out.println("The student can work on the following activities: " + selected_activity);
    }

    static class Activity {
        int startTime;
        int finishTime;
        String name;

        Activity(int startTime, int finishTime, String name) {
            this.startTime = startTime;
            this.finishTime = finishTime;
            this.name = name;
        }
    }
}
