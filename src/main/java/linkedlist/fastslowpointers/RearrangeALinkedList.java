package linkedlist.fastslowpointers;

import helper.linkedlist.ListNode;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Question:
 * Given the head of a singly LinkedList, write a method to modify the LinkedList such that the nodes from
 * the second half of the LinkedList are inserted alternately to the nodes from the first half in reverse order.
 * So if the LinkedList has nodes 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> null,
 * your method should return 1 -> 6 -> 2 -> 5 -> 3 -> 4 -> null.
 * Your algorithm should not use any extra space and the input LinkedList should be modified in-place.
 * ---
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class RearrangeALinkedList {

    public static void main(String[] args) {
        ListNode head1 = new ListNode(2);
        head1.next = new ListNode(4);
        head1.next.next = new ListNode(6);
        head1.next.next.next = new ListNode(8);
        head1.next.next.next.next = new ListNode(10);
        head1.next.next.next.next.next = new ListNode(12);

        rearrange(head1);

        assertEqualsForTest(Arrays.asList(2, 12, 4, 10, 6, 8), head1);

        ListNode head2 = new ListNode(2);
        head2.next = new ListNode(4);
        head2.next.next = new ListNode(6);
        head2.next.next.next = new ListNode(8);
        head2.next.next.next.next = new ListNode(10);

        rearrange(head2);

        assertEqualsForTest(Arrays.asList(2, 10, 4, 8, 6), head2);
    }

    private static void assertEqualsForTest(List<Integer> expected, ListNode head) {
        ListNode node = head;
        int i = 0;
        while (node != null) {
            assertEquals(expected.get(i).intValue(), node.value);
            node = node.next;
            i++;
        }
    }

    private static void rearrange(ListNode head) {
        if (head == null || head.next == null) return;

        ListNode middle = getMiddleNode(head);

        //middle is always different from null in our scenarios
        ListNode nodeReversedRightHalf = getReversedRightHalfList(middle);
        ListNode nodeLeftHalf = head;

        while (nodeLeftHalf != null && nodeReversedRightHalf != null) {
            ListNode next = nodeLeftHalf.next;
            nodeLeftHalf.next = nodeReversedRightHalf;
            nodeLeftHalf = next;

            next = nodeReversedRightHalf.next;
            nodeReversedRightHalf.next = nodeLeftHalf;
            nodeReversedRightHalf = next;
        }

        if (nodeLeftHalf != null) nodeLeftHalf.next = null;
    }

    private static ListNode getMiddleNode(ListNode head) {
        ListNode slow = head, fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    private static ListNode getReversedRightHalfList(ListNode head) {
        ListNode prev = null;

        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }

        return prev;
    }
}
