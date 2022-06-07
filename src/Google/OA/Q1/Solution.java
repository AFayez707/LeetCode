package Google.OA.Q1;

import java.util.HashMap;
import java.util.HashSet;

public class Solution {
    public static int solution(int[] A) {
        HashMap<Integer, Integer> numberOccurrences = new HashMap<>();

        int numberOfDistinctNumbers = 0;

        for(int i = 0; i < A.length; i++) {
            if(!numberOccurrences.containsKey(A[i])) {
                numberOfDistinctNumbers++;
                numberOccurrences.put(A[i], 1);
            } else {
                numberOccurrences.put(A[i], numberOccurrences.get(A[i]) + 1);
            }
        }

        if(numberOfDistinctNumbers == A.length)
            return numberOfDistinctNumbers;

        HashSet<Integer> reversed = new HashSet<>();

//        for(Map.Entry<Integer, Integer> entry : numberOccurrences.entrySet()) {
//            if(entry.getValue() == 1)
//                continue;
//
//            int originalNumber = entry.getKey();
//            int reversedNumber = reverseNumber(originalNumber);
//
//            if(!numberOccurrences.containsKey(reversedNumber) && !reversed.contains(reversedNumber)) {
//                reversed.add(reversedNumber);
//                numberOfDistinctNumbers++;
//            }
//        }

        for(Integer a : numberOccurrences.keySet()) {
            if(numberOccurrences.get(a) == 1)
                continue;

            int originalNumber = a;
            int reversedNumber = reverseNumber(originalNumber);

            if(!numberOccurrences.containsKey(reversedNumber) && !reversed.contains(reversedNumber)) {
                reversed.add(reversedNumber);
                numberOfDistinctNumbers++;
            }
        }


        return numberOfDistinctNumbers;
    }

    public static int reverseNumber(int originalNumber) {
        int reversedNumber = 0;

        while(originalNumber != 0) {
            int currentDigit = originalNumber % 10;
            reversedNumber = reversedNumber * 10 + currentDigit;
            originalNumber /= 10;
        }
        return reversedNumber;
    }

        public static void main(String[] args) {
        System.out.println(solution(new int[]{15, 21, 50, 50}));
            System.out.println(solution(new int[]{21, 99, 99, 21, 12}));
            System.out.println(solution(new int[]{15,50,17,17,50}));
            System.out.println(solution(new int[]{41,33,33,41,14}));
            System.out.println(solution(new int[]{}));
            System.out.println(solution(new int[]{1,1,1,1,1,10}));
    }

}
