package Amazon_OA.Maximum_Units_on_a_Truck;

import java.util.Arrays;

// Link: https://leetcode.com/problems/maximum-units-on-a-truck
// Space: O(1)
// Time: O(N*Log(N))

public class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        // Sort the boxTypes array based on the number of items
        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);
        int currentNumberOfItems = 0;
        for(int i = 0; i < boxTypes.length; i++) {
            int numOfBoxesOfThisCategory = Math.min(truckSize, boxTypes[i][0]);
            currentNumberOfItems += numOfBoxesOfThisCategory * boxTypes[i][1];
            truckSize -= numOfBoxesOfThisCategory;

            if(truckSize == 0)
                break;
        }
        return currentNumberOfItems;
    }
}
