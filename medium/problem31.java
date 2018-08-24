package medium;

import java.util.Arrays;

public class problem31 {
    public static void main(String[] args) {
        problem31 curProblem = new problem31();
        int[] nums = new int[3];
        nums[0] = 1;
        nums[1] = 1;
        nums[2] = 5;
//        nums[3] = 6;
//        nums[4] = 2;
        curProblem.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void nextPermutation(int[] nums) {
        int i = nums.length - 1;
        while (i > 0 && nums[i] < nums[i - 1]) {
            i--;
        }
        if (i == 0) {
            Arrays.sort(nums, i, nums.length);
        } else if (i == nums.length - 1) {
            swap(nums, i, i - 1);
        } else {
            int j = i;
            while (j < nums.length && nums[j] > nums[i - 1]) {
                j++;
            }
            if (nums[j] <= nums[i - 1]) {
                j--;
            }
            swap(nums, i - 1, j);
            Arrays.sort(nums, i, nums.length);
        }
    }
    
    private void swap(int[] nums, int one, int two) {
        int tmp = nums[one];
        nums[one] = nums[two];
        nums[two] = tmp;
    }
}
