package Misc.HeightChecker;

import java.util.Arrays;

public class Solution {
    public int heightChecker(int[] heights) {
        int answer = 0;
        int[] sortedHeights = heights.clone();
        Arrays.sort(sortedHeights);

        for(int i = 0; i < heights.length; i++) {
            if(heights[i] != sortedHeights[i]) {
                answer++;
            }
        }
        return answer;
    }
}
