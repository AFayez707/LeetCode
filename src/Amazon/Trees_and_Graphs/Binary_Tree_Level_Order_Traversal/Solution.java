package Amazon.Trees_and_Graphs.Binary_Tree_Level_Order_Traversal;

import java.util.ArrayList;
import java.util.List;
// Link: https://leetcode.com/problems/binary-tree-level-order-traversal
// Time: O(N)
// Space: O(N)
public class Solution {
    List<List<Integer>> levels = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) return levels;

        generateLevels(root, 0);
        return levels;
    }

    public void generateLevels(TreeNode currentNode, int levelNumber) {
        // Add New Level
        if(levels.size() == levelNumber)
            levels.add(new ArrayList<Integer>());

        // Add the currentNode value to the list
        levels.get(levelNumber).add(currentNode.val);

        // Traverse Left Child
        if(currentNode.left != null)
            generateLevels(currentNode.left, levelNumber + 1);
        // Traverse Right Child
        if(currentNode.right != null)
            generateLevels(currentNode.right, levelNumber + 1);
    }
}
