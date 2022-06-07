package Amazon.Linked_List.Copy_List_With_Random_Pointer;

// Link: https://leetcode.com/problems/copy-list-with-random-pointer/
// Space: O(1)
// Time: O(N)
public class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return null;

        // Creating a new LinkedList
        Node ptr = head;
        while(ptr != null) {
            Node nextNode = new Node(ptr.val);
            // Insert the new nodes just next to the original ones
            // If A -> B -> C ..... it becomes A -> A' -> B -> B' -> C -> C'
            nextNode.next = ptr.next;
            ptr.next = nextNode;
            ptr = nextNode.next;
        }

        ptr = head;

        // Now we need to link the random pointers of the new nodes.
        while (ptr != null) {
            ptr.next.random = (ptr.random != null) ? ptr.random.next : null;
            ptr = ptr.next.next;
        }

        // Now we have the linked list like this: A -> A' -> B -> B' -> C -> C'
        // We still need to split it to A -> B -> C, and : A' -> B' -> C'

        Node oldListPtr = head; // Will hold A -> B -> C
        Node newListPtr = head.next; // Will hold A' -> B' -> C'
        Node oldHead = head.next;

        while(oldListPtr != null) {
            oldListPtr.next = oldListPtr.next.next;
            newListPtr.next = (newListPtr.next != null) ? newListPtr.next.next : null;

            oldListPtr = oldListPtr.next;
            newListPtr = newListPtr.next;
        }

        return oldHead;
    }
}
