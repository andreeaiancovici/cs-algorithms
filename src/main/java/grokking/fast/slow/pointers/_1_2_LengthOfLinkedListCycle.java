package grokking.fast.slow.pointers;

import helper.linkedlist.LinkedListBuilder;
import helper.linkedlist.ListNode;

import static org.junit.Assert.assertEquals;

/**
 * Question:
 * Given the head of a LinkedList with a cycle, find the length of the cycle.
 * ---
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class _1_2_LengthOfLinkedListCycle {

    public static void main(String[] args) {
        ListNode head = LinkedListBuilder.build(new int[]{1, 2, 3, 4, 5, 6});

        head.next.next.next.next.next.next = head.next.next;

        assertEquals(4, solution(head));

        head.next.next.next.next.next.next = head.next.next.next;

        assertEquals(3, solution(head));
    }

    private static int solution(ListNode head) {
        ListNode slow = head, fast = head;

        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) break;
        }

        if (fast == null || fast.next == null) return 0;

        int length = 0;

        do {
            length++;
            fast = fast.next;
        } while (fast != slow);

        return length;
    }
}
