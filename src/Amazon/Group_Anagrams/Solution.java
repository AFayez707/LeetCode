package Amazon.Group_Anagrams;

import java.util.*;

public class Solution {
    // Link: https://leetcode.com/problems/integer-to-roman/
    // Space: O(N * K) As it doesn't change with the size of input integer, so It's constant.
    // Time: O(N * K) N: Length of strs, K: Maximum Length of a string in strs

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groups = new HashMap<>();

        for(String str : strs) {
            int[] keyArray = new int[26];

            for(int i = 0; i < str.length(); i++)
                keyArray[str.charAt(i) - 'a']++;

            String key = Arrays.toString(keyArray);

            if(!groups.containsKey(key))
                groups.put(key, new ArrayList<>());

            groups.get(key).add(str);
        }
        return new ArrayList(groups.values());
    }

    public static void main(String[] args) {
        System.out.println(new Amazon.Group_Anagrams.Solution().groupAnagrams(new String[]{"hi", "ih"}));
    }
}
