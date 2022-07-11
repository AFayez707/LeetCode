package Amazon.Implementations.Consecutive_Numbers_Sum;
//        The idea behind the solution is that for a large target number, to make consecutive sum equal to the target, each number would be a first number plus 1, 2, 3...
//
//        for example, for 2 numbers to add up to 50001, we need 25000 and 25001, which is (25000 + 0) + (25000 + 1)
//        for 3 number to add up to 60003, we need 20000, 20001, 20002, which is (20000 + 0) + (20000 + 1) + (20000 + 2)
//
//        let's look at the numbers after the first number, basically they need to add 1, 2, 3..
//
//        but how many?
//
//        for 2 numbers, we need to add 1
//        for 3 numbers, we need to add 1 + 2
//        for 4 numbers, we need to add 1 + 2 + 3
//        ...
//        for k numbers, we need to add 1 + 2 + 3 + 4 .. + k - 1
//
//        so now let's loop through the possible number of consecutive numbers that adds to target.
//        for loop 1, we just need to subtract 0, and make sure 1 integer can add up to target. here this number is just target itself.
//        for loop 2, we substract 1, the rest should be able to be devided into two integers, like 100 + 100, or 200 + 200. we can use mod to check this, as long as rest % 2 == 0, we know such two numbers exist.
//        for loop 3, we substract 1 + 2, the rest should be able to be devided into three integers, like 12 + 12 + 12. the 1 and 2 are taken away from the second 12 and third 12, which they were 12 + 13 (12 + 1) + 14 (12 + 2). for the rest, we just need to % 3 and check if it's 0;
//

//Link: https://leetcode.com/problems/consecutive-numbers-sum
//Time: O(Sqrt(N))
//Space: O(1)

public class Solution {
    public int consecutiveNumbersSum(int n) {
        int subtracted = 0;
        int windowSize = 1;
        int answer = 0;

        while (subtracted + windowSize <= n) {
            if ((n - subtracted) % windowSize == 0)
                answer++;

            subtracted += windowSize;
            windowSize++;
        }

        return answer;
    }
}
