package Amazon.Arrays_and_Strings.Evaluate_Reverse_Polish_Notation;

import java.util.Stack;

public class Solution {
    // Link: https://leetcode.com/problems/evaluate-reverse-polish-notation/
    // Time: O(N)
    // Space: O(N)
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String token : tokens) {
            switch (token.charAt(token.length() - 1)) {
                case '+':
                    stack.push(stack.pop() + stack.pop());
                    break;
                case '-':
                    stack.push(-1 * stack.pop() + stack.pop());
                    break;
                case '*':
                    stack.push(stack.pop() * stack.pop());
                    break;
                case '/':
                    int num2 = stack.pop(), num1 = stack.pop();
                    stack.push(num1 / num2);
                    break;
                default:
                    stack.push(Integer.valueOf(token));
                    break;
            }
        }
        return stack.pop();
    }
}
