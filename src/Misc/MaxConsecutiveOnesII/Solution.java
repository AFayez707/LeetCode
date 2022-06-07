package Misc.MaxConsecutiveOnesII;

public class Solution {
//    link: https://leetcode.com/problems/max-consecutive-ones-ii/
    public int findMaxConsecutiveOnes(int[] nums) {
        int leftPointer = 0, rightPointer = 0, numOfZeros = 0, longestSequence = 0;
        while(rightPointer < nums.length) {
            if(nums[rightPointer] == 0)
                numOfZeros++;

            while(numOfZeros == 2)
                if(nums[leftPointer++] == 0)
                    numOfZeros--;

            longestSequence = Math.max(longestSequence, rightPointer - leftPointer + 1);

            rightPointer++;
        }
        return longestSequence;
    }
}
