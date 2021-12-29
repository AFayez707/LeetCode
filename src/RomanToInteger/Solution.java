package RomanToInteger;

import java.util.HashMap;

public class Solution {


    public int romanToInt(String s) {
        if(s == null || s.length() == 0)
            return 0;

        HashMap<Character, Integer> romanToNumber = new HashMap<>();
        romanToNumber.put('I', 1);
        romanToNumber.put('V', 5);
        romanToNumber.put('X', 10);
        romanToNumber.put('L', 50);
        romanToNumber.put('C', 100);
        romanToNumber.put('D', 500);
        romanToNumber.put('M', 1000);

        int result = romanToNumber.get(s.charAt(0));

        for(int i = 1; i < s.length(); i++) {
            result += romanToNumber.get(s.charAt(i));
            if(romanToNumber.get(s.charAt(i)) > romanToNumber.get(s.charAt(i-1))) {
                result -= 2 * romanToNumber.get(s.charAt(i-1));
            }
        }
        return result;
    }
}