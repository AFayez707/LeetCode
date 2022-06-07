package Amazon.Arrays_and_Strings.Three_Sum_Closest;

import java.util.Arrays;

// Link: https://leetcode.com/problems/3sum-closest/
// Space: O(N or Log(N)) That will be based on the sorting algorithm, Log(N) Quick Sort or N (Merge Sort)
// Time: O(N^2) As there is a finite set of roman integers that we go through.

public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int currentDifference = Integer.MAX_VALUE;
        Arrays.sort(nums);

        for(int i = 0; i < nums.length && currentDifference != 0; i++) {
            int leftPointer = i + 1;
            int rightPointer = nums.length - 1;
            while(leftPointer < rightPointer) {
                int sum = nums[i] + nums[leftPointer] + nums[rightPointer];
                if(Math.abs(target - sum) < Math.abs(currentDifference))
                    currentDifference = target - sum;
                if(sum < target)
                    leftPointer++;
                else
                    rightPointer--;
            }
        }
        return target - currentDifference;
    }

    public static void main(String[] args) {
        System.out.println(new Amazon.Arrays_and_Strings.Three_Sum_Closest.Solution().threeSumClosest(new int[]{-1, 2, 1, -4}, 1));
    }

}
