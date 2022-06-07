package Misc.Two_Sum_II_Input_array_is_sorted;

public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int leftPointer = 0, rightPointer = numbers.length - 1;

        while(leftPointer < rightPointer) {
            int sum = numbers[leftPointer] + numbers[rightPointer];
            if(target == sum)
                return new int[] {leftPointer + 1, rightPointer + 1};

            if(sum < target)
                leftPointer++;
            else
                rightPointer--;
        }
        return new int[] {-1, -1};
    }
}
