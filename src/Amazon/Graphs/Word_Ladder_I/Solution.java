package Amazon.Graphs.Word_Ladder_I;

import java.util.*;
// Link: https://leetcode.com/problems/word-ladder
// Time: O(M^2 * N) Where M: Length of the word, N: Size of wordList
// Space: O(M * N) Where M: Length of the word, N: Size of wordList

public class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // Adding all words to the set to provide O(K) access time, K is the length of the word
        Set<String> allWordsSet = new HashSet<>(wordList);

        // if allWordsSet doesn't contain the word, so we can never be able to reach it.
        if(!allWordsSet.contains(endWord)) return 0;

        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);

        Set<String> visitedWords = new HashSet<>();
        visitedWords.add(beginWord);

        int numberOfChanges = 1;

        // BFS
        while(!queue.isEmpty()) {
            int queueSize = queue.size();

            for(int i = 0; i < queueSize; i++) {
                String currentWord = queue.poll();
                if(endWord.equals(currentWord))
                    return numberOfChanges;

                for(int j = 0; j < currentWord.length(); j++) {
                    for(int k = 'a'; k <= 'z'; k++) {
                        char wordCharArray[] = currentWord.toCharArray();

                        wordCharArray[j] = (char) k;

                        String currentWordAsString = new String(wordCharArray);

                        if(allWordsSet.contains(currentWordAsString) && !visitedWords.contains(currentWordAsString)) {
                            queue.add(currentWordAsString);
                            visitedWords.add(currentWordAsString);
                        }
                    }
                }
            }
            numberOfChanges++;
        }
        return 0;
    }
}
