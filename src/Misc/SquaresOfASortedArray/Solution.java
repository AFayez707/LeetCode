package Misc.SquaresOfASortedArray;

class Solution {
    // link: https://leetcode.com/problems/squares-of-a-sorted-array/
    public int[] sortedSquares(int[] nums) {
        int[] squaredArray = new int[nums.length];

        int leftPointer = 0, rightPointer = nums.length - 1;
        for (int currentIndex = nums.length - 1; currentIndex >= 0; currentIndex--) {
            int leftSquared = nums[leftPointer] * nums[leftPointer];
            int rightSquared = nums[rightPointer] * nums[rightPointer];
            if (leftSquared > rightSquared) {
                squaredArray[currentIndex] = leftSquared;
                leftPointer++;
            } else {
                squaredArray[currentIndex] = rightSquared;
                rightPointer--;
            }
        }
        return squaredArray;
    }
}