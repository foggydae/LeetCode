package hard;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class problem145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> toVisit = new Stack<>();
        TreeNode curNode = root;
        while (curNode != null) {
            toVisit.add(curNode);
            if (curNode.left != null) {
                curNode = curNode.left;                
            } else {
                curNode = curNode.right;
            }
        }
        while (!toVisit.isEmpty()) {
            curNode = toVisit.pop();
            result.add(curNode.val);
            if (!toVisit.isEmpty() && toVisit.peek().right != curNode) {
                curNode = toVisit.peek().right;
                while (curNode != null) {
                    toVisit.add(curNode);
                    if (curNode.left != null) {
                        curNode = curNode.left;                
                    } else {
                        curNode = curNode.right;
                    }
                }
            }
        }
        return result;
    }

//     Definition for a binary tree node.
     public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
     }
}

