package Misc.Integers.Pow_X_to_N;

public class Solution {
    // Link: https://leetcode.com/problems/powx-n/
    // Space: O(1)
    // Time: O(Log(N))
    public double myPow(double x, int n) {
        long power = n;
        double answer = 1;
        if(power < 0)
            power = -power;

        while(power > 0) {
            if(power % 2 == 0) {
                x *= x;
                power /= 2;
            } else {
                answer *= x;
                power--;
            }
        }
        if(n < 0)
            answer = 1 / answer;

        return answer;
    }
}
