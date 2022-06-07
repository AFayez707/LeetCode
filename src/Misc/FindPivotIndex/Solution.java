package Misc.FindPivotIndex;

public class Solution {
//    link: https://leetcode.com/problems/find-pivot-index/
    public int pivotIndex(int[] nums) {
        int wholeSum = 0, currentSum = 0;
        for(int num : nums) wholeSum += num;

        for(int i = 0; i < nums.length; i++) {
            // if leftSideSum = rightSideSum
            if(currentSum == wholeSum - nums[i] - currentSum)
                return i;

            currentSum += nums[i];
        }
        return -1;
    }
}
