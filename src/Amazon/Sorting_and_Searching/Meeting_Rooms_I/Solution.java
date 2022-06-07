package Amazon.Sorting_and_Searching.Meeting_Rooms_I;

import java.util.Arrays;

// Time: O(N LOG N)
// Space: Sorting Algorithm O(LOG N)
public class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        for (int i = 0; i < intervals.length - 1; i++) {
            if (intervals[i][1] > intervals[i + 1][0]) {
                return false;
            }
        }
        return true;
    }
}
