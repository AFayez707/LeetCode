package Amazon.Graphs.All_Paths_From_Source_to_Target;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    // DFS
    // Link: https://leetcode.com/problems/all-paths-from-source-to-target/
    // Space: O(2^V *V) Where V: Num of vertices
    // Time: O(V )
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> paths = new ArrayList<>();
        if (graph == null || graph.length == 0) {
            return paths;
        }

        dfs(graph, 0, new ArrayList<>(), paths);
        return paths;
    }

    void dfs(int[][] graph, int node, List<Integer> path, List<List<Integer>> paths) {
        path.add(node);
        if (node == graph.length - 1) {
            paths.add(new ArrayList<>(path));
            return;
        }
        int[] nextNodes = graph[node];
        for (int nextNode: nextNodes) {
            dfs(graph, nextNode, path, paths);
            path.remove(path.size() - 1);
        }
    }
}
