package easy;

public class problem7_Reverse_Integer {
    public int reverse(int x) {
        int reverse = 1;
        if (x < 0) {
            reverse = -1;
            x = -x;
        }
        
        int result = 0;
        
        while (x > 0) {
            try {
                result = Math.multiplyExact(result, 10);
                result = Math.addExact(result, x % 10);
            } catch (Exception e) {
                return 0;
            }
            x /= 10;
        }
        
        return result * reverse;
    }
}
