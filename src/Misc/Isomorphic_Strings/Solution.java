package Misc.Isomorphic_Strings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> mapping = new HashMap<>();
        Set<Character> assignedValues = new HashSet<>();

        for(int i = 0; i < s.length(); i++) {
            Character sChar = s.charAt(i);
            Character tChar = t.charAt(i);
            Character mappingChar = mapping.get(sChar);
            if(mappingChar != null && mappingChar != tChar)
                return false;
            if(mappingChar == null && assignedValues.contains(tChar))
                return false;
            mapping.put(sChar, tChar);
            assignedValues.add(tChar);
        }
        return true;
    }
}
