package medium;

import java.util.HashMap;

public class problem3 {
    
    public static void main(String[] args) {
        problem3 curProblem = new problem3();
        String aString = "abba";
        int result = curProblem.lengthOfLongestSubstring(aString);
        System.out.println(result);
    }

    public int lengthOfLongestSubstring(String s) {
        int startIndex = 0;
        int endIndex;
        int strLength = 0;
        HashMap<Character, Integer> charPosMap = new HashMap<>();
        for (endIndex = 0; endIndex < s.length(); endIndex ++) {
            char curChar = s.charAt(endIndex);
            if (charPosMap.containsKey(curChar)) {
                if (startIndex < charPosMap.get(curChar) + 1) {
                    startIndex = charPosMap.get(curChar) + 1;                    
                }
            }
            charPosMap.put(curChar, endIndex);
            if (endIndex - startIndex + 1 > strLength) {
                strLength = endIndex - startIndex + 1;
            }
        }
        return strLength;
    }
}
