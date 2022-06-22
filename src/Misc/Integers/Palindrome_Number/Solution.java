package Misc.Integers.Palindrome_Number;

public class Solution {
    // Link: https://leetcode.com/problems/palindrome-number/
    // Space: O(1)
    // Time: O(Log10(Number))
    public boolean isPalindrome(int x) {
        // Check if the number is negative, or the last digit of the number is zero
        if(x < 0 || (x != 0 && x%10 == 0))
            return false;

        int reversedNumber = 0;

        while(x > reversedNumber) {
            int lastDigit = x % 10;
            reversedNumber = reversedNumber * 10 + lastDigit;
            x /= 10;
        }

        // return if they're equal, or x = reversedNumber/10 to handle odd number of digits.
        // Aka. to ignore the middle number.
        return x == reversedNumber || x == reversedNumber / 10;
    }

//    public boolean isPalindrome(int x) {
//        int originalNumber = x;
//        int reversedNumber = 0;
//        boolean isNegative = x < 0;
//
//        while(originalNumber != 0) {
//            reversedNumber *= 10;
//            reversedNumber += originalNumber % 10;
//            originalNumber /= 10;
//        }
//        if (isNegative)
//            reversedNumber *= -1;
//
//        return x == reversedNumber;
//    }
}
