package KthMissingPositiveNumber;

public class Solution {
    public int findKthPositive(int[] arr, int k) {
        int leftPointer = 0, rightPointer = arr.length - 1;
        while (leftPointer <= rightPointer) {
            int middlePointer = (leftPointer + rightPointer) / 2;
            if(arr[middlePointer] - middlePointer - 1 < k)
                rightPointer = leftPointer + 1;
            else
                leftPointer = rightPointer + 1;
        }
        return k + rightPointer + 1;
    }
}
