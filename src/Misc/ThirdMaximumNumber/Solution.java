package Misc.ThirdMaximumNumber;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
// Important
public class Solution {
    public int thirdMax(int[] nums) {
        Set<Integer> maximumsSet = new HashSet<>();

        for(int num : nums) {
            maximumsSet.add(num);
            if(maximumsSet.size() > 3) {
                maximumsSet.remove(Collections.min(maximumsSet));
            }
        }

        return maximumsSet.size() == 3 ? Collections.min(maximumsSet) : Collections.max(maximumsSet);
    }
}
