package Amazon.Trapping_Rain_Water;

// Link: https://leetcode.com/problems/trapping-rain-water
// Time: O(N)
// Space: O(1)

public class Solution {
    public int trap(int[] height) {
        int leftPointer = 0, rightPointer = height.length - 1;
        int leftMaxHeight = height[leftPointer];
        int rightMaxHeight = height[rightPointer];

        int answer = 0;

        while(leftPointer < rightPointer) {
            if(height[leftPointer] < height[rightPointer]) {
                if(height[leftPointer] > leftMaxHeight)
                    leftMaxHeight = height[leftPointer];
                else
                    answer += leftMaxHeight - height[leftPointer];
                leftPointer++;
            } else {
                if(height[rightPointer] > rightMaxHeight)
                    rightMaxHeight = height[rightPointer];
                else
                    answer += rightMaxHeight - height[rightPointer];
                rightPointer--;
            }
        }
        return answer;
    }
}
