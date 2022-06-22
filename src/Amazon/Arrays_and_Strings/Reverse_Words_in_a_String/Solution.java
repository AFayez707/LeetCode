package Amazon.Arrays_and_Strings.Reverse_Words_in_a_String;

public class Solution {
    public String reverseWords(String s) {
        // Output String
        StringBuilder solution = trimSpacing(s);

        reverseString(solution);

        reverseEachWord(solution);

        return solution.toString();
    }

    public StringBuilder trimSpacing(String str) {
        int leftPointer = 0;
        int rightPointer = str.length() - 1;

        // Skip left spaces
        while(leftPointer < str.length() && str.charAt(leftPointer) == ' ') leftPointer++;

        // Skip right spaces
        while(rightPointer >= 0 && str.charAt(rightPointer) == ' ') rightPointer--;

        StringBuilder outputWithoutExtraSpacing = new StringBuilder();

        while(leftPointer <= rightPointer) {
            if(str.charAt(leftPointer) != ' ')
                outputWithoutExtraSpacing.append(str.charAt(leftPointer));
            else if(outputWithoutExtraSpacing.charAt(outputWithoutExtraSpacing.length() - 1) != ' ')
                outputWithoutExtraSpacing.append(' ');

            leftPointer++;
        }
        return outputWithoutExtraSpacing;
    }

    public void reverseString(StringBuilder str) {
        int leftPointer = 0;
        int rightPointer = str.length() - 1;
        while(leftPointer < rightPointer) {
            Character temp = str.charAt(leftPointer);
            str.setCharAt(leftPointer++, str.charAt(rightPointer));
            str.setCharAt(rightPointer--, temp);
        }
    }

    public void reverseEachWord(StringBuilder str) {
        int rightPointer = 0;
        for(int leftPointer = 0; leftPointer < str.length(); ) {
            while(rightPointer < str.length() && str.charAt(rightPointer) != ' ') rightPointer++;

            int nextLeftPointer = rightPointer + 1;
            rightPointer--;

            while(leftPointer < rightPointer) {
                Character temp = str.charAt(leftPointer);
                str.setCharAt(leftPointer++, str.charAt(rightPointer));
                str.setCharAt(rightPointer--, temp);
            }

            leftPointer = nextLeftPointer;
            rightPointer = leftPointer;
        }
    }

    public static void main(String[] args) {
        new Solution().reverseWords("            the sky  is     blue    ");
    }
}
