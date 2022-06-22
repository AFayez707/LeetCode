package Misc.Integers.Reverse_Integer;

public class Solution {
    // Link: https://leetcode.com/problems/reverse-integer
    // Space: O(1)
    // Time: O(Log10(Number))
    int reverse(int x) {
        int result = 0;
        while(x != 0) {
            int reminder = x % 10;
            x /= 10;
            if(result > Integer.MAX_VALUE / 10
            || (result == Integer.MAX_VALUE / 10 && reminder > 7))
                return 0;
            if(result < Integer.MIN_VALUE / 10
                    || (result == Integer.MIN_VALUE / 10 && reminder < -8))
                return 0;
            result = result * 10 + reminder;
        }
        return result;
    }
}
