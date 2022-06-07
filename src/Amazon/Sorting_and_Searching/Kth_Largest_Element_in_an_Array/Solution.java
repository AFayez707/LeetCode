package Amazon.Sorting_and_Searching.Kth_Largest_Element_in_an_Array;

import java.util.PriorityQueue;

// Link: https://leetcode.com/problems/kth-largest-element-in-an-array/
// Time: O(N Log(K))
// Space: O(K)
// Note: We can perform QuickSelect Algorithm : O(1) Space .. O(N) time -> worst O(N^2)
// https://leetcode.com/problems/kth-largest-element-in-an-array/solution/
public class Solution {
    public int findKthLargest(int[] nums, int k) {
        // Min Heap
        PriorityQueue<Integer> heap = new PriorityQueue<>((n1, n2) -> n1 - n2);
        // Keep K largest elements in the heap.
        for(int number : nums) {
            heap.add(number);
            if(heap.size() > k)
                heap.poll();
        }
        return heap.poll();
    }
}
