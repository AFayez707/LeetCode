package Amazon.Linked_List.Merge_Two_Sorted_Lists;

public class Solution {
    // Link: https://leetcode.com/problems/merge-two-sorted-lists/
    // Time: O(N + M)
    // Space: O(1)
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null) return list2;
        if(list2 == null) return list1;

        // The answer will be starting from the head.next
        ListNode head = new ListNode(0);
        ListNode currentNode = head;

        while(list1 != null && list2 != null) {
            if(list1.val < list2.val) {
                currentNode.next = list1;
                currentNode = currentNode.next;
                list1 = list1.next;
            } else {
                currentNode.next = list2;
                currentNode = currentNode.next;
                list2 = list2.next;
            }
        }
        if(list1 == null)
            currentNode.next = list2;
        if(list2 == null)
            currentNode.next = list1;
        return head.next;
    }
}
