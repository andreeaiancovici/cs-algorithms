package grokking.fast.slow.pointers;

import helper.linkedlist.LinkedListBuilder;
import helper.linkedlist.ListNode;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Question:
 * Given the head of a singly LinkedList, write a method to check if the LinkedList is a palindrome or not.
 * Your algorithm should use constant space and the input LinkedList should be in the original form once the
 * algorithm is finished. The algorithm should have O(n) time complexity where ‘n’ is the number of
 * nodes in the LinkedList.
 * ---
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class _4_PalindromeLinkedList {

    public static void main(String[] args) {
        ListNode head = LinkedListBuilder.build(new int[]{2, 4, 6, 4, 2});

        assertTrue(solution(head));

        head.next.next.next.next.next = new ListNode(2);

        assertFalse(solution(head));
    }

    private static boolean solution(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        //slow is always different from null in our scenarios
        ListNode node1 = getReversedLinkedList(slow.next);
        ListNode nodeKeptForReversing = node1;
        ListNode node2 = head;
        while (node1 != null && node2 != null) {
            if (node1.value != node2.value) return false;

            node1 = node1.next;
            node2 = node2.next;
        }

        slow.next = getReversedLinkedList(nodeKeptForReversing);

        return true;
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
