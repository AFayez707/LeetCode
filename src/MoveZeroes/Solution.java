package MoveZeroes;

public class Solution {
//    public void moveZeroes(int[] nums) {
//        int lastNoneZeroCurrentlyFoundIndex = 0;
//        for(int i = 0; i < nums.length; i++) {
//            if(nums[i] != 0) {
//                nums[lastNoneZeroCurrentlyFoundIndex++] = nums[i];
//            }
//        }
//        for(int i = lastNoneZeroCurrentlyFoundIndex; i < nums.length; i++) {
//            nums[i] = 0;
//        }
//    }

    public void moveZeroes(int[] nums) {
        int lastNoneZeroCurrentlyFoundIndex = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[lastNoneZeroCurrentlyFoundIndex];
                nums[lastNoneZeroCurrentlyFoundIndex++] = temp;
            }
        }
    }


    public static void main(String[] args) {

    }
}
