package Misc.AddBinary;

public class Solution {
    public String addBinary(String a, String b) {
        int aPointer = a.length() - 1;
        int bPointer = b.length() - 1;
        int carry = 0;

        StringBuilder result = new StringBuilder();

        while(aPointer >= 0 || bPointer >= 0) {
            int aNumber = aPointer >= 0 ? a.charAt(aPointer) - '0' : 0;
            int bNumber = bPointer >= 0 ? b.charAt(bPointer) - '0' : 0;

            int sum = aNumber + bNumber + carry;

            carry = sum / 2;

            result.insert(0, sum % 2);
            aPointer--;
            bPointer--;
        }

        if(carry != 0)
            result.insert(0, carry);

        return result.toString();

    }
}
