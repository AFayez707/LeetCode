package Amazon.Linked_List.Reverse_Nodes_in_K_Group;

// Link: https://leetcode.com/problems/reverse-nodes-in-k-group
// Space: O(1)
// Time: O(N)

public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        int numberOfNodes = 0;
        for (ListNode i = head; i != null; i = i.next)
            numberOfNodes++;

        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;

        ListNode previous = dummyNode;
        ListNode tail = head;

        while(numberOfNodes >= k) {
            // Reverse the next K nodes.
            for (int i = 1; i < k; i++) {
                ListNode next = tail.next.next;
                tail.next.next = previous.next;
                previous.next = tail.next;
                tail.next = next;
            }
            // Reset to the next part.
            previous = tail;
            tail = tail.next;
            // Reduce number of Nodes Counter.
            numberOfNodes -= k;
        }

        return dummyNode.next;
    }
}
