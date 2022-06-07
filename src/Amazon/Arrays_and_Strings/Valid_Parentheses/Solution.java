package Amazon.Arrays_and_Strings.Valid_Parentheses;

import java.util.Stack;

public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            Character currentChar = s.charAt(i);
            if(currentChar.equals('(') || currentChar.equals('{') || currentChar.equals('[')) {
                stack.push(currentChar);
            } else {
                if(stack.isEmpty())
                    return false;

                if(currentChar.equals(')') && !stack.pop().equals('(')
                || currentChar.equals('}') && !stack.pop().equals('{')
                || currentChar.equals(']') && !stack.pop().equals('['))
                    return false;
            }
        }
        return stack.isEmpty();
    }
}
