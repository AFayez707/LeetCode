package Amazon_OA.Maximum_Average_Pass_Ratio;

import java.util.Comparator;
import java.util.PriorityQueue;

// Link: https://leetcode.com/problems/maximum-average-pass-ratio/
// Time:
// Space: O(K*N*Log(N)) Where: K is the number of extra students, N is the Number of classes.

public class Solution {
    // Link: https://leetcode.com/problems/maximum-average-pass-ratio/
    // Time:
    // Space: O(K*N*Log(N)) Where: K is the number of extra students, N is the Number of classes.
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<double[]> priorityQueue = new PriorityQueue<>(
                new Comparator<double[]>() {
                    @Override
                    public int compare(double[] o1, double[] o2) {
                        double o1Difference = (o1[0] + 1) / (o1[1] + 1) - (o1[0]) / (o1[1]);
                        double o2Difference = (o2[0] + 1) / (o2[1] + 1) - (o2[0]) / (o2[1]);
                        if(o1Difference == o2Difference) return 0;
                        return o1Difference > o2Difference ? -1 : 1;
                    }
                }
        );

        for(int[] oneClass : classes) {
            priorityQueue.add(new double[]{oneClass[0], oneClass[1]});
        }

        for(int i = 0; i < extraStudents; i++) {
            double[] curr = priorityQueue.poll();
            priorityQueue.add(new double[]{curr[0] + 1, curr[1] + 1});
        }

        double sum = 0;
        while(!priorityQueue.isEmpty()) {
            double[] c = priorityQueue.poll();
            sum += c[0]/c[1];
        }

        return sum / classes.length;
    }
}
