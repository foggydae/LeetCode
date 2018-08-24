package hard;

public class problem4 {
    
    public static void main(String[] args) {
        problem4 curProblem = new problem4();
        int[] nums1 = new int[]{1,2};
        int[] nums2 = new int[]{3,4};
        double result = curProblem.findMedianSortedArrays(nums1, nums2);
        System.out.println(result);
    }
    
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double result = 0;
        int partition1;
        int partition2;

        if (nums1.length < nums2.length) {
            partition1 = findPartition(nums1, 0, nums1.length, nums2);
            partition2 = otherPartition(nums1, nums2, partition1);
        } else {
            partition2 = findPartition(nums2, 0, nums2.length, nums1);
            partition1 = otherPartition(nums1, nums2, partition2);
        }

        int[] supportElements1 = getSupportElements(nums1, partition1);
        int[] supportElements2 = getSupportElements(nums2, partition2);
        
        if ((nums1.length + nums2.length) % 2 != 0) {
            result = Integer.max(supportElements1[0], supportElements2[0]);
        } else {
            result = (double)((Integer.max(supportElements1[0], supportElements2[0])) + (Integer.min(supportElements1[1], supportElements2[1]))) / 2;
        }
        
        return result;
    }
    
    private int findPartition(int[] nums1, int low, int high, int[] nums2) {
        int thisPartition = low + (high - low) / 2;
        int anotherPartition = otherPartition(nums1, nums2, thisPartition);

        int[] supportElements1 = getSupportElements(nums1, thisPartition);
        int[] supportElements2 = getSupportElements(nums2, anotherPartition);
        
        if (supportElements1[0] > supportElements2[1]) {
            return findPartition(nums1, low, thisPartition - 1, nums2);
        } else if (supportElements1[1] < supportElements2[0]) {
            return findPartition(nums1, thisPartition + 1, high, nums2);
        } else {
            return thisPartition;
        }
    }
    
    private int otherPartition(int[] nums1, int[] nums2, int partition) {
        return (nums1.length + nums2.length + 1) / 2 - partition;
    }
    
    private int[] getSupportElements(int[] nums, int partition) {
        int smallElement;
        int largeElement;
        if (partition == 0 && partition != nums.length) {
            smallElement = Integer.MIN_VALUE;
            largeElement = nums[partition];
        } else if (partition != 0 && partition == nums.length) {
            smallElement = nums[partition - 1];
            largeElement = Integer.MAX_VALUE;
        } else if (partition == 0 && partition == nums.length) {
            smallElement = Integer.MIN_VALUE;
            largeElement = Integer.MAX_VALUE;
        } else {
            smallElement = nums[partition - 1];
            largeElement = nums[partition];
        }
        int[] result = new int[2];
        result[0] = smallElement;
        result[1] = largeElement;
        return result;
    }
}
