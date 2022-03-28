package RemoveDuplicatesFromSortedArray;

public class Solution {
//  link: https://leetcode.com/problems/remove-element/solution/
    public int removeDuplicates(int[] nums) {
        int leftPointer = 0, rightPointer = 1;
        while(rightPointer < nums.length) {
            if(nums[leftPointer] != nums[rightPointer]) {
                nums[++leftPointer] = nums[rightPointer];
            }
            rightPointer++;
        }
        return leftPointer;
    }
}
