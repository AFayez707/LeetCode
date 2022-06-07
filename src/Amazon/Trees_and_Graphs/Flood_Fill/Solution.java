package Amazon.Trees_and_Graphs.Flood_Fill;

// Link: https://leetcode.com/problems/flood-fill
// Space: O(M * N), Where M: Rows, N: Columns
// Time: O(M * N), Where M: Rows, N: Columns

public class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int originalColor = image[sr][sc];
        if(originalColor != newColor)
            performDFS(image, sr, sc, originalColor, newColor);
        return image;
    }

    private void performDFS(int[][] image, int row, int col, int originalColor, int newColor) {
        if(row >= 0 && col >= 0 && row < image.length && col < image[0].length && image[row][col] == originalColor) {
            image[row][col] = newColor;
            performDFS(image, row, col + 1, originalColor, newColor); // Right
            performDFS(image, row, col - 1, originalColor, newColor); // Left
            performDFS(image, row - 1, col, originalColor, newColor); // Up
            performDFS(image, row + 1, col, originalColor, newColor); // Down
        }
    }
}
