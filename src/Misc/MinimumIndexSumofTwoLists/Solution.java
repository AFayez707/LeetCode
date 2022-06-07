package Misc.MinimumIndexSumofTwoLists;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> indexMapping = new HashMap<>();

        for(int i = 0; i < list1.length; i++)
            indexMapping.put(list1[i], i);

        int currentMinimumSum = Integer.MAX_VALUE;
        List<String> answer = new ArrayList<>();

        for(int i = 0; i < list2.length; i++) {
            if(indexMapping.containsKey(list2[i])) {
                int currentSum = i + indexMapping.get(list2[i]);
                if(currentSum < currentMinimumSum) {
                    currentMinimumSum = currentSum;
                    answer.clear();
                    answer.add(list2[i]);
                } else if(currentSum == currentMinimumSum) {
                    answer.add(list2[i]);
                }
            }
        }

        return answer.toArray(new String[answer.size()]);
    }
}
