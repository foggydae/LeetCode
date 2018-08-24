package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class problem90 {

    public static void main(String[] args) {
        problem90 curProblem = new problem90();
        int[] nums = new int[3];
        nums[0] = 1;
        nums[1] = 2;
        nums[2] = 2;
        List<List<Integer>> result = curProblem.subsetsWithDup(nums);
        System.out.println(result);
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> curList = new LinkedList<>();
        HashMap<Integer, Boolean> posTaken = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            posTaken.put(i, false);
        }
        backtracking(nums, Integer.MIN_VALUE, posTaken, result, curList);
        return result;
    }
    
    private void backtracking(int[] nums, int lastNum, 
            HashMap<Integer, Boolean> posTaken, List<List<Integer>> result, List<Integer> curList) {
        List<Integer> curResult = new LinkedList<>(curList);
        result.add(curResult);
    
        HashSet<Integer> usedValue = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < lastNum || posTaken.get(i) || usedValue.contains(nums[i])) {
                continue;
            }
            usedValue.add(nums[i]);
            posTaken.put(i, true);
            curList.add(nums[i]);
            backtracking(nums, nums[i], posTaken, result, curList);
            curList.remove(curList.size() - 1);
            posTaken.put(i, false);
        }
    }

}
