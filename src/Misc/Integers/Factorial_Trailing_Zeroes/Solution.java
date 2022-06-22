package Misc.Integers.Factorial_Trailing_Zeroes;

public class Solution {
    // Link: https://leetcode.com/problems/factorial-trailing-zeroes/
    // Space: O(1)
    // Time: O(Log5(Number))
    public int trailingZeroes(int n) {
        int zerosCount = 0;
        for(int i = 5; i <= n; i *= 5)
            zerosCount += n / i;
        return zerosCount;
    }
}
