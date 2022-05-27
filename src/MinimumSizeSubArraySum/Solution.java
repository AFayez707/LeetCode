package MinimumSizeSubArraySum;

public class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int answer = Integer.MAX_VALUE;
        int currentSum = 0;
        int leftPointer = 0;

        for(int i = 0; i < nums.length; i++) {
            currentSum += nums[i];
            while(currentSum >= target) {
                answer = Math.min(answer, i - leftPointer + 1);
                currentSum -= nums[leftPointer++];
            }
        }
        return answer == Integer.MAX_VALUE ? 0 : answer;
    }
}
