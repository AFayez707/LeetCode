package Misc.FindAllNumbersDisappearedInAnArray;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    // link: https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> answer = new ArrayList<>();

        for(int i = 0; i < nums.length; i++) {
            int correspondingIndex = Math.abs(nums[i]) - 1;
            if(nums[correspondingIndex] > 0)
                nums[correspondingIndex] *= -1;
        }

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > 0) {
                answer.add(i + 1);
            }
        }
        return answer;
    }
}
