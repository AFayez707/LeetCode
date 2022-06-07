package Misc.ValidMountainArray;

public class Solution {
//    link: https://leetcode.com/problems/valid-mountain-array/
    public boolean validMountainArray(int[] arr) {
        int position = 0;
        // Moving Pointer to the most increasing position
        while(position < arr.length - 1 && arr[position] < arr[position + 1])
            position++;

        // Check if the position is the first or last, if so that means we don't have a top.
        if(position == 0 || position == arr.length - 1)
            return false;

        // Moving Pointer to the most decreasing position
        while(position < arr.length - 1 && arr[position] > arr[position + 1])
            position++;

        System.out.println(position);
        return position == arr.length - 1;
    }
}
