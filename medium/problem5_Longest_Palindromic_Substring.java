package medium;

public class problem5_Longest_Palindromic_Substring {
    
    private int startIdx, endIdx;
    private int maxLen;
    
    public static void main(String[] args) {
        problem5_Longest_Palindromic_Substring curProblem = new problem5_Longest_Palindromic_Substring();
        String input = "babad";
        System.out.println(curProblem.longestPalindrome(input));
    }
    
    public String longestPalindrome(String s) {
        if (s.length() < 2) {
            return s;
        }
        
        for (int center = 0; center < s.length() - 1; center++) {
            checkPalindrome(s, center, center);
            checkPalindrome(s, center, center + 1);            
        }
        
        return s.substring(startIdx, endIdx + 1);
    }
    
    private void checkPalindrome(String s, int leftCenter, int rightCenter) {
        int step;
        for (step = 0; leftCenter - step >= 0 && rightCenter + step <= s.length() - 1; step++) {
            if (s.charAt(leftCenter - step) != s.charAt(rightCenter + step)) {
                break;
            }
        }
        step--;
        int curLen = rightCenter - leftCenter + 1 + 2 * step;
        if (curLen > maxLen) {
            maxLen = curLen;
            System.out.println(maxLen);
            startIdx = leftCenter - step;
            endIdx = rightCenter + step;
        }
    }
}
