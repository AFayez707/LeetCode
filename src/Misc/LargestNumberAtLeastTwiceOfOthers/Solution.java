package Misc.LargestNumberAtLeastTwiceOfOthers;

public class Solution {
    public int dominantIndex(int[] nums) {
        int maxNumValue = Integer.MIN_VALUE;
        int maxNumIndex = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > maxNumValue) {
                maxNumIndex = i;
                maxNumValue = nums[i];
            }
        }

        for(int num : nums) {
            if(num != maxNumValue && maxNumValue < num * 2)
                return -1;
        }
        return maxNumIndex;
    }
}
