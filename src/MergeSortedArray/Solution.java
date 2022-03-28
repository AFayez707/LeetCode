package MergeSortedArray;

public class Solution {
//    link: https://leetcode.com/problems/merge-sorted-array/
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int firstArrayPointer = m - 1;
        int secondArrayPointer = n - 1;

        for(int i = n + m - 1; i >= 0; i--) {
            if(secondArrayPointer < 0)
                return;

            if(firstArrayPointer >= 0 && nums1[firstArrayPointer] > nums2[secondArrayPointer]) {
                nums1[i] = nums1[firstArrayPointer--];
            } else {
                nums1[i] = nums2[secondArrayPointer--];
            }
        }
    }
}
