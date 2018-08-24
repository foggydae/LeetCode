package medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Subset I
 * @author ren.zuo
 *
 */
public class problem78 {
    
    public static void main(String[] args) {
        problem78 curProblem = new problem78();
        int[] nums = new int[3];
        nums[0] = 1;
        nums[1] = 2;
        nums[2] = 3;
        List<List<Integer>> result = curProblem.subsets(nums);
        System.out.println(result);
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> curList = new LinkedList<>();
        backtracking(nums, Integer.MIN_VALUE, result, curList);
        return result;
    }
    
    private void backtracking(int[] nums, int lastNum, List<List<Integer>> result, List<Integer> curList) {
        List<Integer> curResult = new LinkedList<>(curList);
        result.add(curResult);
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= lastNum) {
                continue;
            }
            curList.add(nums[i]);
            backtracking(nums, nums[i], result, curList);
            curList.remove(curList.size() - 1);
        }
    }
}
