package FirstUniqueCharacterInAString;

import java.util.HashMap;

public class Solution {
    public int firstUniqChar(String s) {
        // HashMap<Character, Integer> charOcc = new HashMap<>();
        // for(int i = 0; i < s.length(); i++) {
        //     charOcc.put(s.charAt(i), charOcc.getOrDefault(s.charAt(i), 0) + 1);
        // }
        // for(int i = 0; i < s.length(); i++) {
        //     if(charOcc.get(s.charAt(i)) == 1) {
        //         return i;
        //     }
        // }


        int[] occArr = new int[26];

        for(int i = 0; i < s.length(); i++) {
            occArr[s.charAt(i) - 'a']++;
        }

        for(int i = 0; i < s.length(); i++) {
            if(occArr[s.charAt(i) - 'a'] == 1)
                return i;
        }

        return -1;
    }
}
