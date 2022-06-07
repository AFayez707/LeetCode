package Amazon.Arrays_and_Strings.Integer_To_Roman;

public class Solution {
    // Link: https://leetcode.com/problems/integer-to-roman/
    // Space: O(1) As it doesn't change with the size of input integer, so It's constant.
    // Time: O(1) As there is a finite set of roman integers that we go through.
    private static final int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    private static final String[] symbols = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
    public String intToRoman(int num) {
        StringBuilder answer = new StringBuilder();

        for(int i = 0; i < values.length && num > 0; i++) {
            while(num >= values[i]) {
                num -= values[i];
                answer.append(symbols[i]);
            }
        }
        return answer.toString();
    }
}
