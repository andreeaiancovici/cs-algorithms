package linked.lists.theory;

import helper.linkedlist.LinkedListBuilder;
import helper.linkedlist.ListNode;

import static org.junit.Assert.assertEquals;

/**
 * Based on Floyd's Cycle-Finding algorithm, we check if the list contains a cycle.
 * If so, we iterate the cycle once to find its length.
 * ---
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class _3_LengthOfCycleInLinkedList {

    public static void main(String[] args) {
        ListNode head = LinkedListBuilder.build(new int[]{1, 2, 3, 4, 5, 6});

        head.next.next.next.next.next.next = head.next.next;

        assertEquals(4, getCycleLength(head));
    }

    private static int getCycleLength(ListNode head) {
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
