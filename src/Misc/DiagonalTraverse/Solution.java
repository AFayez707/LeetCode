package Misc.DiagonalTraverse;

public class Solution {
    enum Direction {
        UP,
        DOWN
    }

    public int[] findDiagonalOrder(int[][] matrix) {
        if(matrix == null || matrix.length == 0)
            return new int[0];

        // Initializing these variables
        int numOfRows = matrix.length;
        int numOfColumns = matrix[0].length;

        // Starting Position
        int currentRow = 0;
        int currentColumn = 0;

        // Start with UP Direction
        Direction direction = Direction.UP;

        // Result Array and the current element Index
        int[] result = new int[numOfRows * numOfColumns];
        int currentIndex = 0;

        while(currentRow < numOfRows && currentColumn < numOfColumns) {
            result[currentIndex++] = matrix[currentRow][currentColumn];

            // Updating the new Row and New Column (Expected Ones)
            int newRow = currentRow + (direction == Direction.UP ? -1 : 1);
            int newColumn = currentColumn + (direction == Direction.UP ? 1 : -1);

            // Check if the newRow or NewColumn are out of bounds
            if(newRow < 0 || newRow == numOfRows || newColumn < 0 || newColumn == numOfColumns) {
                // If the direction is UP, we have two conditions, same for the DOWN direction
                if(direction == Direction.UP) {
                    currentRow += (currentColumn == numOfColumns - 1 ? 1 : 0);
                    currentColumn += (currentColumn < numOfColumns - 1 ? 1 : 0);
                } else {
                    currentColumn += (currentRow == numOfRows - 1 ? 1 : 0);
                    currentRow += (currentRow < numOfRows - 1 ? 1 : 0);
                }
                // flip the direction
                direction = (direction == Direction.UP) ? Direction.DOWN : Direction.UP;
            } else {
                // assign the new row, column to the current.
                currentRow = newRow;
                currentColumn = newColumn;
            }
        }
        return result;
    }
}
