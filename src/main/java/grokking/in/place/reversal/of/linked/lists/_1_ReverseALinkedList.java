package grokking.in.place.reversal.of.linked.lists;

import helper.linkedlist.LinkedListBuilder;
import helper.linkedlist.ListNode;

import java.util.Arrays;

import static helper.assertion.Assert.assertEqualsForTest;

/**
 * Question:
 * Given the head of a Singly LinkedList, reverse the LinkedList.
 * Write a function to return the new head of the reversed LinkedList.
 * ---
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class _1_ReverseALinkedList {

    public static void main(String[] args) {
        ListNode head = LinkedListBuilder.build(new int[]{2, 4, 6, 8, 10});

        assertEqualsForTest(Arrays.asList(10, 8, 6, 4, 2), solution(head));
    }

    private static ListNode solution(ListNode head) {
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
