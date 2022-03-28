package MaxConsecutiveOnes;

class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxConsecutiveOnes = 0;
        int currentMaxConsecutiveOnes = 0;
        for(int num : nums) {
            if(num == 1) {
                currentMaxConsecutiveOnes++;
                maxConsecutiveOnes = Math.max(currentMaxConsecutiveOnes, maxConsecutiveOnes);
            } else {
                currentMaxConsecutiveOnes = 0;
            }
        }
        return maxConsecutiveOnes;
    }
}