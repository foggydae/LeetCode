package easy;

import java.util.HashMap;

public class problem13_Roman_to_Integer {
    public int romanToInt(String s) {
        HashMap<Character, Integer> valueDict = new HashMap<>();
        valueDict.put('I', 1);
        valueDict.put('V', 5);
        valueDict.put('X', 10);
        valueDict.put('L', 50);
        valueDict.put('C', 100);
        valueDict.put('D', 500);
        valueDict.put('M', 1000);
        
        int prev = 1000;
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            int cur = valueDict.get(s.charAt(i));
            if (prev < cur) {
                result -= 2 * prev;
            }
            result += cur;
            prev = cur;
        }
        return result;
    }
}
