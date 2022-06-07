package Amazon.Linked_List.Reverse_Linked_List;

// Link: https://leetcode.com/problems/reverse-linked-list
// Time: O(N)
// Space: O(1)
public class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode previous = null;
        ListNode current = head;

        while(current != null) {
            ListNode next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        return previous;
    }
}
