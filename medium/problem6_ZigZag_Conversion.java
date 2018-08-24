package medium;

public class problem6_ZigZag_Conversion {
    public String convert(String s, int numRows) {
        if (s.length() <= numRows) {
            return s;
        }
        
        int interval = 2 * (numRows - 1);
        String result = "";
        int pointer;
        for (int i = 0; i < numRows; i++) {
            pointer = i;
            while(pointer < s.length()) {
                result += s.charAt(pointer);
                if (i == 0 || i == numRows - 1) {
                    pointer += interval;
                } else {
                    pointer += interval - i * 2;
                    if (pointer >= s.length()) {
                        break;
                    } else {
                        result += s.charAt(pointer);
                        pointer += i * 2;
                    }
                }
            }
        }
        return result;
    }
}
