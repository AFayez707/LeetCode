package Amazon.Linked_List.Linked_List_Cycle;

public class Solution {
    // Link: https://leetcode.com/problems/linked-list-cycle
    // Time: O(N)
    // Space: O(1)
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
