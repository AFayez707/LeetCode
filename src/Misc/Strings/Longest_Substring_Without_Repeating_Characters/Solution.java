package Misc.Strings.Longest_Substring_Without_Repeating_Characters;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    // Link: https://leetcode.com/problems/longest-substring-without-repeating-character
    // Space: O(Max(CharSet, N))
    // Time: O(N)
    public int lengthOfLongestSubstring(String s) {
        Set<Character> includedChars = new HashSet<>();
        int currentMaxLength = 0, currentLength = 0;
        int leftPointer = 0, rightPointer = 0;
        while(rightPointer < s.length()) {
            if(!includedChars.contains(s.charAt(rightPointer))) {
                includedChars.add(s.charAt(rightPointer));
                rightPointer++;
                currentLength++;
            } else {
                includedChars.remove(s.charAt(leftPointer));
                leftPointer++;
                currentLength--;
            }
            currentMaxLength = Math.max(currentLength, currentMaxLength);
        }
        return currentMaxLength;
    }
}