package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class problem47 {
    
    public static void main(String[] args) {
        problem47 curProblem = new problem47();
        int[] nums = new int[3];
        nums[0] = 1;
        nums[1] = 1;
        nums[2] = 3;
        List<List<Integer>> result = curProblem.permuteUnique(nums);
        System.out.println(result);
    }
    
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        HashMap<Integer, Boolean> posFlag = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            posFlag.put(i, false);
        }
        List<Integer> curPermute = new LinkedList<>();
        recursivePermuteUnique(posFlag, result, curPermute, nums);
        return result;
    }
    
    private void recursivePermuteUnique(HashMap<Integer, Boolean> posTaken, 
            List<List<Integer>> result, List<Integer> curPermute, int[] nums) {
        if (curPermute.size() == nums.length) {
            List<Integer> curResult = new LinkedList<>(curPermute);
            result.add(curResult);
            return;
        }
        HashSet<Integer> valueSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (posTaken.get(i) || valueSet.contains(nums[i])) {
                continue;
            }
            valueSet.add(nums[i]);
            curPermute.add(nums[i]);
            posTaken.put(i, true);
            recursivePermuteUnique(posTaken, result, curPermute, nums);
            curPermute.remove(curPermute.size() - 1);
            posTaken.put(i, false);
        }
    }

}
