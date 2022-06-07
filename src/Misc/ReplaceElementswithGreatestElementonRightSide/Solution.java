package Misc.ReplaceElementswithGreatestElementonRightSide;

public class Solution {
//    Link: https://leetcode.com/problems/replace-elements-with-greatest-element-on-right-side
    public int[] replaceElements(int[] arr) {
        int largestElementSeen = arr[arr.length - 1];
        arr[arr.length - 1] = -1;
        for(int i = arr.length - 2; i >= 0; i--) {
            int currentValue = arr[i];
            arr[i] = largestElementSeen;
            if(currentValue > largestElementSeen)
                largestElementSeen = currentValue;
        }
        return arr;
    }
}
