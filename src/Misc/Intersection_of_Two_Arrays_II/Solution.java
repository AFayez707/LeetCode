package Misc.Intersection_of_Two_Arrays_II;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length)
            return intersect(nums2, nums1);

        Map<Integer, Integer > occurences = new HashMap<>();

        for(int i = 0; i < nums1.length; i++) {
            if(occurences.containsKey(nums1[i]))
                occurences.put(nums1[i], occurences.get(nums1[i]) + 1);
            else
                occurences.put(nums1[i], 1);
        }

        List<Integer> result = new ArrayList<>();

        for(int num : nums2) {
            if(occurences.containsKey(num)) {
                result.add(num);
                occurences.put(num, occurences.get(num) - 1);

                if(occurences.get(num) == 0)
                    occurences.remove(num);
            }
        }

        return result.stream().mapToInt(num -> num).toArray();
    }
}
