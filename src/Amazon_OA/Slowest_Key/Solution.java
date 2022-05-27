package Amazon_OA.Slowest_Key;

import java.util.HashMap;
import java.util.Map;

public class Solution {
//    Time: O(N)
//    Space: O(1)
//    Link: https://leetcode.com/problems/slowest-key
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        int n = releaseTimes.length;
        int longestPressDuration = releaseTimes[0];
        char longestPressChar = keysPressed.charAt(0);
        for(int i = 1; i < releaseTimes.length; i++) {
            int currentDuration = releaseTimes[i] - releaseTimes[i - 1];
            if(currentDuration > longestPressDuration ||
                    (currentDuration == longestPressDuration && keysPressed.charAt(i) > longestPressChar)) {
                longestPressDuration = currentDuration;
                longestPressChar = keysPressed.charAt(i);
            }
        }
        return longestPressChar;
    }


//    Time: O(N)
//    Space: O(K) number of keys

//    public char slowestKey(int[] releaseTimes, String keysPressed) {
//        Map<Character, Integer> durations = new HashMap<>();
//        durations.put(keysPressed.charAt(0), releaseTimes[0]);
//
//        for(int i = 1; i < keysPressed.length(); i++) {
//            char currentPressedChar = keysPressed.charAt(i);
//            int currentKeyDuration = releaseTimes[i] - releaseTimes[i - 1];
//            if(durations.containsKey(currentPressedChar)) {
//                durations.put(currentPressedChar, Math.max(currentKeyDuration, durations.get(currentPressedChar)));
//            } else {
//                durations.put(currentPressedChar, currentKeyDuration);
//            }
//        }
//        char resultChar = 'a';
//        int resultCharDuration = 0;
//        for(Character key : durations.keySet()) {
//            if(durations.get(key) == resultCharDuration && key > resultChar) {
//                resultChar = key;
//            } else if(durations.get(key) > resultCharDuration) {
//                resultChar = key;
//                resultCharDuration = durations.get(key);
//            }
//        }
//        return resultChar;
//    }
}
