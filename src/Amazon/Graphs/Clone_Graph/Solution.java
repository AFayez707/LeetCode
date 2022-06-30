package Amazon.Graphs.Clone_Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

class Solution {
    // Link: https://leetcode.com/problems/clone-graph/
    // Time: O(V + E)
    // Space: O(V)
    public Node cloneGraph(Node node) {
        if (node == null) {
            return node;
        }

        // Hash map to save the visited node and it's respective clone
        // as key and value respectively. This helps to avoid cycles.
        HashMap<Node, Node> visited = new HashMap();

        // Put the first node in the queue
        LinkedList<Node> queue = new LinkedList<Node> ();
        queue.add(node);
        // Clone the node and put it in the visited dictionary.
        visited.put(node, new Node(node.val, new ArrayList()));

        // Start BFS traversal
        while (!queue.isEmpty()) {
            // Pop a node say "n" from the from the front of the queue.
            Node n = queue.remove();
            // Iterate through all the neighbors of the node "n"
            for (Node neighbor: n.neighbors) {
                if (!visited.containsKey(neighbor)) {
                    // Clone the neighbor and put in the visited, if not present already
                    visited.put(neighbor, new Node(neighbor.val, new ArrayList()));
                    // Add the newly encountered node to the queue.
                    queue.add(neighbor);
                }
                // Add the clone of the neighbor to the neighbors of the clone node "n".
                visited.get(n).neighbors.add(visited.get(neighbor));
            }
        }

        // Return the clone of the node from visited.
        return visited.get(node);
    }
}