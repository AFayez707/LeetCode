package Amazon.Sorting_and_Searching.Search_in_Rotated_Sorted_Array;

// Link: https://leetcode.com/problems/search-in-rotated-sorted-array/
// Time:
// Space:
public class Solution {
    public int search(int[] nums, int target) {
        int leftPointer = 0;
        int rightPointer = nums.length - 1;
        while (leftPointer <= rightPointer) {
            int middlePointer = leftPointer + (rightPointer - leftPointer) / 2;

            if (nums[middlePointer] == target) {
                return middlePointer;
            } else if (nums[middlePointer] >= nums[leftPointer]) {
                // We are here because the left side is sorted
                if (target >= nums[leftPointer] && target < nums[middlePointer])
                    rightPointer = middlePointer - 1;
                else
                    leftPointer = middlePointer + 1;
            }
            else {
                // The left side is rotated (Not Sorted)
                if (target <= nums[rightPointer] && target > nums[middlePointer])
                    leftPointer = middlePointer + 1;
                else
                    rightPointer = middlePointer - 1;
            }
        }
        return -1;
    }
}
