package DuplicateZeros;

import java.util.Arrays;

class Solution {
    public void duplicateZeros(int[] arr) {
        int numberOfZeros = 0;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == 0)
                numberOfZeros++;
        }
        int requiredArraySize = arr.length + numberOfZeros;
        int correspondingArrayPosition = requiredArraySize - 1;
        for(int originalIndex = arr.length - 1; originalIndex >= 0; originalIndex--) {
            // TODO: Code Optimization
            if(arr[originalIndex] == 0) {
                if(correspondingArrayPosition <= arr.length - 1) {
                    arr[correspondingArrayPosition] = 0;
                }
                correspondingArrayPosition--;
                if(correspondingArrayPosition <= arr.length - 1) {
                    arr[correspondingArrayPosition] = 0;
                }
                correspondingArrayPosition--;
            } else {
                if(correspondingArrayPosition <= arr.length - 1) {
                    arr[correspondingArrayPosition] = arr[originalIndex];
                }
                correspondingArrayPosition--;
            }
        }
    }
}