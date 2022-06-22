package Amazon.Trees.Diameter_of_Binary_Tree;

// Link: https://leetcode.com/problems/diameter-of-binary-tree/
// Time: O(N)
// Space: O(N)
public class Solution {
    private int diameter;
    public int diameterOfBinaryTree(TreeNode root) {
        diameter = 0;
        findLongestPath(root);
        return diameter;
    }

    private int findLongestPath(TreeNode node) {
        if(node == null)
            return 0;

        // recursively find the longest path in both left and right childs
        int leftPath = findLongestPath(node.left);
        int rightPath = findLongestPath(node.right);

        diameter = Math.max(diameter, leftPath + rightPath);

        // 1 is added to connect the node to it's parent.
        return Math.max(leftPath, rightPath) + 1;
    }
    // Follow Up: Can you print or return this diameter or path?
//    private int diameter;
//    private List<Integer> path;
//    private List<Integer> maxPath;
//    public int DiameterOfBinaryTree(TreeNode root) {
//        diameter = 0;
//        path = new ArrayList<>();
//        maxPath = new ArrayList<Integer>();
//
//        LongestPath(root);
//
//        for(int i=0;i< maxPath.size();i++)
//            System.out.println(maxPath.get(i));
//
//        return diameter;
//    }
//
//    public int LongestPath(TreeNode node) {
//        if(node == null)
//            return 0;
//
//        path.add(node.val);
//
//        int left = LongestPath(node.left);
//        int right = LongestPath(node.right);
//
//        if(left + right > diameter) {
//            diameter = left + right;
//            maxPath = new ArrayList<Integer>(path);
//        }
//
//        if(left != 0 && right != 0)
//            path.remove(path.size() - 1);
//
//        return Math.max(left, right) + 1;
//    }
}
