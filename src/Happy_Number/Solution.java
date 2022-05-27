package Happy_Number;

import java.util.HashSet;

public class Solution {

    public int calculateDigitsSquares(int num) {
        int result = 0;
        while(num != 0) {
            result += Math.pow(num % 10, 2);
            num /= 10;
        }
        return result;
    }

    public boolean isHappy(int n) {
        HashSet<Integer> numbers = new HashSet<>();

        while(n != 1) {
            int temp = calculateDigitsSquares(n);
            System.out.println(temp);

            if(numbers.contains(temp))
                return false;

            numbers.add(temp);
            n = temp;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isHappy(2));
    }
}
