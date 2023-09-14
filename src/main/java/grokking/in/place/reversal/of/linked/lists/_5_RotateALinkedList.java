package grokking.in.place.reversal.of.linked.lists;

import helper.linkedlist.LinkedListBuilder;
import helper.linkedlist.ListNode;

import java.util.Arrays;

import static helper.assertion.Assert.assertEqualsForTest;

/**
 * Question:
 * Given the head of a Singly LinkedList and a number k, rotate the LinkedList to the right by k nodes.
 * ---
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class _5_RotateALinkedList {

    public static void main(String[] args) {
        ListNode head1 = LinkedListBuilder.build(new int[]{1, 2, 3, 4, 5, 6});

        assertEqualsForTest(Arrays.asList(4, 5, 6, 1, 2, 3), solution(head1, 3));

        ListNode head2 = LinkedListBuilder.build(new int[]{1, 2, 3, 4, 5});

        assertEqualsForTest(Arrays.asList(4, 5, 1, 2, 3), solution(head2, 2));
    }

    private static ListNode solution(ListNode head, int k) {
        ListNode fast = head;
        int count = 0;
        while (count < k) {
            fast = fast.next;
            count++;
        }

        ListNode slow = head;
        ListNode prevSlow = null;
        ListNode prevFast = null;
        while (fast != null) {
            prevSlow = slow;
            prevFast = fast;
            slow = slow.next;
            fast = fast.next;
        }

        prevSlow.next = null;
        prevFast.next = head;

        return slow;
    }
}
