package Amazon.Container_With_Most_Water;

// Link: https://leetcode.com/problems/container-with-most-water
// Time: O(N)
// Space: O(1)

public class Solution {
    public int maxArea(int[] height) {
        int leftPointer = 0, rightPointer = height.length - 1;
        int maxArea = 0;
        while(leftPointer < rightPointer) {
            int width = rightPointer - leftPointer;
            int currentContainerArea = Math.min(height[leftPointer], height[rightPointer]) * width;
            maxArea = Math.max(maxArea, currentContainerArea);

            if(height[leftPointer] <= height[rightPointer])
                leftPointer++;
            else
                rightPointer--;
        }
        return maxArea;
    }
}
