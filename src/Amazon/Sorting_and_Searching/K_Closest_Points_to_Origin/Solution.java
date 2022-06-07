package Amazon.Sorting_and_Searching.K_Closest_Points_to_Origin;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    // First Approach Sort based on custom comparator
    // Time: O(N LOG N)
    // Space: O(LOG N) TO O(N) REQUIRED BY SORTING ALGO
//    public int[][] kClosest(int[][] points, int k) {
//        // Sort the array with a custom lambda comparator function
//        Arrays.sort(points, (a, b) -> squaredDistance(a) - squaredDistance(b));
//
//        // Return the first k elements of the sorted array
//        return Arrays.copyOf(points, k);
//    }

    // Better Approach
    // Time: O(N LOG K)
    // Space: O(K)

    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<int[]> heap = new PriorityQueue<int[]>(new Comparator<int[]>() {
            @Override
            public int compare(int[] firstPoint, int[] secondPoint) {
                return squaredDistance(secondPoint) - squaredDistance(firstPoint);
            }
        });

        for (int[] point: points) {
            heap.add(point);
            if (heap.size() > K)
                heap.poll();
        }

        int[][] result = new int[K][2];
        while (K > 0)
            result[--K] = heap.poll();

        return result;
    }

    private int squaredDistance(int[] point) {
        // Calculate and return the squared Euclidean distance
        return point[0] * point[0] + point[1] * point[1];
    }
}
