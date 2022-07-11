package Amazon.Arrays_and_Strings.Maximal_Square;

public class Solution {
    // Link: https://leetcode.com/problems/maximal-square/
    // Space: O(N*M)
    // Time: O(M*N)
    public int maximalSquare(char[][] a) {
        if (a == null || a.length == 0 || a[0].length == 0)
            return 0;

        int max = 0, n = a.length, m = a[0].length;

        // dp(i, j) represents the length of the square
        // whose lower-right corner is located at (i, j)
        // dp(i, j) = min{ dp(i-1, j-1), dp(i-1, j), dp(i, j-1) }
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (a[i - 1][j - 1] == '1') {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        // return the area
        return max * max;
    }
}

// O(1) Space
//    public int maximalSquare(char[][] matrix) {
//        if(matrix == null || matrix.length ==0){
//            return 0;
//        }
//        int row = matrix.length;
//        int col = matrix[0].length;
//        int max = '0';
//        for(int i=0;i<row;i++){
//            for(int j=0;j<col;j++){
//                if(matrix[i][j]!='0' && i!=0 && j!=0){
//                    matrix[i][j]= (char)(Math.min(Math.min(matrix[i-1][j]-'0',matrix[i][j-1]-'0'),matrix[i-1][j-1]-'0')+1+'0');
//                }
//                if(matrix[i][j]>max){
//                    max = matrix[i][j];
//                }
//            }
//        }
//        return (max-'0')*(max-'0');
//    }