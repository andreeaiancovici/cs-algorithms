package arrays.fastslowpointers;

import helper.list.ListNode;

import static org.junit.Assert.*;

/**
 * Question:
 * Given the head of a LinkedList with a cycle, find the length of the cycle.
 * ---
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class LengthOfLinkedListCycle {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        head.next.next.next.next.next.next = head.next.next;

        assertEquals(4, getCycleLength(head));

        head.next.next.next.next.next.next = head.next.next.next;

        assertEquals(3, getCycleLength(head));
    }

    private static int getCycleLength(ListNode head) {
        ListNode slow = head, fast = head;

        while(slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast) break;
        }

        int count = 0;
        if(slow != null && slow == fast) {
            ListNode temp = slow;
            do {
                count++;
                temp = temp.next;
            } while(temp != slow);
        }

        return count;
    }
}
