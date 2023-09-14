package grokking.in.place.reversal.of.linked.lists;

import helper.linkedlist.LinkedListBuilder;
import helper.linkedlist.ListNode;

import java.util.Arrays;

import static helper.assertion.Assert.assertEqualsForTest;

/**
 * Question:
 * Given the head of a LinkedList and a number k, reverse every alternating k sized sub-list starting from the head.
 * If, in the end, you are left with a sub-list with less than ‘k’ elements, reverse it too.
 * ---
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class _4_ReverseAlternatingKElementSubList {

    public static void main(String[] args) {
        ListNode head = LinkedListBuilder.build(new int[]{1, 2, 3, 4, 5, 6, 7, 8});

        assertEqualsForTest(Arrays.asList(2, 1, 3, 4, 6, 5, 7, 8), solution(head, 2));
    }

    private static ListNode solution(ListNode head, int k) {
        ListNode node = head;
        ListNode startNode, prev = null;
        boolean doReverse = true;

        while (node != null) {
            startNode = node;

            int count = 1;
            while (count < k && node.next != null) {
                node = node.next;
                count++;
            }

            ListNode next = node.next;

            if (doReverse) {
                node.next = null;

                ListNode reversed = getReversedLinkedList(startNode);

                if (prev == null) head = reversed;
                else prev.next = reversed;

                prev = startNode;
            } else {
                prev.next = startNode;

                prev = node;
            }

            node = next;
            doReverse = !doReverse;
        }

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
