package Misc.ContainsDuplicateII;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> currentNumbersInWindow = new HashSet<>();

        for(int i = 0; i < nums.length; i++) {
            if(currentNumbersInWindow.contains(nums[i]))
                return true;

            currentNumbersInWindow.add(nums[i]);

            if(currentNumbersInWindow.size() > k)
                currentNumbersInWindow.remove(nums[i - k]);
        }

        return false;
    }
}
