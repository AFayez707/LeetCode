package Amazon.Arrays_and_Strings.Most_Common_Word;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//    Link: https://leetcode.com/problems/most-common-word
//    Time: O(N + M)
//    Space: O(N + M)
public class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> bannedWords = new HashSet<>();
        for(String bannedWord : banned)
            bannedWords.add(bannedWord);

        Map<String, Integer> wordsCounter = new HashMap<>();
        int paragraphLength = paragraph.length();
        int leftPointer = 0;
        
        int mostWordCounter = 0;
        String mostWord = null;
        
        while(leftPointer < paragraphLength) {
            int rightPointer = leftPointer + 1;
            while(rightPointer < paragraphLength && Character.isLetter(paragraph.charAt(rightPointer)))
                rightPointer++;
            
            String currentWord = paragraph.substring(leftPointer, rightPointer).toLowerCase();
            
            if(!bannedWords.contains(currentWord)) {
                int newWordCount = wordsCounter.getOrDefault(currentWord, 0) + 1;
                wordsCounter.put(currentWord, newWordCount);
                if(newWordCount > mostWordCounter) {
                    mostWord = currentWord;
                    mostWordCounter = newWordCount;
                }
            }
            
            leftPointer = rightPointer + 1;
            while(leftPointer < paragraphLength && !Character.isLetter(paragraph.charAt(leftPointer)))
                leftPointer++;
        }
        return mostWord;
    }
}
