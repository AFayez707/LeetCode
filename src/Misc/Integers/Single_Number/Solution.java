package Misc.Integers.Single_Number;

public class Solution {
    // Link: https://leetcode.com/problems/single-number/
    // Time: O(N)
    // Space: O(1)
    public int singleNumber(int[] nums) {
        int result = 0;

        for(int num : nums)
            result ^= num;

        return result;
    }
}
