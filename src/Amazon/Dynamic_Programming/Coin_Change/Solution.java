package Amazon.Dynamic_Programming.Coin_Change;

import java.util.Arrays;

public class Solution {
    // Link: https://leetcode.com/problems/coin-change/
    // Space: O(M) // M = Amount
    // Time: O(N * M) // N = Coins, M = Amount
    public int coinChange(int[] coins, int amount) {
        // Use DP as an array to represent how many coins used to reach each amount
        // From 1 to amount
        // This is Bottom up approach
        int[] dp = new int[amount + 1];
        // Initialize the dp array with amount + 1 which is never going to happen.
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        for(int i = 0; i <= amount; i++)
            for(int coin : coins)
                if(coin <= i)
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);

        return dp[amount] > amount ? -1 : dp[amount];
    }
}


