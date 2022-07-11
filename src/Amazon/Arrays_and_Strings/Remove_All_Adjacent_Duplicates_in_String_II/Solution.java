package Amazon.Arrays_and_Strings.Remove_All_Adjacent_Duplicates_in_String_II;

import java.util.Stack;

public class Solution {
    // Link: https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string-ii
    // Time: O(N)
    // Space: O(N)

    public String removeDuplicates(String s, int k) {
        StringBuilder sb = new StringBuilder(s);
        Stack<Integer> counts = new Stack<>();
        for (int i = 0; i < sb.length(); ++i) {
            if (i == 0 || sb.charAt(i) != sb.charAt(i - 1)) {
                counts.push(1);
            } else {
                int incremented = counts.pop() + 1;
                if (incremented == k) {
                    sb.delete(i - k + 1, i + 1);
                    i = i - k;
                } else {
                    counts.push(incremented);
                }
            }
        }
        return sb.toString();
    }

}
