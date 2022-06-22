package Amazon.Trees.Binary_Tree_Maximum_Path_Sum;

// Link: https://leetcode.com/problems/binary-tree-maximum-path-sum
// Time: O(N)
// Space: O(H) -> H is the height of the tree.

public class Solution {
    private int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        calculateMaxGain(root);
        return maxSum;
    }

    private int calculateMaxGain(TreeNode node) {
        if(node == null)
            return 0;

        int leftGain = Math.max(calculateMaxGain(node.left), 0);
        int rightGain = Math.max(calculateMaxGain(node.right), 0);

        // Calculate the value required to start a new path with the two children.
        int newPath = node.val + leftGain + rightGain;

        // Update the maxSum value if it's better to start a new path
        maxSum = Math.max(maxSum, newPath);

        return node.val + Math.max(leftGain, rightGain);
    }
}
