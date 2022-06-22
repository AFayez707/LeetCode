package Misc.Strings.Valid_Parentheses;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution {
    // Link: https://leetcode.com/problems/valid-parentheses/
    // Time: O(N)
    // Space: O(N)
    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            if(map.containsKey(currentChar)) {
                char stackTop = stack.size() != 0 ? stack.pop() : '#';
                if(stackTop != map.get(currentChar))
                    return false;
            } else {
                stack.push(currentChar);
            }
        }
        return stack.isEmpty();
    }
}
