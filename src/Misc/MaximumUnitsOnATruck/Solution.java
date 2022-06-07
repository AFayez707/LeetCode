package Misc.MaximumUnitsOnATruck;

import java.util.Arrays;

public class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);
        int currentNumberOfItems = 0;
        for(int i = 0; i < boxTypes.length; i++) {
            int numberOfBoxesOfThisCategory = Math.min(truckSize, boxTypes[i][0]);
            currentNumberOfItems += numberOfBoxesOfThisCategory * boxTypes[i][1];
            truckSize -= numberOfBoxesOfThisCategory;

            if(truckSize == 0)
                break;
        }
        return currentNumberOfItems;
    }
}
