package Amazon.Arrays_and_Strings.Multiply_Strings;

public class Solution {
    // Link: https://leetcode.com/problems/multiply-strings
    // Space: O(N + M)
    // Time: O(N * M)
    public String multiply(String num1, String num2) {
        int num1Length = num1.length(), num2Length = num2.length();

        int[] vals = new int[num1Length + num2Length];

        for(int i = num1Length - 1; i >= 0; i--) {
            for(int j = num2Length - 1; j >= 0; j--) {
                int multiplyResult = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int sum = vals[i + j + 1] + multiplyResult;
                vals[i + j + 1] = sum % 10;
                vals[i + j] += sum / 10;
            }
        }
        StringBuilder result = new StringBuilder();
        for(int val : vals) {
            if(result.length() != 0 || val != 0)
                result.append(val);
        }

        return result.length() == 0 ? "0" : result.toString();
    }
}
