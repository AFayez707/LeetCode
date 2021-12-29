package AddStrings;

public class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder result = new StringBuilder();
        int carry = 0;
        int num1Pointer = num1.length() - 1;
        int num2Pointer = num2.length() - 1;

        while (num1Pointer >= 0 || num2Pointer >= 0 || carry == 1) {
            int num1Integer = num1Pointer >= 0 ? num1.charAt(num1Pointer--) - '0' : 0;
            int num2Integer = num2Pointer >= 0 ? num2.charAt(num2Pointer--) - '0' : 0;
            int sumResult = num1Integer + num2Integer + carry;
            carry = sumResult > 9 ? 1 : 0;
            result.append(sumResult % 10);
        }

        return result.reverse().toString();
    }
}
