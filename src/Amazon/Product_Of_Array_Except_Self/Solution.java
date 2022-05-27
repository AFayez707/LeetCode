package Amazon.Product_Of_Array_Except_Self;

// Link: https://leetcode.com/problems/product-of-array-except-self
// Time: O(N)
// Space: O(1)

public class Solution {
    public int[] productExceptSelf(int[] nums) {
        if(nums == null || nums.length == 0)
            return null;

        int length = nums.length;
        int[] answer = new int[length];

        // answer[i] will contain the cumulative product of all elements on the left, so we initialize it with 1.
        answer[0] = 1;

        // Before this step // nums = {1, 2, 3, 4}  // answer = {1, 0, 0, 0}
        for(int i = 1; i < length; i++) {
            answer[i] = answer[i - 1] * nums[i - 1];
        }
        // After this step  // nums = {1, 2, 3, 4}  // answer = {1, 1, 2, 6}

        int rightProduct = 1;
        for(int i = length - 1; i >= 0; i--) {
            answer[i] *= rightProduct;
            rightProduct *= nums[i];
        }
        // After this step  // nums = {1, 2, 3, 4}  // answer = {24, 12, 8, 6}

        return answer;
    }
}
