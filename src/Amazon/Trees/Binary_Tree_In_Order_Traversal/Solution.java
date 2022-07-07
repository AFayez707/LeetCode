package Amazon.Trees.Binary_Tree_In_Order_Traversal;

import java.util.*;

// I'M WORKING ON IT AND WILL SOLVE IT DIRECTLY AFTER MY CURRENT INTERVIEW
// Time Complexity O(N Log N) Because I'll have to traverse the whole Tree and also need to sort all the tuples so the sorting makes it O(N LOG N)
// Space Complexity O(N) Because I'll need to Store all the tuples, and also Traversal can take up to O(N) memory

// I made an assumption that a tuple from it's name should include three elements, so I only consider that nodes with both left and right childs
// If a node have only left or only right, I'll not cosider it into solution, because It will never give a solution of 3 elemnts.

public class Solution {
    // TreeNode Class implementation
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(){}

        TreeNode(int value) {
            this.val = value;
        }

        TreeNode(int value, TreeNode leftNode, TreeNode rightNode) {
            this.val = value;
            this.left = leftNode;
            this.right = rightNode;
        }
    }

    // Tuple Class implementation
    public class Tuple implements Comparable<Tuple> {
        int val;
        List<TreeNode> nodes;

        Tuple(int value, List<TreeNode> nodes) {
            this.val = value;
            this.nodes = nodes;
        }

        @Override
        public int compareTo(Tuple t) {
            return this.val - t.val;
        }

        @Override
        public String toString() {
            return "(" + nodes.get(0).val + ", " + nodes.get(1).val + ", " + nodes.get(2).val + ")";
        }
    }

    public List<Tuple> getMaxMatchingTuples(TreeNode root) {
        // Here I'm storing all the left hand side tuples and also the right hand side tuples
        List<Tuple> leftTuples = getAllTuples(root.left);
        List<Tuple> rightTuples = getAllTuples(root.right);

        List<Tuple> answer = null;

        // Here I sort both of them, based on the summation of (Root, Right Child, Left Child) which is the value attribute of the Tuple Class
        Collections.sort(leftTuples);
        Collections.sort(rightTuples);

        // Two Pointers mainly pointing to the maximum current sum of each left hand side and right hand side of the given tree
        int leftTuplePointer = 0, rightTuplePointer = 0;

        while(leftTuplePointer < leftTuples.size() && rightTuplePointer < rightTuples.size()) {
            if(leftTuples.get(leftTuplePointer).val < rightTuples.get(rightTuplePointer).val) {
                rightTuplePointer++;
            } else if(leftTuples.get(leftTuplePointer).val > rightTuples.get(rightTuplePointer).val) {
                leftTuplePointer++;
            } else {
                answer = new ArrayList<Tuple>();
                answer.add(leftTuples.get(leftTuplePointer));
                answer.add(rightTuples.get(rightTuplePointer));
                return answer;
            }
        }

        // Return null means no tuples are equal in values at all
        return null;
    }

    // This method will mainly traverse each node of the tree, and if the node has both the childrens, it will add it to the list of tuples
    // Which will be mainly used later to determine the maximum one.
    private List<Tuple> getAllTuples(TreeNode node) {
        List<Tuple> tuples = new ArrayList<>();
        List<TreeNode> allNodesWithBothChilds = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = node;

        while (curr != null || !stack.isEmpty()) {
            while(curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.pop();

            if(curr != null && curr.left != null && curr.right != null)
                allNodesWithBothChilds.add(curr);

            curr = curr.right;
        }

        tuples = getOnlyTuplesWithBothChilds(allNodesWithBothChilds);

        return tuples;
    }

    // This method will go through all the nodes with both childs, and convert them to tuples, and calculate the sum of the tuple.
    public List<Tuple> getOnlyTuplesWithBothChilds(List<TreeNode> allNodesWithBothChilds) {
        List<Tuple> tuples = new ArrayList<>();

        for(TreeNode currentNode : allNodesWithBothChilds) {
            List<TreeNode> nodes = new ArrayList<>();
            nodes.add(currentNode);
            nodes.add(currentNode.left);
            nodes.add(currentNode.right);
            int sum = currentNode.val + currentNode.left.val + currentNode.right.val;
            Tuple tuple = new Tuple(sum, nodes);
            tuples.add(tuple);
        }

        return tuples;
    }


    public static void main(String [] args) {
        new Solution().getSolution();
    }

    public void getSolution() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(-4);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);

        root.right = new TreeNode(8);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(-1);
        root.right.left.right = new TreeNode(1);

        List<Tuple> maxMatchingTuple = new Solution().getMaxMatchingTuples(root);

        if(maxMatchingTuple == null) {
            System.out.println("No Matching Max Tubles");
        } else {
            System.out.println("Tuple Value: " + maxMatchingTuple.get(0).val);
            System.out.println("Left: " + maxMatchingTuple.get(0));
            System.out.println("Right: " + maxMatchingTuple.get(1));
        }
    }

}







//public class Solution {
//    // Link: https://leetcode.com/problems/binary-tree-inorder-traversal
//    // Time: O(N)
//    // Space: O(N)
//    // Useful Image: https://leetcode.com/problems/validate-binary-search-tree/Figures/145_transverse.png
////    public List<Integer> inorderTraversal(TreeNode root) {
////        List<Integer> res = new ArrayList<>();
////        Stack<TreeNode> stack = new Stack<>();
////        TreeNode curr = root;
////        while (curr != null || !stack.isEmpty()) {
////            while (curr != null) {
////                stack.push(curr);
////                curr = curr.left;
////            }
////            curr = stack.pop();
////            res.add(curr.val);
////            curr = curr.right;
////        }
////        return res;
////    }
//
//    public List<Integer> getMaxMatchingTuples(TreeNode root) {
//        List<Tuple> leftTuples = getAllTuples(root.left);
//        List<Tuple> rightTuples = getAllTuples(root.right);
//
//        Collections.sort(leftTuples);
//        Collections.sort(rightTuples);
//
//        Tuple
//
//    }
//
//    private List<Tuple> getAllTuples(TreeNode node) {
//        List<Tuple> tuples = new ArrayList<>();
//        List<TreeNode> allNodesWithBothChilds = new ArrayList<>();
//        Stack<TreeNode> stack = new Stack<>();
//        TreeNode curr = node;
//
//        while (curr != null || !stack.isEmpty()) {
//            while(curr != null) {
//                stack.push(curr);
//                curr = curr.left;
//            }
//
//            curr = stack.pop();
//
//            if(curr != null && curr.left != null && curr.right != null)
//                allNodesWithBothChilds.add(curr);
//
//            curr = curr.right;
//        }
//
//        for(TreeNode currentNode : allNodesWithBothChilds) {
//            List<TreeNode> nodes = new ArrayList<>();
//            nodes.add(curr);
//            nodes.add(curr.left);
//            nodes.add(curr.right);
//            int sum = curr.val + curr.left.val + curr.right.val;
//            Tuple tuple = new Tuple(sum, nodes);
//            tuples.add(tuple);
//        }
//
//        return tuples;
//    }
//
//
//    public List<Integer> inorderTraversal(TreeNode root) {
//        List<Integer> res = new ArrayList<>();
//        Stack<TreeNode> stack = new Stack<>();
//        TreeNode curr = root;
//        while (curr != null || !stack.isEmpty()) {
//            while (curr != null) {
//                stack.push(curr);
//                curr = curr.left;
//            }
//            curr = stack.pop();
//            res.add(curr.val);
//            curr = curr.right;
//        }
//        return res;
//    }
//}
