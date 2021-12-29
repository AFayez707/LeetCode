package ValidPalindromeII;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().validPalindrome("abc"));
    }

    public boolean validPalindrome(String s) {
        if(s.length() == 1) return true;
        int leftPointer = 0, rightPointer = s.length() - 1;

        while(leftPointer <= rightPointer) {
            if(s.charAt(leftPointer) == s.charAt(rightPointer)) {
                leftPointer++;
                rightPointer--;
            } else {
//                return checkForPalindrome(s.substring(leftPointer, rightPointer)) || checkForPalindrome(s.substring(leftPointer + 1, rightPointer + 1));
                return checkForPalindrome(s, leftPointer + 1, rightPointer) || checkForPalindrome(s, leftPointer, rightPointer - 1);
            }
        }
        return true;
    }

    public boolean checkForPalindrome(String s) {
        int leftPointer = 0, rightPointer = s.length() - 1;
        while(leftPointer < rightPointer) {
            if(s.charAt(leftPointer) != s.charAt(rightPointer))
                return false;
            leftPointer++;
            rightPointer--;
        }
        return true;
    }

    public boolean checkForPalindrome(String s, int leftPointer, int rightPointer) {
//        int leftPointer = 0, rightPointer = s.length() - 1;
        while(leftPointer < rightPointer) {
            if(s.charAt(leftPointer) != s.charAt(rightPointer))
                return false;
            leftPointer++;
            rightPointer--;
        }
        return true;
    }

}
