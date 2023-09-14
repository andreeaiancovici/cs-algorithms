package grokking.fast.slow.pointers;

import helper.linkedlist.LinkedListBuilder;
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
public class _3_MiddleOfLinkedList {

    public static void main(String[] args) {
        ListNode head = LinkedListBuilder.build(new int[]{1, 2, 3, 4, 5});

        assertEquals(head.next.next, solution(head));

        head.next.next.next.next.next = new ListNode(6);

        assertEquals(head.next.next.next, solution(head));

        head.next.next.next.next.next.next = new ListNode(7);

        assertEquals(head.next.next.next, solution(head));
    }

    private static ListNode solution(ListNode head) {
        ListNode slow = head, fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}
