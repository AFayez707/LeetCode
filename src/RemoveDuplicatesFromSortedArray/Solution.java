package RemoveDuplicatesFromSortedArray;

public class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;

        int leftPointer = 0, rightPointer = 1;

        while(rightPointer < nums.length) {
            if(nums[leftPointer] != nums[rightPointer]) {
                nums[++leftPointer] = nums[rightPointer];
            }
            rightPointer++;
        }

        return leftPointer + 1;
    }
}
