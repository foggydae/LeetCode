package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class problem46 {
    
    public static void main(String[] args) {
        problem46 curProblem = new problem46();
        int[] nums = new int[3];
        nums[0] = 1;
        nums[1] = 2;
        nums[2] = 3;
        List<List<Integer>> result = curProblem.permute(nums);
        System.out.println(result);
    }
    
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        HashMap<Integer, Boolean> positionTaken = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            positionTaken.put(nums[i], false);
        }
        List<Integer> curPermute = new LinkedList<>();
        recursive_permute(positionTaken, result, curPermute, nums);
        return result;
    }
    
    private void recursive_permute(HashMap<Integer, Boolean> posTaken, 
            List<List<Integer>> result, List<Integer> curPermute, int[] nums) {
        if (curPermute.size() == nums.length) {
            List<Integer> curResult = new LinkedList<>(curPermute);
            result.add(curResult);
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (posTaken.get(nums[i])) {
                continue;
            }
            curPermute.add(nums[i]);
            posTaken.put(nums[i], true);
            recursive_permute(posTaken, result, curPermute, nums);
            curPermute.remove(curPermute.size() - 1);
            posTaken.put(nums[i], false);
        }
        return;
    }

}
