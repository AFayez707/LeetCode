package Amazon_OA.Count_Max_Teams;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {
    // Link: https://cybergeeksquad.co/2022/02/count-maximum-teams-amazon-oa.html
    // Link: https://leetcode.com/discuss/interview-question/1474497/amazon-oa
    // Time: O(N)
    // Space: O(1)
    public int countMaximumTeams(List<Integer> skills, int teamSize, int maxDiff) {
        int numOfTeams = 0;
        if(skills.size() < teamSize)
            return numOfTeams;

        Collections.sort(skills);

        int i = 0;
        while(i <= skills.size() - teamSize) {
            int differenctBetweenSkills = skills.get(i + teamSize - 1) - skills.get(i);
            if(differenctBetweenSkills <= maxDiff) {
                numOfTeams++;
                i += teamSize;
            } else {
                i++;
            }
        }
        return numOfTeams;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().countMaximumTeams(Arrays.asList(3,4,3,1,6,5), 3, 2));
    }
}
