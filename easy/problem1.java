package easy;

import java.util.HashMap;

public class problem1 {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        HashMap<Integer, Integer> value2Index = new HashMap<>();
        int tmpComplement;
        for (int i = 0; i < nums.length; i++) {
            tmpComplement = target - nums[i];
            if (value2Index.containsKey(tmpComplement)) {
                result[0] = value2Index.get(tmpComplement);
                result[1] = i;
                break;
            }
            value2Index.put(nums[i], i);
        }
        return result;
    }
}
