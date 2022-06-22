package Amazon.Arrays_and_Strings.Longest_Palindromic_Substring;

public class Solution {
    // Brute force solution
    // Time: O(N^3)
    // Space: O(1)
//    public String longestPalindrome(String s) {
//
//    }
    // Dynamic Programming Approach (Expand Around Center)
    // Time: O(N^2)
    // Space: O(1)
    // The solution is based on the fact that we have (2*N - 1) Centers, so we are expanding around them.
    public String longestPalindrome(String s) {
        if(s == null || s.length() == 0)
            return "";
        int startPosition = 0, endPosition = 0;
        for(int i = 0; i < s.length(); i++) {
            int firstLength = expandAroundCenter(s, i, i);
            int secondLength = expandAroundCenter(s, i, i + 1);
            int maxLength = Math.max(firstLength, secondLength);
            if(maxLength > endPosition - startPosition) {
                startPosition = i - (maxLength - 1) / 2;
                endPosition = i + maxLength / 2;
            }
        }
        return s.substring(startPosition, endPosition + 1);
    }

    private int expandAroundCenter(String s, int leftPosition, int rightPosition) {
        while (leftPosition >= 0 && rightPosition < s.length() && s.charAt(leftPosition) == s.charAt(rightPosition)) {
            leftPosition--;
            rightPosition++;
        }
        return rightPosition - leftPosition - 1;
    }
}
