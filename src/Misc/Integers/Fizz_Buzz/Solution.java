package Misc.Integers.Fizz_Buzz;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    // Link: https://leetcode.com/problems/fizz-buzz/
    // Space: O(1)
    // Time: O(N)
    public List<String> fizzBuzz(int n) {
        List<String> answer = new ArrayList<>(n);
        for(int i = 1; i <= n; i++) {
            if(i % 15 == 0)
                answer.add("FizzBuzz");
            else if(i % 3 == 0)
                answer.add("Fizz");
            else if(i % 5 == 0)
                answer.add("Buzz");
            else
                answer.add(Integer.toString(i));
        }
        return answer;
    }
}
