package ClimbingStairs;

import java.util.ArrayList;

public class Solution {
    // Iterative Approach with O(1) Memory
    public int climbStairs(int n) {
        if(n == 1) return 1;
        int firstStep = 1, secondStep = 2;
        for(int i = 3; i <= n; i++) {
            int nextStep = firstStep + secondStep;
            firstStep = secondStep;
            secondStep = nextStep;
        }
        return secondStep;
    }

    // Recursive Approach with Memoization
//    public int climbStairs(int n) {
//        int count[] = new int[n+1];
//        return climbStairs(count, n);
//    }
//
//    public int climbStairs(int count[], int n) {
//        if(n <= 3) return n;
//
//        if(count[n] != 0)
//            return count[n];
//
//        count[n] = climbStairs(count, n-1) + climbStairs(count, n-2);
//        return count[n];
//    }
}
