package Amazon_OA.Maximize_Score_After_N_Operations;

import java.util.HashMap;
import java.util.Map;

public class Solution {
   public int maxScore(int[] nums) {
       int n = nums.length;
       Map<Integer, Integer> gcdValues = new HashMap<>();

       for(int i = 0; i < n; i++)
           for(int j = i + 1; j < n; j++)
               gcdValues.put((1 << i) + (2 << j), getGCD(nums[i], nums[j]));

       int possibleCombinations = 1 << n; // 2^n
       int[] DP = new int[possibleCombinations];

       for(int i = 0; i < possibleCombinations; i++) {
           // Calculate how many bits are used to represent i
           int numOfBits = Integer.bitCount(i);
           if(numOfBits % 2 != 0) // if the number of bits is odd, skip it.
               continue;

           for(int k : gcdValues.keySet()) {
               if((k & i) != 0) // overlapping used numbers
                   continue;
               DP[i ^ k] = Math.max(DP[i ^ k], DP[i] + gcdValues.get(k) * (numOfBits / 2 + 1));
           }
       }
       return DP[possibleCombinations - 1];
   }

   public int getGCD(int n1, int n2) {
       if(n2 == 0)
           return n1;
       return getGCD(n2, n1 % n2);
   }

}

// Since n<=14, it is intuitively to use bitmask to traverse all cases. We can use bitmask to record the positions where the numbers are used. For example, 3 ->00000011, it means the first and second number are used.
// Then we employ an array dp to record the maximum score where dp[i] represents the maximum score we can get by using those numbers correponding to the bitmask of i. Then dp[(2^n-1] indicates the final answer.
// Since each operation takes 2 numbers, so if the current bitcounts is odd, it can be skipped.
// The steps of the solution are as follows:
// 1. Compute all candidate GCD pairs, and record the bitmask and GCD value.
// 2. Traverse i from 0 to 2^n-1, check for each GCD pair. If the bitmask k of such GCD pair is overlapped with i (e.g., i & k != 0), it means at least one number of this pair is already used, skip it. Otherwise, update dp[i^k] = Math.max(dp[i^k], dp[i] + GCD_value(k) * bitCounts(i) / 2 + 1). Here the bitCounts(i) / 2 means the number of operations for bitmask i.

// 1. don't fully understand how bits/2 + 1 ensures we are multiplying the greatest GCD by the greatest index
// 2. what's the purpose of XOR dp[i ^k]? is it same to do dp[i | k]?
// 3. this probably relates to question 1, as how does the last element dp[2^n - 1] add up to be result of all?



//    You are given nums, an array of positive integers of size 2 * n. You must perform n operations on this array.
//
//        In the ith operation (1-indexed), you will:
//
//        Choose two elements, x and y.
//        Receive a score of i * gcd(x, y).
//        Remove x and y from nums.
//        Return the maximum score you can receive after performing n operations.
//
//        The function gcd(x, y) is the greatest common divisor of x and y.
//
//
//
//        Example 1:
//
//        Input: nums = [1,2]
//        Output: 1
//        Explanation: The optimal choice of operations is:
//        (1 * gcd(1, 2)) = 1
//        Example 2:
//
//        Input: nums = [3,4,6,8]
//        Output: 11
//        Explanation: The optimal choice of operations is:
//        (1 * gcd(3, 6)) + (2 * gcd(4, 8)) = 3 + 8 = 11
//        Example 3:
//
//        Input: nums = [1,2,3,4,5,6]
//        Output: 14
//        Explanation: The optimal choice of operations is:
//        (1 * gcd(1, 5)) + (2 * gcd(2, 4)) + (3 * gcd(3, 6)) = 1 + 4 + 9 = 14
//
//
//        Constraints:
//
//        1 <= n <= 7
//        nums.length == 2 * n
//        1 <= nums[i] <= 106