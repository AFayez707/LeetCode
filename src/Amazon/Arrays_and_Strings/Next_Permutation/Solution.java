package Amazon.Arrays_and_Strings.Next_Permutation;

import java.util.Arrays;

public class Solution {
    // Link: https://leetcode.com/problems/next-permutation/
    // Space: O(1) Or depends on Sorting
    // Time: O(N)
    public void nextPermutation(int[] nums) {
        if(nums == null || nums.length == 0 || nums.length == 1)
            return;

        int firstDecreasingNumberFromRight = findFirstDecreasingIndexFromRight(nums);

        // If we find an element that is in decreasing order from right
        if(firstDecreasingNumberFromRight != -1) {
            int justGreaterOrEqualIndex = findNumberJustGreaterThanOrEqual(nums, firstDecreasingNumberFromRight);
            swap(nums, firstDecreasingNumberFromRight, justGreaterOrEqualIndex);
        }
        Arrays.sort(nums, firstDecreasingNumberFromRight + 1, nums.length);
    }

    private int findNumberJustGreaterThanOrEqual(int[] nums, int firstDecreasingIndex) {
        for(int justGreaterIndex = firstDecreasingIndex + 1; justGreaterIndex < nums.length; justGreaterIndex++) {
            if(nums[justGreaterIndex] <= nums[firstDecreasingIndex]) {  // this is the first element less than firstDecreasing
                return justGreaterIndex - 1; // return the previous element's index.
            }
        }
        // return the last element if no match found
        return  nums.length - 1;
    }

    private int findFirstDecreasingIndexFromRight(int[] nums) {
        // try to find the first decreasing number from right
        // ex [3, 1, 2, 4, 5, 3]
        // the method will return 4
        for(int firstDecreasing = nums.length - 2; firstDecreasing >= 0; firstDecreasing--) {
            if(nums[firstDecreasing] < nums[firstDecreasing + 1])
                return firstDecreasing;
        }
        // if no number was found, then return -1
        return -1;
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

}
