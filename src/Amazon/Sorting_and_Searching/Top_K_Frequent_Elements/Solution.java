package Amazon.Sorting_and_Searching.Top_K_Frequent_Elements;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

// Link: https://leetcode.com/problems/top-k-frequent-elements/
// Time: O(N*LOG(K))
// Space: O(N + K)
// Note: Can be solved with QuickSelect in Average Time O(N) Worst O(N^2) -> Space O(N)
public class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if(nums.length == k)
            return nums;

        // 1. Building a HaspMap to store the occurrences for each number
        Map<Integer, Integer> occurrences = new HashMap<>();
        for(int number : nums)
            occurrences.put(number, occurrences.getOrDefault(number, 0) + 1);

        // Create Minimum Heap
        Queue<Integer> minHeap = new PriorityQueue<>((n1, n2) -> occurrences.get(n1) - occurrences.get(n2));

        // 2. keep k top frequent elements in the heap
        // O(N log k) < O(N log N) time
        for(int number : occurrences.keySet()) {
            minHeap.add(number);
            if(minHeap.size() > k)
                minHeap.poll();
        }

        int[] topKElements = new int[k];
        for(int i = k - 1; i >= 0; i--)
            topKElements[i] = minHeap.poll();

        return topKElements;
    }
}
