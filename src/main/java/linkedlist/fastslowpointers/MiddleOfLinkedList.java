package linkedlist.fastslowpointers;

import helper.linkedlist.ListNode;

import static org.junit.Assert.assertEquals;

/**
 * Question:
 * Given the head of a singly LinkedList, write a method to return the middle node of the LinkedList.
 * If the total number of nodes in the LinkedList is even, return the second middle node.
 * ---
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class MiddleOfLinkedList {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        assertEquals(head.next.next, getMiddleNode(head));

        head.next.next.next.next.next = new ListNode(6);

        assertEquals(head.next.next.next, getMiddleNode(head));

        head.next.next.next.next.next.next = new ListNode(7);

        assertEquals(head.next.next.next, getMiddleNode(head));
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
