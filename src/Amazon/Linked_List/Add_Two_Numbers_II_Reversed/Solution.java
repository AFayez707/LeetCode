package Amazon.Linked_List.Add_Two_Numbers_II_Reversed;

import Amazon.Linked_List.Add_Two_Numbers_II_Reversed.ListNode;

public class Solution {
    // Link: https://leetcode.com/problems/add-two-numbers-ii/
    // Time: O(N + M)
    // Space: O(Max(N, M)) To just store the output
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // reverse lists
        l1 = reverseList(l1);
        l2 = reverseList(l2);

        ListNode head = null;
        int carry = 0;
        while (l1 != null || l2 != null) {
            // get the current values
            int x1 = l1 != null ? l1.val : 0;
            int x2 = l2 != null ? l2.val : 0;

            // current sum and carry
            int val = (carry + x1 + x2) % 10;
            carry = (carry + x1 + x2) / 10;

            // update the result: add to front
            ListNode curr = new ListNode(val);
            curr.next = head;
            head = curr;

            // move to the next elements in the lists
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }

        if (carry != 0) {
            ListNode curr = new ListNode(carry);
            curr.next = head;
            head = curr;
        }

        return head;
    }

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
