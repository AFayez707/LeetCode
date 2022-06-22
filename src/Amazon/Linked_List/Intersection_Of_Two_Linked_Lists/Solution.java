package Amazon.Linked_List.Intersection_Of_Two_Linked_Lists;

public class Solution {
    // Link: https://leetcode.com/problems/intersection-of-two-linked-lists/
    // Time: O(N + M)
    // Space: O(1)
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = getListLength(headA), lenB = getListLength(headB);
        // move headA and headB to the same start point
        while (lenA > lenB) {
            headA = headA.next;
            lenA--;
        }
        while (lenA < lenB) {
            headB = headB.next;
            lenB--;
        }

        // find the intersection until end
        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }

        return headA;
    }

    private int getListLength(ListNode node) {
        int length = 0;
        while (node != null) {
            node = node.next;
            length++;
        }
        return length;
    }
}
