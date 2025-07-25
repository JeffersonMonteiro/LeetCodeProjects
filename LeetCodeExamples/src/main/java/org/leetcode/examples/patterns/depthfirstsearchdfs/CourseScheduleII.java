package org.leetcode.examples.patterns.depthfirstsearchdfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseScheduleII {
    //### Kahn's Algorithm (BFS-based Topological Sort)
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        int[] inDegree = new int[numCourses];

        // Build the graph and calculate in-degrees
        for (int[] prereq : prerequisites) {
            int course = prereq[0];
            int pre = prereq[1];
            graph.get(pre).add(course);
            inDegree[course]++;
        }

        // Add all courses with in-degree 0 to the queue
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        // Perform BFS
        int[] order = new int[numCourses];
        int index = 0;
        while (!queue.isEmpty()) {
            int current = queue.poll();
            order[index++] = current;

            // Reduce in-degree of neighbors and add to the queue if in-degree becomes 0
            for (int neighbor : graph.get(current)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        // If we did not process all courses, return an empty array (cycle detected)
        if (index != numCourses) {
            return new int[0];
        }

        return order;
    }

    //### DFS-Based Topological Sorting
    public int[] findOrderDFS(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        // Build the graph
        for (int[] prereq : prerequisites) {
            int course = prereq[0];
            int pre = prereq[1];
            graph.get(pre).add(course);
        }

        // Array to track visit status: 0 = unvisited, 1 = visiting, 2 = visited
        int[] visited = new int[numCourses];
        List<Integer> order = new ArrayList<>();

        // Perform DFS for each course
        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == 0) {
                if (!dfs(i, graph, visited, order)) {
                    return new int[0]; // Cycle detected
                }
            }
        }

        // Convert list to array and reverse it (since it's built in reverse order)
        Collections.reverse(order);
        return order.stream().mapToInt(Integer::intValue).toArray();
    }

    private boolean dfs(int node, List<List<Integer>> graph, int[] visited, List<Integer> order) {
        if (visited[node] == 1) return false; // Cycle detected
        if (visited[node] == 2) return true;  // Already visited

        visited[node] = 1; // Mark node as visiting

        // Visit all neighbors
        for (int neighbor : graph.get(node)) {
            if (!dfs(neighbor, graph, visited, order)) {
                return false; // Cycle detected in recursion
            }
        }

        visited[node] = 2; // Mark node as fully visited
        order.add(node); // Add to result in post-order

        return true;
    }



    public static void main(String[] args) {
        CourseScheduleII solution = new CourseScheduleII();

        int numCourses = 4;
        int[][] prerequisites = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};

        int[] result = solution.findOrder(numCourses, prerequisites);
        System.out.println(Arrays.toString(result)); // Example output: [0, 1, 2, 3]

        int[] resultDFS = solution.findOrderDFS(numCourses, prerequisites);
        System.out.println(Arrays.toString(resultDFS)); // Example output: [0, 2, 1, 3]

    }

}
