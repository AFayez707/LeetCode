package Amazon.Arrays_and_Strings.Reverse_String;

public class Solution {
    // Link: https://leetcode.com/problems/reverse-string/
    // Space: O(1)
    // Time: O(N)
    public void reverseString(char[] s) {
        if(s == null || s.length <= 1)
            return;

        int leftPointer = 0, rightPointer = s.length - 1;

        while(leftPointer < rightPointer) {
            char temp = s[leftPointer];
            s[leftPointer++] = s[rightPointer];
            s[rightPointer--] = temp;
        }
    }
}
