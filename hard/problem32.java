package hard;

import java.util.Stack;

public class problem32 {

    public static void main(String[] args) {
        problem32 thisProblem = new problem32();
        String string = ")()())()()(";
        System.out.println(thisProblem.longestValidParentheses(string));
    }
    
    public int longestValidParentheses(String s) {
        int maxLength = 0;
        Stack<Integer> potentialAddOn = new Stack<>();
        Stack<Integer> endLeft = new Stack<>();
        int curComplete = 0;
        int curEndCount = 0;
        
        for (int i = s.length() - 1; i >= 0; i--) {
            char curChar = s.charAt(i);
            if (curChar == ')') {
                if (curComplete > 0) {
                    endLeft.push(curEndCount);
                    potentialAddOn.push(curComplete);
                    curComplete = 0;
                    curEndCount = 1;
                } else {
                    curEndCount += 1;
                }
            } else { // curChar == '('
                if (curEndCount == 0) {
                    potentialAddOn.clear();
                    endLeft.clear();
                    curComplete = 0;
                } else { // currently, there are ')'s that haven't been paired
                    curComplete += 1;
                    curEndCount -= 1;
                    if (curComplete > maxLength) {
                        maxLength = curComplete;
                    }
                    if (curEndCount == 0 && !potentialAddOn.isEmpty()) {
                        curComplete += potentialAddOn.pop();
                        curEndCount = endLeft.pop();
                        if (curComplete > maxLength) {
                            maxLength = curComplete;
                        }
                    }
                }
            }
        }
        return 2 * maxLength;
    }
}
