package FizzBuzz;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> answer = new ArrayList<>(n);

        for(int i = 0; i < n; i++) {
            int realNumber = i + 1;
            if(realNumber % 15 == 0) {
                answer.add("FizzBuzz");
            } else if (realNumber % 3 == 0) {
                answer.add("Fizz");
            } else if(realNumber % 5 == 0) {
                answer.add("Buzz");
            } else {
                answer.add("" + realNumber);
            }
        }
        return answer;
    }
}
