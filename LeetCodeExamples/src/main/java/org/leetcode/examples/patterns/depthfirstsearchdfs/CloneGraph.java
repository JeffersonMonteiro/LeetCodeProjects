package org.leetcode.examples.patterns.depthfirstsearchdfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

class Node {
    public int val;
    public List<Node> neighbors;

    public Node(int val) {
        this.val = val;
        neighbors = new ArrayList<>();
    }
}


public class CloneGraph {

    private Map<Node, Node> map = new HashMap<>(); // Map to store original -> cloned node mapping

    //#### DFS Implementation:
    public Node cloneGraph(Node node) {
        if (node == null) return null;

        // If the node is already cloned, return it
        if (map.containsKey(node)) {
            return map.get(node);
        }

        // Clone the node
        Node clone = new Node(node.val);
        map.put(node, clone);

        // Recursively clone neighbors
        for (Node neighbor : node.neighbors) {
            clone.neighbors.add(cloneGraph(neighbor));
        }

        return clone;
    }

    public Node cloneGraphBFSImplementation
            (Node node) {
        if (node == null) return null;

        // Map to store original -> cloned node mapping
        Map<Node, Node> map = new HashMap<>();

        // Clone the root node and add it to the map
        Node clone = new Node(node.val);
        map.put(node, clone);

        // Queue for BFS
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            // Process neighbors
            for (Node neighbor : current.neighbors) {
                if (!map.containsKey(neighbor)) {
                    // Clone the neighbor if not already cloned
                    map.put(neighbor, new Node(neighbor.val));
                    queue.add(neighbor); // Add neighbor to the queue for further processing
                }
                // Connect the cloned node with its cloned neighbor
                map.get(current).neighbors.add(map.get(neighbor));
            }
        }

        return map.get(node);
    }


    public static void main(String[] args) {
        // Create a sample graph for testing
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        node1.neighbors.add(node2);
        node1.neighbors.add(node4);
        node2.neighbors.add(node1);
        node2.neighbors.add(node3);
        node3.neighbors.add(node2);
        node3.neighbors.add(node4);
        node4.neighbors.add(node1);
        node4.neighbors.add(node3);

        CloneGraph solution = new CloneGraph();
        Node clone = solution.cloneGraph(node1);

        // Output values for the original and cloned graph
        System.out.println("Cloned Node Value: " + clone.val); // Output: 1
        System.out.println("Cloned Neighbors: " + clone.neighbors.size()); // Output: 2

        CloneGraph solutionBSF = new CloneGraph();
        Node cloneBSF = solutionBSF.cloneGraphBFSImplementation(node1);

        // Output values for the original and cloned graph
        System.out.println("Cloned Node Value: " + cloneBSF.val); // Output: 1
        System.out.println("Cloned Neighbors: " + cloneBSF.neighbors.size()); // Output: 2

    }

}
