package Amazon.Linked_List.Merge_K_Sorted_Lists;

// Link: https://leetcode.com/problems/merge-k-sorted-lists/
// Time: O(N*K) K = Number of Lists, N = Size of List
// Space: O(1)

// NOTE: THERE'S ANOTHER APPROACH DOWN, WITH THE USAGE OF PRIORITY QUEUE

public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0)
            return null;
        if(lists.length == 1)
            return lists[0];

        ListNode head = mergeTwoLists(lists[0], lists[1]);
        for(int i = 2; i < lists.length; i++)
            head = mergeTwoLists(head, lists[i]);

        return head;
    }

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

// Time: O(N*Log(K)) K = Number of Lists, N = Total Number of Nodes
// Space: O(N + K)
//class Solution {
//    public ListNode mergeKLists(ListNode[] lists) {
//        if(lists == null || lists.length == 0)
//            return null;
//
//        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<ListNode>(lists.length, (a, b) -> a.val - b.val);
//
//        ListNode head = new ListNode(0);
//        ListNode currentNode = head;
//
//        for(ListNode node : lists)
//            if(node != null)
//                priorityQueue.add(node);
//
//        while(!priorityQueue.isEmpty()) {
//            currentNode.next = priorityQueue.poll();
//            currentNode = currentNode.next;
//
//            if(currentNode.next != null)
//                priorityQueue.add(currentNode.next);
//        }
//
//        return head.next;
//    }
//}