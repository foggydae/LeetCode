package hard;

public class problem72_Edit_Distance {
    public int minDistance(String word1, String word2) {
        
        int length1 = word1.length();
        int length2 = word2.length();
        
        int[] result = new int[length1 + 1];
        for (int i = 0; i <= length1; i++) {
            result[i] = i;
        }
        
        int preDiag, diaStep, curValue;
        for (int i = 0; i < length2; i++) {
            preDiag = result[0];
            result[0] += 1;
            for (int j = 0; j < length1; j++) {
                if (word1.charAt(j) == word2.charAt(i)) {
                    diaStep = 0;
                } else {
                    diaStep = 1;
                }
                curValue = result[j+1];
                result[j+1] = Math.min(Math.min(result[j], result[j+1]) + 1, preDiag + diaStep);
                preDiag = curValue;
            }
        }
        
        return result[length1];
    }
}
