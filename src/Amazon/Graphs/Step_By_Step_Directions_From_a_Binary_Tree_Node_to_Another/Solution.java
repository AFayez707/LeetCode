package Amazon.Graphs.Step_By_Step_Directions_From_a_Binary_Tree_Node_to_Another;

public class Solution {
//    Build directions for both start and destination from the root.
//    Say we get "LLRRL" and "LRR".
//    Remove common prefix path.
//    We remove "L", and now start direction is "LRRL", and destination - "RR"
//    Replace all steps in the start direction to "U" and add destination direction.
//    The result is "UUUU" + "RR".
    // Link: https://leetcode.com/problems/step-by-step-directions-from-a-binary-tree-node-to-another/
    public String getDirections(TreeNode root, int startValue, int destValue) {
        StringBuilder start = new StringBuilder();
        StringBuilder dest = new StringBuilder();
        find(root, startValue, start);
        find(root, destValue, dest);
        start.reverse();
        dest.reverse();
        while (start.length() > 0 && dest.length() > 0 && start.charAt(0) == dest.charAt(0)) {
            start.deleteCharAt(0);
            dest.deleteCharAt(0);
        }
        return "U".repeat(start.length()) + dest.toString();
    }

    private boolean find(TreeNode root, int val, StringBuilder sb) {
        if (root.val == val) return true;
        if (root.left != null && find(root.left, val, sb)) {
            sb.append("L");
            return true;
        }
        if (root.right != null && find(root.right, val, sb))  {
            sb.append("R");
            return true;
        }
        return false;
    }
}
