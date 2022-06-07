package Amazon.Arrays_and_Strings.String_to_Integer;

// Link: https://leetcode.com/problems/string-to-integer-atoi/
// Time: O(N)
// Space: O(1)

public class Solution {
    public int myAtoi(String s) {
        int sign = 1;
        int result = 0;
        int currentIndex = 0;
        int n = s.length();

        // Discard all spaces from the beginning of the input string.
        while (currentIndex < n && s.charAt(currentIndex) == ' ') {
            currentIndex++;
        }

        // sign = +1, if it's positive number, otherwise sign = -1.
        if (currentIndex < n && s.charAt(currentIndex) == '+') {
            sign = 1;
            currentIndex++;
        } else if (currentIndex < n && s.charAt(currentIndex) == '-') {
            sign = -1;
            currentIndex++;
        }

        // Traverse next digits of input and stop if it is not a digit
        while (currentIndex < n && Character.isDigit(s.charAt(currentIndex))) {
            int digit = s.charAt(currentIndex) - '0';

            // Check overflow and underflow conditions.
            if ((result > Integer.MAX_VALUE / 10) ||
                    (result == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10)) {
                // If integer overflowed return 2^31-1, otherwise if underflowed return -2^31.
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            // Append current digit to the result.
            result = result * 10 + digit;
            currentIndex++;
        }

        // We have formed a valid number without any overflow/underflow.
        // Return it after multiplying it with its sign.
        return sign * result;
    }
}
