package Amazon.Graphs.Number_Of_Islands;

// Link: https://leetcode.com/problems/number-of-islands/
// Time: O(N * M) Rows * Cols
// Space: O(N * M) Which happens if the grid is filled with only 1 island

public class Solution {
    public int numIslands(char[][] grid) {
        int numOfIslands = 0;

        for(int row = 0; row < grid.length; row++)
            for(int col = 0; col < grid[0].length; col++)
                if(grid[row][col] == '1') {
                    fillTheIsland(grid, row, col);
                    numOfIslands++;
                }

        return numOfIslands;
    }

    private void fillTheIsland(char[][] grid, int row, int col) {
        if(row >= 0 && col >= 0 && row < grid.length && col < grid[0].length && grid[row][col] == '1') {
            grid[row][col] = '0';
            fillTheIsland(grid, row, col + 1); // Right
            fillTheIsland(grid, row, col - 1); // Left
            fillTheIsland(grid, row - 1, col); // Up
            fillTheIsland(grid, row + 1, col); // Down
        }
    }
}
