package grokking.fast.slow.pointers;

import helper.linkedlist.LinkedListBuilder;
import helper.linkedlist.ListNode;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Question:
 * Given the head of a singly LinkedList, write a function to determine if the LinkedList has a cycle in it or not.
 * ---
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class _1_1_LinkedListCycle {

    public static void main(String[] args) {
        ListNode head = LinkedListBuilder.build(new int[]{1, 2, 3, 4, 5, 6});

        assertFalse(solution(head));

        head.next.next.next.next.next.next = head.next.next;

        assertTrue(solution(head));

        head.next.next.next.next.next.next = head.next.next.next;

        assertTrue(solution(head));
    }

    private static boolean solution(ListNode head) {
        ListNode slow = head, fast = head;

        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) return true;
        }

        return false;
    }
}
