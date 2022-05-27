package Amazon.Rotate_Image;

// Link: https://leetcode.com/problems/rotate-image/
// Time: O(N*N) Where N is the Matrix Size
// Space: O(1)

public class Solution {
    public void rotate(int[][] matrix) {
//        Original Matrix
//        1	2	3
//        4	5	6
//        7	8	9
        transpose(matrix);
//        Returns
//        1	4	7
//        2	5	8
//        3	6	9
        mirror(matrix);
//        Returns
//        7	4	1
//        8	5	2
//        0	6	3
    }

    private void transpose(int[][] matrix) {
        int n = matrix.length;
        for(int row = 0; row < n; row++) {
            for (int col = row + 1; col < n; col++) {
                int temp = matrix[row][col];
                matrix[row][col] = matrix[col][row];
                matrix[col][row] = temp;
            }
        }
    }

    private void mirror(int[][] matrix) {
        int n = matrix.length;
        for(int row = 0; row < n; row++) {
            for (int col = 0; col < n / 2; col++) {
                int temp = matrix[row][col];
                matrix[row][col] = matrix[row][n - col - 1];
                matrix[row][n - col - 1] = temp;
            }
        }
    }

}
