package Amazon.Trees.Binary_Tree_In_Order_Traversal;

import java.util.List;

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
