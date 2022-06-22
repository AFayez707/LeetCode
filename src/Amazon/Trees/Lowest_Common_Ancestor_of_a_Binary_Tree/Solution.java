package Amazon.Trees.Lowest_Common_Ancestor_of_a_Binary_Tree;

// Link: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree
// Time: O(N)
// Space: O(N)
// Video: https://www.youtube.com/watch?v=13m9ZCB8gjw
public class Solution {
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q)
            return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if(left == null)
            return right;
        else if(right == null)
            return left;
        else // if both of them are not null, so the result will be the current root.
            return root;
    }
}
