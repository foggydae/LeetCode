package medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class problem77 {

    public static void main(String[] args) {
        problem77 curProblem = new problem77();
        int n = 4;
        int k = 3;
        List<List<Integer>> result = curProblem.combine(n, k);
        System.out.println(result);
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> curCombine = new LinkedList<>();
        recursiveCombine(n, k, 0, result, curCombine);
        return result;
    }
    
    private void recursiveCombine(int n, int k, int lastOne,
            List<List<Integer>> result, List<Integer> curCombine) {
        if (curCombine.size() == k) {
            List<Integer> curResult = new LinkedList<>(curCombine);
            result.add(curResult);
            return;
        }
        for (int i = lastOne + 1; i <= n; i++) {
            curCombine.add(i);
            recursiveCombine(n, k, i, result, curCombine);
            curCombine.remove(curCombine.size() - 1);
        }
    }

}
