package easy;

public class problem67 {
    public String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        
        int lenA = a.length() - 1;
        int lenB = b.length() - 1;
        int increment = 0;
        
        int numA = 0;
        int numB = 0;
        
        for (int i = 0; lenA - i >= 0 || lenB - i >= 0 || increment != 0; i++) {
            if (lenA - i >= 0) {
                numA = Character.getNumericValue(a.charAt(lenA - i));
            } else {
                numA = 0;
            }
            
            if (lenB - i >= 0) {
                numB = Character.getNumericValue(b.charAt(lenB - i));
            } else {
                numB = 0;
            }
            
            int curSum = numA + numB + increment;
            if (curSum >= 2) {
                result.append(curSum - 2);
                increment = 1;
            } else {
                result.append(curSum);
                increment = 0;
            }
        }
        
        return result.reverse().toString();
    }

}
