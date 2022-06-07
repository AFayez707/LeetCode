package Google.OA.Q2;

public class Solution {
    public static int solution(int N) {
        char[] numberArray = String.valueOf(N).toCharArray();
        int len = numberArray.length;

        int[] rightMax = new int[len];
        rightMax[len - 1] = len - 1;

        for(int i = len - 2; i >=0 ; i--) {
            if(numberArray[i] > numberArray[rightMax[i + 1]]) {
                rightMax[i] = i;
            } else {
                rightMax[i] = rightMax[i+1];
            }
        }

        for(int i = 0; i < len; i++) {
            if(numberArray[rightMax[i]] != numberArray[i]) {
                reverse(numberArray, i, rightMax[i]);
                break;
            }
        }

        return Integer.parseInt(String.valueOf(numberArray));
    }


//    public static int solution(int N) {
//        char[] num = String.valueOf(N).toCharArray();
//        int len = num.length;
//        int[] rightMax = new int[len];
//        rightMax[len - 1] = len - 1;
//        for(int i = len - 2; i >=0 ; i--) {
//            if(num[i] > num[rightMax[i + 1]]) {
//                rightMax[i] = i;
//            } else {
//                rightMax[i] = rightMax[i+1];
//            }
//        }
//        for(int i = 0; i < len; i++) {
//            if(num[rightMax[i]] != num[i]) {
//                reverse(num, i, rightMax[i]);
//                break;
//            }
//        }
//        return Integer.parseInt(String.valueOf(num));
//    }


    public static void reverse(char[] num, int leftPointer, int rightPointer) {
        while(leftPointer < rightPointer) {
            char temp = num[leftPointer];
            num[leftPointer] = num[rightPointer];
            num[rightPointer] = temp;
            leftPointer++;
            rightPointer--;
        }
    }

    public static void main(String[] args) {
        System.out.println(solution(5340));
        System.out.println(solution(2043));
        System.out.println(solution(620));
        System.out.println(solution(111));
        System.out.println(solution(10111));
        System.out.println(solution(99999998));
        System.out.println(solution(999999989));
        System.out.println(solution(899999998));
        System.out.println(solution(89999999));
        System.out.println(solution(898));
        System.out.println(solution(8898));
        System.out.println(solution(88998));
    }
}
