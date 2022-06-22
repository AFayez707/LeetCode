package Amazon.Arrays_and_Strings.Remove_All_Ones_With_Row_and_Column_Flips;

public class Solution {
    // Link: https://leetcode.com/problems/remove-all-ones-with-row-and-column-flips/
    // Space: O(1)
    // Time: O(N*M)
    // Both rows have to follow the same patterns for us to be able to flip them into all 0s.
    // and by the same patterns, I mean for any two rows, they either have to be
    // Exactly the same
    // Exactly opposite
    // We are taking the first row as the reference, and compare all the rows with it.
    public boolean removeOnes(int[][] grid) {
        for (int[] g : grid)
            for (int i = 0; i < g.length; i++)
                if (Math.abs(g[i] - grid[0][i]) != Math.abs(g[0] - grid[0][0]))
                    return false;
        return true;
    }
}
