package FibonacciNumber;

public class Solution {
    public int fib(int n) {
        if(n == 0 || n == 1) return n;
        int previousPrevious = 0, previous = 1;
        int next = previous + previousPrevious;
        for(int i = 3; i <= n; i++) {
            int temp = previous;
            previous = next;
            previousPrevious = temp;
            next = previous + previousPrevious;
        }
        return next;
    }
}
