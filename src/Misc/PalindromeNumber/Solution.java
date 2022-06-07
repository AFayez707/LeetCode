package Misc.PalindromeNumber;

public class Solution {
    public boolean isPalindrome(int x) {
        int originalNumber = x;
        int reversedNumber = 0;
        boolean isNegative = x < 0;
        while(originalNumber != 0) {
            reversedNumber *= 10;
            reversedNumber += originalNumber % 10;
            originalNumber /= 10;
        }
        if (isNegative) {
            reversedNumber *= -1;
        }

        return x == reversedNumber;
    }
}
