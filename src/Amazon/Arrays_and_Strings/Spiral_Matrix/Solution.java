package Amazon.Arrays_and_Strings.Spiral_Matrix;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int numOfRows = matrix.length;
        int numOfColumns = matrix[0].length;
        List<Integer> result = new ArrayList<Integer>(numOfRows * numOfColumns);

        int upBoundry = 0;
        int downBoundry = numOfRows - 1;
        int leftBoundry = 0;
        int rightBoundry = numOfColumns - 1;

        int currentIndex = 0;

        while(result.size() < numOfRows * numOfColumns) {
            // go right
            for(int column = leftBoundry; column <= rightBoundry; column++)
                result.add(matrix[upBoundry][column]);
            // go down
            for(int row = upBoundry + 1; row <= downBoundry; row++)
                result.add(matrix[row][rightBoundry]);

            // go left, we need to check if the row is different from the previous one
            if(upBoundry != downBoundry)
                for(int column = rightBoundry - 1; column >= leftBoundry; column--)
                    result.add(matrix[downBoundry][column]);

            // go left, we need to check if the column is different from the previous one
            if(leftBoundry != rightBoundry)
                for(int row = downBoundry - 1; row > upBoundry; row--)
                    result.add(matrix[row][leftBoundry]);

            upBoundry++;
            rightBoundry--;
            downBoundry--;
            leftBoundry++;
        }

        return result;
    }
}
