package Misc.Group_Anagrams;

import java.util.*;

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groups = new HashMap<>();

        for(String str : strs) {
            int[] keyArray = new int[26];
            for(int i = 0; i < str.length(); i++)
               keyArray[str.charAt(i) - 'a'] += 1;

            String key = Arrays.toString(keyArray);

            if(!groups.containsKey(key)) {
                groups.put(key, new ArrayList<>());
            }
            groups.get(key).add(str);
        }

        return new ArrayList(groups.values());
    }
}
