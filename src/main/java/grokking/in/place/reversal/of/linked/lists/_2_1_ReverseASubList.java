package grokking.in.place.reversal.of.linked.lists;

import helper.linkedlist.LinkedListBuilder;
import helper.linkedlist.ListNode;

import java.util.Arrays;

import static helper.assertion.Assert.assertEqualsForTest;

/**
 * Question:
 * Given the head of a LinkedList and two positions 'p' and 'q', reverse the LinkedList from position 'p' to 'q'.
 * ---
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class _2_1_ReverseASubList {

    public static void main(String[] args) {
        ListNode head = LinkedListBuilder.build(new int[]{1, 2, 3, 4, 5});

        assertEqualsForTest(Arrays.asList(1, 4, 3, 2, 5), solution(head, 2, 4));
    }

    private static ListNode solution(ListNode head, int p, int q) {
        ListNode node = head;
        ListNode prev = null;
        while (node.value != p) {
            prev = node;
            node = node.next;
        }

        ListNode prevPNode = prev;
        ListNode pNode = node;

        while (node.value != q) {
            node = node.next;
        }

        ListNode qNode = node;
        ListNode nextQNode = qNode.next;

        if (prevPNode != null) prevPNode.next = null;
        qNode.next = null;

        ListNode reversed = getReversedLinkedList(pNode);
        pNode.next = nextQNode;

        if (prevPNode == null) return reversed;
        else {
            prevPNode.next = reversed;
            return head;
        }
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
