package TwoSum;

import java.util.HashMap;

public class Solution {
    public static void main(String[] args) {
        System.out.println("Hello");
    }

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> numsHashMap = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if(numsHashMap.get(target - nums[i] ) != null) {
                return new int[] {i, numsHashMap.get(target - nums[i])} ;
            }
            numsHashMap.put(nums[i], i);
        }
        return null;
    }
}