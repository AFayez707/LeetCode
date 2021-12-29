package ValidPalindrome;

public class Solution {
    public boolean isPalindrome(String s) {
        int leftPointer = 0, rightPointer = s.length() - 1;
        while(leftPointer < rightPointer) {
            while(leftPointer < s.length() && !Character.isLetterOrDigit(s.charAt(leftPointer))) {
                leftPointer++;
            }
            while(rightPointer >= 0 && !Character.isLetterOrDigit(s.charAt(rightPointer))) {
                rightPointer--;
            }
            if(leftPointer < s.length() && rightPointer >= 0 && Character.toLowerCase(s.charAt(leftPointer++)) != Character.toLowerCase(s.charAt(rightPointer--))) {
                return false;
            }
        }
        return true;
    }
}
