package Amazon.Two_Sum;

import java.util.HashMap;
import java.util.Map;

// Link: https://leetcode.com/problems/two-sum/
// Time: O(N)
// Space: O(N)

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numsHashMap = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if(numsHashMap.containsKey(target - nums[i]))
                return new int[]{i, numsHashMap.get(target - nums[i])};
            numsHashMap.put(nums[i], i);
        }
        return null;
    }
}
