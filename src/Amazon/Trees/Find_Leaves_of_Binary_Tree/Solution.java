package Amazon.Trees.Find_Leaves_of_Binary_Tree;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    // Link: https://leetcode.com/problems/find-leaves-of-binary-tree
    // Time: O(N)
    // Space: O(N)
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        while (root != null) {
            List<Integer> temp = new ArrayList<Integer>();
            root = removeLeaves(root, temp);
            res.add(temp);
        }
        return res;
    }

    private TreeNode removeLeaves(TreeNode root, List<Integer> temp) {
        if (root == null) return null;
        if (root.left == null && root.right == null) {
            temp.add(root.val);
            return null;
        }
        root.left = removeLeaves(root.left, temp);
        root.right = removeLeaves(root.right, temp);
        return root;
    }
}