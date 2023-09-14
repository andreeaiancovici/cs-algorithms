package linked.lists.theory;

import helper.linkedlist.LinkedListBuilder;
import helper.linkedlist.ListNode;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Floyd's Cycle-Finding algorithm
 * If the linked list has a cycle, the fast pointer enters the cycle first, followed by the slow pointer.
 * After this, both pointers will keep moving in the cycle infinitely. If at any stage both of these pointers meet,
 * we can conclude that the linked list has a cycle in it.
 * When the fast pointer is approaching the slow pointer from behind we have two possibilities:
 * - The fast pointer is one step behind the slow pointer;
 * - The fast pointer is two steps behind the slow pointer.
 * ---
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class _2_CycleInLinkedList {

    public static void main(String[] args) {
        ListNode head = LinkedListBuilder.build(new int[]{1, 2, 3, 4, 5, 6});

        assertFalse(hasCycle(head));

        head.next.next.next.next.next.next = head.next.next;

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
