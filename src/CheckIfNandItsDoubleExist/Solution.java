package CheckIfNandItsDoubleExist;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;

public class Solution {
    public boolean checkIfExist(int[] arr) {
        HashSet<Integer> numsHashTable = new HashSet<>();
        for(int num : arr) {
            if(numsHashTable.contains(num * 2)
            || (num%2 == 0 && numsHashTable.contains(num / 2) ) ) {
                return true;
            }
            numsHashTable.add(num);
        }
        return false;
    }
}
