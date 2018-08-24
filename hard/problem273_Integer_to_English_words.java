package hard;

import java.util.HashMap;

public class problem273_Integer_to_English_words {
    
    public static void main(String[] args) {
        int num = 100000000;
        problem273_Integer_to_English_words curProblem = new problem273_Integer_to_English_words();
        System.out.println("'" + curProblem.numberToWords(num) + "'");
    }
    
    public String numberToWords(int num) {
        String result = "";
        
        if (num / 1000000000 > 0) {
            int bValue = num / 1000000000;
            result += hundredLevelTrans(bValue) + " Billion";
            num = num % 1000000000;
            if (num == 0) {
                return result;
            } else {
                result += " ";
            }
        }
        if (num / 1000000 > 0) {
            int bValue = num / 1000000;
            result += hundredLevelTrans(bValue) + " Million";
            num = num % 1000000;
            if (num == 0) {
                return result;
            } else {
                result += " ";
            }
        }
        if (num / 1000 > 0) {
            int bValue = num / 1000;
            result += hundredLevelTrans(bValue) + " Thousand";
            num = num % 1000;
            if (num == 0) {
                return result;
            } else {
                result += " ";
            }
        }
        result += hundredLevelTrans(num);
        
        return result;
    }
    
    private String hundredLevelTrans(int num) {
        
        if (num == 0) {
            return "Zero";
        }
        
        HashMap<Integer, String> digits = new HashMap<>();
        HashMap<Integer, String> tensdigits = new HashMap<>();
        
        digits.put(0, "");
        digits.put(1, "One");
        digits.put(2, "Two");
        digits.put(3, "Three");
        digits.put(4, "Four");
        digits.put(5, "Five");
        digits.put(6, "Six");
        digits.put(7, "Seven");
        digits.put(8, "Eight");
        digits.put(9, "Nine");
        digits.put(10, "Ten");
        digits.put(11, "Eleven");
        digits.put(12, "Twelve");
        digits.put(13, "Thirteen");
        digits.put(14, "Fourteen");
        digits.put(15, "Fifteen");
        digits.put(16, "Sixteen");
        digits.put(17, "Seventeen");
        digits.put(18, "Eighteen");
        digits.put(19, "Nineteen");
        
        tensdigits.put(0, "");
        tensdigits.put(1, "");
        tensdigits.put(2, "Twenty");
        tensdigits.put(3, "Thirty");
        tensdigits.put(4, "Forty");
        tensdigits.put(5, "Fifty");
        tensdigits.put(6, "Sixty");
        tensdigits.put(7, "Seventy");
        tensdigits.put(8, "Eighty");
        tensdigits.put(9, "Ninety");
 
        String result = "";
        
        if (num / 100 > 0) {
            int hundredDigit = num / 100;
            result += digits.get(hundredDigit) + " Hundred";
            num = num % 100;
            if (num != 0) {
                result += " ";
            }
        }
                
        if (num / 10 > 1) {
            int tenDigit = num / 10;
            result += tensdigits.get(tenDigit);
            num = num % 10;
            if (num != 0) {
                result += " ";
            }
            result += digits.get(num);
        } else {
            result += digits.get(num);
        }
        
        return result;
    }
}
