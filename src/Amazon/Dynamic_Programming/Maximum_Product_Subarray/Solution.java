package Amazon.Dynamic_Programming.Maximum_Product_Subarray;

public class Solution {
    // Link: https://leetcode.com/problems/maximum-product-subarray
    // Time: O(N)
    // Space: O(1)
    public int maxProduct(int[] nums) {
        int maximumProduct = Integer.MIN_VALUE;
        int currentProduct=1;

        for(int num : nums){
            currentProduct *= num;
            maximumProduct = Math.max(currentProduct,maximumProduct);
            if(currentProduct == 0)
                currentProduct = 1;
        }

        currentProduct = 1;

        for(int i=nums.length-1;i>=0;i--){
            currentProduct *= nums[i];
            maximumProduct = Math.max(currentProduct,maximumProduct);
            if(currentProduct ==0)
                currentProduct = 1;
        }

        return maximumProduct;
    }
}
