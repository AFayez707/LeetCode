package Amazon.Roman_To_Integer;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    // Link: https://leetcode.com/problems/roman-to-integer/
    // Space: O(1) As it doesn't change with the size of input integer, so It's constant.
    // Time: O(1) As there is a finite set of roman integers that we go through.
    static Map<Character, Integer> romanValues = new HashMap<>();
    static {
        romanValues.put('M', 1000);
        romanValues.put('D', 500);
        romanValues.put('C', 100);
        romanValues.put('L', 50);
        romanValues.put('X', 10);
        romanValues.put('V', 5);
        romanValues.put('I', 1);
    }
    public int romanToInt(String s) {
        Character lastSymbol = s.charAt(s.length() - 1);
        int lastValue = romanValues.get(lastSymbol);
        int result = lastValue;

        for(int i = s.length() - 2; i >= 0; i--) {
            Character currentSymbol = s.charAt(i);
            int currentValue = romanValues.get(currentSymbol);
            if(currentValue < lastValue)
                result -= currentValue;
            else
                result += currentValue;
            lastValue = currentValue;
        }
        return result;
    }
}
