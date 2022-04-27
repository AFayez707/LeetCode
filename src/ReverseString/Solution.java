package ReverseString;

public class Solution {
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
