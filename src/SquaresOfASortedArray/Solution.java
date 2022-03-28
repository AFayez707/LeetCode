package SquaresOfASortedArray;

import java.util.Arrays;

class Solution {
    public int[] sortedSquares(int[] nums) {
//        int[] squaredArray = new int[nums.length];
//        for(int currentIndex = 0; currentIndex < nums.length; currentIndex++) {
//            squaredArray[currentIndex] = nums[currentIndex] * nums[currentIndex];
//        }
//        Arrays.sort(squaredArray);
//        return squaredArray;

        int[] squaredArray = new int[nums.length];
        int leftPointer = 0, rightPointer = nums.length - 1;
        for(int currentIndex = nums.length - 1; currentIndex >= 0; currentIndex--) {
            int leftSquare = nums[leftPointer]*nums[leftPointer];
            int rightSquare = nums[rightPointer]*nums[rightPointer];
            if(leftSquare > rightSquare) {
                squaredArray[currentIndex] = leftSquare;
                leftPointer++;
            } else {
                squaredArray[currentIndex] = rightSquare;
                rightPointer--;
            }
        }
        return squaredArray;
    }
}