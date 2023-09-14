package grokking.in.place.reversal.of.linked.lists;

import helper.linkedlist.LinkedListBuilder;
import helper.linkedlist.ListNode;

import java.util.Arrays;

import static helper.assertion.Assert.assertEqualsForTest;

/**
 * Question:
 * Given a LinkedList with n nodes, reverse it based on its size in the following way:
 * - If n is even, reverse the list in a group of n/2 nodes.
 * - If n is odd, keep the middle node as it is, reverse the first n/2 nodes and reverse the last n/2 nodes.
 * ---
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class _2_3_ReverseBasedOnSize {

    public static void main(String[] args) {
        ListNode headEven = LinkedListBuilder.build(new int[]{1, 2, 3, 4, 5, 6});

        headEven = solution(headEven, 1, 3);
        headEven = solution(headEven, 4, 6);

        assertEqualsForTest(Arrays.asList(3, 2, 1, 6, 5, 4), headEven);

        ListNode headOdd = LinkedListBuilder.build(new int[]{1, 2, 3, 4, 5});

        headOdd = solution(headOdd, 1, 2);
        headOdd = solution(headOdd, 4, 5);

        assertEqualsForTest(Arrays.asList(2, 1, 3, 5, 4), headOdd);
    }

    private static ListNode solution(ListNode head, int from, int to) {
        ListNode node = head;
        ListNode prev = null;
        int count = 1;
        while (count < from) {
            prev = node;
            node = node.next;
            count++;
        }

        ListNode fromNode = node;
        ListNode prevFromNode = prev;

        if (prevFromNode != null) prevFromNode.next = null;

        while (count < to) {
            node = node.next;
            count++;
        }

        ListNode toNode = node;
        ListNode nextToNode = toNode.next;
        toNode.next = null;

        ListNode reversed = getReversedLinkedList(fromNode);

        if (prevFromNode == null) head = reversed;
        else prevFromNode.next = reversed;

        fromNode.next = nextToNode;

        return head;
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
