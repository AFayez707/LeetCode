package Amazon.Sorting_and_Searching.Meeting_Rooms_II;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
// Link: https://leetcode.com/problems/meeting-rooms-ii
// Time: O(N Log N)
// Space: O(N) The Worst Case fot the Minimum Heap.
public class Solution {
    public int minMeetingRooms(int[][] intervals) {
        if(intervals == null || intervals.length == 0)
            return 0;

        // Creating Minimum Heap
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(
                intervals.length,
                new Comparator<Integer>() {
                    @Override
                    public int compare(Integer a, Integer b) {
                        return a - b;
                    }
                }
        );

        // Sort the intervals by start time.
        Arrays.sort(
                intervals,
                new Comparator<int[]>() {
                    @Override
                    public int compare(int[] a, int[] b) {
                        return a[0] - b[0];
                    }
                }
        );
        // Add the first meeting end time to the heap
        minHeap.add(intervals[0][1]);

        for(int i = 1; i < intervals.length; i++) {
            // If the last used room is free now, then remove it from
            // the heap, and assign the new meeting to it.
            if(intervals[i][0] >= minHeap.peek())
                minHeap.poll();
            // Add the new meeting end time to the heap.
            minHeap.add(intervals[i][1]);
        }
        // The size of the heap will represent the minimum required number
        // of rooms that are needed to handle all the meetings
        return minHeap.size();
    }
}
