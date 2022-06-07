package Amazon.Trees_and_Graphs.Validate_Binary_Search_Tree;

import java.util.Stack;

// Link: https://leetcode.com/problems/validate-binary-search-tree/
// Time: O(N)
// Space: O(N)
// Useful Image: https://leetcode.com/problems/validate-binary-search-tree/Figures/145_transverse.png
public class Solution {
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        Stack<TreeNode> stack = new Stack<>();
        Integer previousRootValue = null;

        while(root != null || !stack.isEmpty()) {
            while(root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            // If next element in inOrderTraversal is smaller than
            // or equal the previous one, that means its not BST
            if(previousRootValue != null && root.val <= previousRootValue)
                return false;

            // Go to the right branch
            previousRootValue = root.val;
            root = root.right;
        }

        return true;
    }
}
