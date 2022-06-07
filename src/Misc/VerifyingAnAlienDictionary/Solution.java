package Misc.VerifyingAnAlienDictionary;

import java.util.HashMap;
import java.util.Objects;

public class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        HashMap <Character, Integer> characterOrder = new HashMap<>();
        for(int i = 0; i < order.length(); i++) {
            characterOrder.put(order.charAt(i), i);
        }

        for(int i = 0; i < words.length - 1; i++) {
            for(int j = 0; j < words[i].length(); j++) {
                if(words[i + 1].length() <= j) {
                    return false;
                }
                if(characterOrder.get(words[i].charAt(j)) > characterOrder.get(words[i + 1].charAt(j))) {
                    return false;
                } else if (Objects.equals(characterOrder.get(words[i].charAt(j)), characterOrder.get(words[i + 1].charAt(j)))) {
                    continue;
                } else {
                    break;
                }
            }
        }
        return true;
    }
}
