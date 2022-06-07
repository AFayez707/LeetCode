package Misc.ContainsDuplicate;

import java.util.HashMap;

public class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer, Integer> occHashMap = new HashMap<>();
        for(int num : nums) {
            if(occHashMap.get(num) != null)
                return true;
            occHashMap.put(num, 1);
        }
        return false;
    }
}
