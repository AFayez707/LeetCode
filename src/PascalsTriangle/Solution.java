package PascalsTriangle;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<List<Integer>>(numRows);

        // Base Case
        result.add(new ArrayList<>());
        result.get(0).add(1);

        for(int i = 1; i < numRows; i++) {
            List<Integer> currentRow = new ArrayList<>(i + 1);
            List<Integer> previousRow = result.get(i - 1);
            // initialize the first element with 1, it's always 1
            currentRow.add(1);
            for(int j = 1; j < i; j++) {
                currentRow.add(previousRow.get(j - 1) + previousRow.get(j));
            }
            currentRow.add(1);
            result.add(currentRow);
        }
        return result;
    }
}
