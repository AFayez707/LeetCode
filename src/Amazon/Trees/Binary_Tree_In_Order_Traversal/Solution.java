package Amazon.Trees.Binary_Tree_In_Order_Traversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
    // Link: https://leetcode.com/problems/binary-tree-inorder-traversal
    // Time: O(N)
    // Space: O(N)
    // Useful Image: https://leetcode.com/problems/validate-binary-search-tree/Figures/145_transverse.png
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            res.add(curr.val);
            curr = curr.right;
        }
        return res;
    }
}
