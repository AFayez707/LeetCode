package Amazon.Dynamic_Programming.MaximumSubArray;

public class Solution {
//    public int maxSubArray(int[] nums) {
//        if(nums == null || nums.length == 0) return 0;
//
//        int currentSum = nums[0], maximumSum = nums[0];
//
//        for(int i = 1 ; i < nums.length; i++) {
//            currentSum = Math.max(currentSum + nums[i], nums[i]);
//            maximumSum = Math.max(maximumSum, currentSum);
//        }
//        return maximumSum;
//    }
    public int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        int currentSum = nums[0], maxSum = nums[0];

        for(int i = 1; i < nums.length; i++) {
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }
}
