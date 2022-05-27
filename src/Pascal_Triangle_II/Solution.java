package Pascal_Triangle_II;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    // Time: O(K^2)
    // Space: O(K)
    // Link: https://leetcode.com/problems/pascals-triangle-ii/
    public List<Integer> getRow(int rowIndex) {
        List<Integer> solution = new ArrayList<Integer>(rowIndex + 1);
        solution.add(1);

        for(int i = 0; i < rowIndex; i++) {
            for(int j = i; j > 0; j--) {
                solution.set(j, solution.get(j) + solution.get(j-1));
            }
            solution.add(1);
        }

        return solution;
    }
}
