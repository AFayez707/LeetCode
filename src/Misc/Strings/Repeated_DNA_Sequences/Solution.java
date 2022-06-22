package Misc.Strings.Repeated_DNA_Sequences;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Solution {
    // Link: https://leetcode.com/problems/repeated-dna-sequences/
    // Time: O((N-L)*L)
    // SpaceL O((N-L)*L)
    public List<String> findRepeatedDnaSequences(String s) {
        int L = 10, n = s.length();
        HashSet<String> seen = new HashSet(), output = new HashSet();

        // iterate over all sequences of length L
        for (int start = 0; start < n - L + 1; ++start) {
            String tmp = s.substring(start, start + L);
            if (seen.contains(tmp)) output.add(tmp);
            seen.add(tmp);
        }
        return new ArrayList<String>(output);
    }
}
