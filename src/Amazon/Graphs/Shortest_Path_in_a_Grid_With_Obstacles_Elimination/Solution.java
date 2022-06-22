package Amazon.Graphs.Shortest_Path_in_a_Grid_With_Obstacles_Elimination;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    // Link: https://leetcode.com/problems/shortest-path-in-a-grid-with-obstacles-elimination/
    // Space: O(N*M*K)
    // Time: O(N*M*K)
    public int shortestPath(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        int[][] DIRECTIONS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        boolean[][][] visited = new boolean[m][n][k + 1];
        Queue<int[]> queue = new LinkedList<>();
        int requiredSteps = 0;

        queue.add(new int[]{0, 0, k});

        while(!queue.isEmpty()) {
            int queueSize = queue.size();

            while(queueSize-- > 0) {
                int[] currentPosition = queue.poll();
                // If currentPosition == destination; return the current steps
                if(currentPosition[0] == m - 1 && currentPosition[1] == n - 1) {
                    return requiredSteps;
                } else { // Traverse all possible directions
                    for(int[] direction : DIRECTIONS) {
                        int i = currentPosition[0] + direction[0];
                        int j = currentPosition[1] + direction[1];
                        int obstacles = currentPosition[2];

                        // Traverse through the valid cells
                        if(i >= 0 && i < m && j >= 0 && j < n) {
                            // If the cell is empty then visit it and add it in the queue
                            if(grid[i][j] == 0 && !visited[i][j][obstacles]) {
                                queue.add(new int[]{i, j, obstacles});
                                visited[i][j][obstacles] = true;
                            } else if (grid[i][j] == 1 && obstacles > 0 && !visited[i][j][obstacles - 1]) {
                                queue.add(new int[]{i, j, obstacles - 1});
                                visited[i][j][obstacles - 1] = true;
                            }
                        }
                    }
                }
            }
            requiredSteps++;
        }
        // If the function didn't return yet, that means there's no possible solution.
        return -1;
    }
}
