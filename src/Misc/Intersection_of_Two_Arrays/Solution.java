package Misc.Intersection_of_Two_Arrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> hashSet1 = new HashSet<>();
        HashSet<Integer> hashSet2 = new HashSet<>();

        for(int num : nums1)
            hashSet1.add(num);

        for(int num : nums2)
            hashSet2.add(num);

        List<Integer> result = new ArrayList<>();

        for(int num : hashSet1)
            if(hashSet2.contains(num))
                result.add(num);

        int[] resultArr = new int[result.size()];

        for(int i = 0; i < result.size(); i++)
            resultArr[i] = result.get(i);

        return resultArr;
    }
}
