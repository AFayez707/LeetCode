package Amazon_OA.Flip_String_to_Monotone_Increasing;

public class Solution {
    // Link: https://leetcode.com/problems/flip-string-to-monotone-increasing/
    // Time: O(N)
    // Space: O(1)
    public int minFlipsMonoIncr(String s) {
        int numOfOnes = 0, numOfRequiredFlips = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '1')
                numOfOnes++;
            else
                numOfRequiredFlips = Math.min(numOfOnes, numOfRequiredFlips + 1);
        }
        return numOfRequiredFlips;
    }
}
