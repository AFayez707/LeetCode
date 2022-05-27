package Amazon.Longest_Substring_Without_Repeating_Characters;

import java.util.HashSet;
import java.util.Set;

// Link: https://leetcode.com/problems/longest-substring-without-repeating-characters
// Time: O(N)
// Space: O(min(N, k)) Where K is the size of the Set that used to check for duplicates.

public class Solution {
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

    public static void main(String[] args) {
        System.out.println(new Solution().lengthOfLongestSubstring("abcabcbb"));
        System.out.println(new Solution().lengthOfLongestSubstring("bbbbbbbbbbbb"));
        System.out.println(new Solution().lengthOfLongestSubstring("pwwkew"));
    }
}
