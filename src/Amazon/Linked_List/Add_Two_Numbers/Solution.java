package Amazon.Linked_List.Add_Two_Numbers;

public class Solution {
    // Link: https://leetcode.com/problems/add-two-numbers/
    // Time: O(Max(M, N))
    // Space: O(Max(M, N))

    // IMPORTANT
    // The numbers are stores in the same order
    // 2 -> 4 -> 3
    // 5 -> 6 -> 4
    // Result: 7 -> 0 -> 8
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // The actual results starts a node next to this one.
        ListNode head = new ListNode(0);
        ListNode currentNode = head;
        int carry = 0;

        while(l1 != null || l2 != null || carry != 0) {
            int sum = carry;
            if(l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if(l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            currentNode.next = new ListNode(sum % 10);
            currentNode = currentNode.next;
            carry = sum / 10;
        }
        return head.next;
    }
}
