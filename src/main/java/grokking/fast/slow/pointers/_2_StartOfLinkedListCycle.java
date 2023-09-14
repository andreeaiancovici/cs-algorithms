package grokking.fast.slow.pointers;

import helper.linkedlist.LinkedListBuilder;
import helper.linkedlist.ListNode;

import static org.junit.Assert.assertEquals;

/**
 * Question:
 * Given the head of a singly LinkedList that contains a cycle, write a function to find the starting node of the cycle.
 * ---
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class _2_StartOfLinkedListCycle {

    public static void main(String[] args) {
        ListNode head = LinkedListBuilder.build(new int[]{1, 2, 3, 4, 5, 6});

        head.next.next.next.next.next.next = head.next.next;

        assertEquals(head.next.next, solution(head));

        head.next.next.next.next.next.next = head.next.next.next;

        assertEquals(head.next.next.next, solution(head));
    }

    private static ListNode solution(ListNode head) {
        ListNode slow = head, fast = head;

        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) break;
        }

        if (fast == null || fast.next == null) return null;

        int length = 0;

        do {
            length++;
            fast = fast.next;
        } while (fast != slow);

        slow = head;
        fast = head;
        int count = 0;
        while (count < length) {
            fast = fast.next;
            count++;
        }

        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }
}
