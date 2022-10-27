package linkedlist.fastslowpointers;

import helper.linkedlist.ListNode;

import static org.junit.Assert.*;

/**
 * Question:
 * Given the head of a singly LinkedList, write a function to determine if the LinkedList has a cycle in it or not.
 * ---
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class LinkedListCycle {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        assertFalse(hasCycle(head));

        head.next.next.next.next.next.next = head.next.next;

        assertTrue(hasCycle(head));

        head.next.next.next.next.next.next = head.next.next.next;

        assertTrue(hasCycle(head));
    }

    private static boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;

        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) return true;
        }

        return false;
    }
}
