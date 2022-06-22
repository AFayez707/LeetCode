package Amazon.Arrays_and_Strings.Sum_of_Subarray_Ranges;

// Link: https://leetcode.com/problems/sum-of-subarray-ranges/
public class Solution {
    // Time: O(N^2)
    // Space: O(1)
    public long subArrayRanges(int[] nums) {
        long solution = 0;
        for(int i = 0; i < nums.length; i++) {
            int max = nums[i], min = nums[i];
            for(int j = i; j < nums.length; j++) {
                max = Math.max(max, nums[j]);
                min = Math.min(min, nums[j]);
                solution += (max - min);
            }
        }
        return solution;
    }
    // Time: O(N)
    // Space: O(N)
    // TODO
//    public long subArrayRanges(int[] nums) {
//
//    }
}
