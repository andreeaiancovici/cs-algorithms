package linked.lists.theory;

import helper.linkedlist.LinkedListBuilder;
import helper.linkedlist.ListNode;

import static org.junit.Assert.assertEquals;

/**
 * Fast pointer is always twice the nodes ahead of the slow pointer.
 * When the fast pointer reaches the end of the linked list, the slow pointer will be pointing at the middle node.
 * If the size of the list is:
 * - odd -> we return the middle of linked list;
 * - even -> we return the second middle of linked list.
 * ---
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class _1_MiddleOfLinkedList {

    public static void main(String[] args) {
        ListNode headEven = LinkedListBuilder.build(new int[]{1, 2, 3, 4, 5, 6});
        ListNode headOdd = LinkedListBuilder.build(new int[]{1, 2, 3, 4, 5});

        assertEquals(headEven.next.next.next, getMiddleNode(headEven));
        assertEquals(headOdd.next.next, getMiddleNode(headOdd));
    }

    private static ListNode getMiddleNode(ListNode head) {
        ListNode slow = head, fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}
