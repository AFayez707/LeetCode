package Misc.IntersectionOfTwoArrays;

import java.util.HashMap;

public class Solution {
    public void fillHashMap(HashMap<Integer, Boolean> hashMap, int[] nums) {
        for(int num : nums)
            hashMap.put(num, false);
    }
    public int findAndCountIntersections(HashMap<Integer, Boolean> hashMap, int[] nums) {
        int counter = 0;
        for(int num : nums) {
            if(hashMap.get(num) != null) {
                if(!hashMap.get(num))
                    counter++;
                hashMap.put(num, true);
            }
        }
        return counter;
    }
    public int[] intersection(int[] nums1, int[] nums2) {
        HashMap<Integer, Boolean> numsIntersection = new HashMap<>();
        int numberOfIntersections = 0;

        if(nums1.length < nums2.length) {
            fillHashMap(numsIntersection, nums1);
            numberOfIntersections = findAndCountIntersections(numsIntersection, nums2);
        }
        else {
            fillHashMap(numsIntersection, nums2);
            numberOfIntersections = findAndCountIntersections(numsIntersection, nums1);
        }

        int[] result = new int[numberOfIntersections];
        int currentPosition = 0;
        for(Integer key : numsIntersection.keySet()) {
            if(numsIntersection.get(key))
                result[currentPosition++] = key;
        }

        return result;
    }
}
