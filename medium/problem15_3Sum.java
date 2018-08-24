package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class problem15_3Sum {
    
    List<List<Integer>> result;
    
    public List<List<Integer>> threeSum(int[] nums) {
        result = new ArrayList<>();
        Arrays.sort(nums);
        HashSet<Integer> processed = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            int curValue = nums[i];
            if (curValue > 0) {
                break;
            }
            if (processed.contains(curValue)) {
                continue;
            }
            twoSum(nums, i, curValue);
            processed.add(curValue);
        }
        return result;
    }
    
    private void twoSum(int[] nums, int startIdx, int curValue) {
        HashMap<Integer, Integer> diffMap = new HashMap<>();
        HashSet<Integer> processed = new HashSet<>();
        for (int i = startIdx + 1; i < nums.length; i++) {
            if (processed.contains(nums[i])) {
                continue;
            }
            if (diffMap.containsKey(nums[i])) {
                result.add(new ArrayList<Integer>(Arrays.asList(curValue, nums[i], diffMap.get(nums[i]))));
                processed.add(nums[i]);
            }
            int curDiff = 0 - curValue - nums[i];
            if (diffMap.containsKey(curDiff)) {
                continue;
            } else {
                diffMap.put(curDiff, nums[i]);
            }
        }
    }
    

}
