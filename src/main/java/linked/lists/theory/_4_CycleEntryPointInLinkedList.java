package linked.lists.theory;

import helper.linkedlist.LinkedListBuilder;
import helper.linkedlist.ListNode;

import static org.junit.Assert.assertEquals;

/**
 * Based on Floyd's Cycle-Finding algorithm, we check if the list contains a cycle.
 * If so, we iterate the cycle once to find its length.
 * Based on the logic behind fast & slow pointers, we increment the fast pointer with length of cycle steps.
 * After that, we increment both pointers until they meet, which is the entry point of the cycle.
 * ---
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class _4_CycleEntryPointInLinkedList {

    public static void main(String[] args) {
        ListNode head = LinkedListBuilder.build(new int[]{1, 2, 3, 4, 5, 6});

        head.next.next.next.next.next.next = head.next.next;

        assertEquals(head.next.next, getStartingNode(head));
    }

    private static ListNode getStartingNode(ListNode head) {
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
