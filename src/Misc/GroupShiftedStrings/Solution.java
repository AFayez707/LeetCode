package Misc.GroupShiftedStrings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    private String calculateHash(String s) {
        StringBuilder hashKey = new StringBuilder();

        for(int i = 1; i < s.length(); i++)
            hashKey.append((char) ((s.charAt(i) - s.charAt(i - 1) + 26) % 26 + 'a') );

        return hashKey.toString();
    }

    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> groupedStringsByHash = new HashMap<>();

        for(String str : strings) {
            String calculatedHash = calculateHash(str);
            if(groupedStringsByHash.get(calculatedHash) == null)
                groupedStringsByHash.put(calculatedHash, new ArrayList<>());
            groupedStringsByHash.get(calculatedHash).add(str);
        }

        List<List<String>> groupedStrings = new ArrayList<>();
        for(List<String> stringList : groupedStringsByHash.values())
            groupedStrings.add(stringList);

        return groupedStrings;
    }
}
