package contest;

public class Jun16_1 {

    public static void main(String[] args) {
        int[] A = new int[5];
        Jun16_1 curContest = new Jun16_1();
        A[0] = 1;
        A[1] = 2;
        A[2] = 4;
        A[3] = 3;
        A[4] = 2;
        System.out.println(curContest.peakIndexInMountainArray(A));
    }
    
    public int peakIndexInMountainArray(int[] A) {
        int high = A.length - 1;
        int low = 0;
        int mid = low + (high - low) / 2;
        
        while (true) {
            if (A[mid - 1] < A[mid] && A[mid] < A[mid + 1]) {
                low = mid;
            } else if (A[mid - 1] > A[mid] && A[mid] > A[mid + 1]) {
                high = mid;
            } else {
                break;
            }
            mid = low + (high - low) / 2;
        }
        
        return mid;
    }
}
