package linkedlist.fastslowpointers;

import helper.linkedlist.ListNode;

import static org.junit.Assert.assertEquals;

/**
 * Question:
 * Given the head of a singly LinkedList that contains a cycle, write a function to find the starting node of the cycle.
 * ---
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class StartOfLinkedListCycle {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        head.next.next.next.next.next.next = head.next.next;

        assertEquals(head.next.next, getStartingNode(head));

        head.next.next.next.next.next.next = head.next.next.next;

        assertEquals(head.next.next.next, getStartingNode(head));
    }

    private static ListNode getStartingNode(ListNode head) {
        ListNode slow = head, fast = head;
        // the list definitely contains a cycle, no null check required
        do {
            slow = slow.next;
            fast = fast.next.next;
        } while (slow != fast);

        int size = 0;
        ListNode temp = slow;
        do {
            size++;
            temp = temp.next;
        } while (temp != slow);

        slow = head;
        fast = head;
        int i = 0;
        while (i < size) {
            fast = fast.next;
            i++;
        }

        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }
}
