package Amazon.Arrays_and_Strings.Three_Sum;

import java.util.*;

// Link: https://leetcode.com/problems/3sum/
// Time: O(N^2)
// Space: O(n) for the hashset

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> solutionList = new ArrayList<>();

        for(int targetPosition = 0; targetPosition < nums.length && nums[targetPosition] <= 0; targetPosition++) {
            if(targetPosition == 0 || nums[targetPosition] != nums[targetPosition - 1])
                twoSum(nums, targetPosition, solutionList);
        }
        return solutionList;
    }

    private void twoSum(int[] nums, int targetPosition, List<List<Integer>> solutionList) {
        Set<Integer> seenNumbers = new HashSet<Integer>();
        for(int i = targetPosition + 1; i < nums.length; i++) {
            int complement = -nums[targetPosition] - nums[i];
            if(seenNumbers.contains(complement)) {
                solutionList.add(Arrays.asList(nums[i], nums[targetPosition], complement));
                // Optimization step to skip the similar numbers
                while(i + 1 < nums.length && nums[i] == nums[i + 1])
                    i++;
            }
            seenNumbers.add(nums[i]);
        }
    }
}
