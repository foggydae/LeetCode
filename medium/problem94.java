package medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class problem94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> toVisit = new Stack<>();
        TreeNode curNode = root;
        while (curNode != null) {
            toVisit.add(curNode);
            curNode = curNode.left;
        }
        while (!toVisit.isEmpty()) {
            curNode = toVisit.pop();
            result.add(curNode.val);
            curNode = curNode.right;
            while (curNode != null) {
                toVisit.add(curNode);
                curNode = curNode.left;
            }
        }
        return result;
    }
//    Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
