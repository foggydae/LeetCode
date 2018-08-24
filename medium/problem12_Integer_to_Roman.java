package medium;

import java.util.LinkedList;
import java.util.Queue;

public class problem12_Integer_to_Roman {
    public String intToRoman(int num) {
        Queue<Integer> valueQ = new LinkedList<>();
        Queue<String> symbolQ = new LinkedList<>();
        
        valueQ.add(1000);
        symbolQ.add("M");
        valueQ.add(900);
        symbolQ.add("CM");
        valueQ.add(500);
        symbolQ.add("D");
        valueQ.add(400);
        symbolQ.add("CD");
        valueQ.add(100);
        symbolQ.add("C");
        valueQ.add(90);
        symbolQ.add("XC");
        valueQ.add(50);
        symbolQ.add("L");
        valueQ.add(40);
        symbolQ.add("XL");
        valueQ.add(10);
        symbolQ.add("X");
        valueQ.add(9);
        symbolQ.add("IX");
        valueQ.add(5);
        symbolQ.add("V");
        valueQ.add(4);
        symbolQ.add("IV");
        valueQ.add(1);
        symbolQ.add("I");
        
        StringBuilder result = new StringBuilder();
        int curValue;
        int numOfSymbol = symbolQ.size();
        String curSymbol;
        
        for (int i = 0; i < numOfSymbol; i++) {
            
            curValue = valueQ.poll();
            curSymbol = symbolQ.poll();
            
            while (num >= curValue) {
                result.append(curSymbol);
                num -= curValue;
            }
            
            if (num == 0) {
                break;
            }
        }
        
        return result.toString();
    }
}
