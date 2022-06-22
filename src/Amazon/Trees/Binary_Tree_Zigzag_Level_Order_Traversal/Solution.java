package Amazon.Trees.Binary_Tree_Zigzag_Level_Order_Traversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    // Link: https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal
    // Time: O(N)
    // Space: O(N)
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root == null)
            return result;

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        boolean leftToRight = true;

        while(!queue.isEmpty()) {
            int numberOfElements = queue.size();
            LinkedList<Integer> subList = new LinkedList<>();

            for(int i = 0; i < numberOfElements; i++) {
                TreeNode topNode = queue.poll();
                if(topNode.left != null)
                    queue.add(topNode.left);
                if(topNode.right != null)
                    queue.add(topNode.right);

                if(leftToRight)
                    subList.add(topNode.val);
                else
                    subList.addFirst(topNode.val);
            }
            result.add(subList);
            leftToRight = !leftToRight;
        }

        return result;
    }
}
