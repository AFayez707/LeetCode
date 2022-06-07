package Misc.SortArrayByParity;

public class Solution {
//    url: https://leetcode.com/problems/sort-array-by-parity/solution/
    public int[] sortArrayByParity(int[] nums) {
        int leftPointer = 0, rightPointer = nums.length - 1;
        while (leftPointer != rightPointer) {
            if(nums[leftPointer] % 2 == 0) {
                leftPointer++;
            } else {
                int temp = nums[leftPointer];
                nums[leftPointer] = nums[rightPointer];
                nums[rightPointer--] = temp;
            }
        }
        return nums;
    }
}
