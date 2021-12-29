package MergeSortedArray;

public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) return;

        int firstPointer = m - 1;
        int secondPointer = n -1;

        for(int i = m + n - 1; i >= 0; i--) {
            if(secondPointer < 0)
                return;

            if(firstPointer >= 0 && nums1[firstPointer] > nums2[secondPointer]) {
                nums1[i] = nums1[firstPointer--];
            } else if (secondPointer > 0) {
                nums1[i] = nums2[secondPointer--];
            }
        }
    }
}
