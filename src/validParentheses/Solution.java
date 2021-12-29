package validParentheses;

import java.util.Stack;

public class Solution {
    public boolean isValid(String s) {
        Stack<Character> characterStack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                characterStack.push(s.charAt(i));
            } else if(s.charAt(i) == ')' || s.charAt(i) == ']' || s.charAt(i) == '}') {
                if(characterStack.empty())
                    return false;
                Character topChar = characterStack.pop();
                if(s.charAt(i) == ']' && topChar != '['
                || s.charAt(i) == ')' && topChar != '('
                || s.charAt(i) == '}' && topChar != '{')
                    return false;
            }
        }
        return characterStack.empty();
    }
}
