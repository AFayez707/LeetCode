package Amazon.Compare_Version_Numbers;


public class Solution {
    // Link: https://leetcode.com/problems/compare-version-numbers/
    // Time: O(N + M)
    // Space: O(1)
    public int compareVersion(String version1, String version2) {
        for(int v1Pointer = 0, v2Pointer = 0;
            v1Pointer < version1.length() || v2Pointer < version2.length();
            v1Pointer++, v2Pointer++) {
            int v1SubVersion = 0, v2SubVersion = 0;
            while(v1Pointer < version1.length() && version1.charAt(v1Pointer) != '.') {
                v1SubVersion = v1SubVersion * 10 + version1.charAt(v1Pointer) - '0';
                v1Pointer++;
            }

            while(v2Pointer < version2.length() && version2.charAt(v2Pointer) != '.') {
                v2SubVersion = v2SubVersion * 10 + version2.charAt(v2Pointer) - '0';
                v2Pointer++;
            }

            if(v1SubVersion > v2SubVersion)
                return 1;
            if(v2SubVersion > v1SubVersion)
                return -1;
        }
        return 0;
    }
}
