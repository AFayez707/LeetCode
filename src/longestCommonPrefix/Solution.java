package longestCommonPrefix;

public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0)
            return null;

        String prefix = strs[0];

        for(int i = 1; i < strs.length; i++) {
            while(strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if(prefix == "") {
                    return "";
                }
            }
        }
        return prefix;

//        StringBuilder prefixString = new StringBuilder();
//        int smallestLength = Integer.MAX_VALUE;
//        for(String str : strs) {
//            if(str.length() < smallestLength) {
//                smallestLength = str.length();
//            }
//        }
//
//        for(int i = 0; i < smallestLength; i++) {
//            Character currentChar = strs[0].charAt(i);
//            boolean allAreTheSame = true;
//            for(String str : strs) {
//                if(str.charAt(i) != currentChar) {
//                    allAreTheSame = false;
//                    break;
//                }
//            }
//            if(allAreTheSame) {
//                prefixString.append(currentChar);
//            } else {
//                break;
//            }
//        }
//        return prefixString.toString();

    }
}
