package Amazon.Arrays_and_Strings.Implement_strStr;

public class Solution {
    // Link: https://leetcode.com/problems/implement-strstr/
    public int strStr(String haystack, String needle) {
        if(needle == null || needle.length() == 0)
            return 0;

        if(needle.length() > haystack.length())
            return -1;

        for(int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            String subStr = haystack.substring(i, i + needle.length());
            if(subStr.equals(needle))
                return i;
        }
        return -1;
    }
}
