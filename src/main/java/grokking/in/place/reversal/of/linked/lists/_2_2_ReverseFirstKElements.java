package grokking.in.place.reversal.of.linked.lists;

import helper.linkedlist.LinkedListBuilder;
import helper.linkedlist.ListNode;

import java.util.Arrays;

import static helper.assertion.Assert.assertEqualsForTest;

/**
 * Question:
 * Reverse the first ‘k’ elements of a given LinkedList.
 * ---
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class _2_2_ReverseFirstKElements {

    public static void main(String[] args) {
        ListNode head = LinkedListBuilder.build(new int[]{1, 2, 3, 4, 5});

        assertEqualsForTest(Arrays.asList(4, 3, 2, 1, 5), solution(head, 4));
    }

    private static ListNode solution(ListNode head, int k) {
        ListNode node = head;
        int count = 1;
        while (count < k) {
            count++;
            node = node.next;
        }

        ListNode next = node.next;
        node.next = null;

        ListNode reversed = getReversedLinkedList(head);

        head.next = next;
        return reversed;
    }

    private static ListNode getReversedLinkedList(ListNode head) {
        ListNode node = head, prev = null, next;

        while (node != null) {
            next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }

        return prev;
    }
}
