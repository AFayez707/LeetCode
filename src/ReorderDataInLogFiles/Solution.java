package ReorderDataInLogFiles;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {

    public static void main(String[] args) {
        String[] logs = new String[] {"a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"};

        System.out.println(Arrays.toString(new Solution().reorderLogFiles(logs)));
    }

    public String[] reorderLogFiles(String[] logs) {

        Arrays.sort(logs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String key1 = o1.substring(0, o1.indexOf(" "));
                String value1 = o1.substring(key1.length() + 1);
                String key2 = o2.substring(0, o2.indexOf(" "));
                String value2 = o2.substring(key2.length() + 1);
                boolean isDigit1 = Character.isDigit(value1.charAt(0));
                boolean isDigit2 = Character.isDigit(value2.charAt(0));
                if(!isDigit1 && !isDigit2) {
                    if(value1.equals(value2))
                        return key1.compareTo(key2);
                    return value1.compareTo(value2);
                } else if(!isDigit1 && isDigit2) {
                    return -1;
                } else if(isDigit1 && !isDigit2) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });

        return logs;

    }


}
