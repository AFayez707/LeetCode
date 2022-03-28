package FindNumberswithEvenNumberofDigits;

class Solution {
    public int findNumbers(int[] nums) {
        int answer = 0;
        for(int num : nums) {
            int numOfDigits = 0;
            while (num != 0) {
                num/=10;
                numOfDigits++;
            }
            if(numOfDigits %2 == 0) {
                answer++;
            }
        }
        return answer;
    }
}