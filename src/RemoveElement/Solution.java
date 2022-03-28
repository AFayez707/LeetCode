package RemoveElement;

public class Solution {
//    link: https://leetcode.com/problems/remove-element/
    public int removeElement(int[] nums, int val) {
        int currentPosition = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != val) {
                nums[currentPosition++] = nums[i];
            }
        }
        return currentPosition;
    }

}
