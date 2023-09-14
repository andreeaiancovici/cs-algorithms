package linked.lists.theory;

import helper.linkedlist.LinkedListBuilder;
import helper.linkedlist.ListNode;

/**
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class _5_ReverseLinkedList {

    public static void main(String[] args) {
        ListNode head = LinkedListBuilder.build(new int[]{1, 2, 3, 4, 5, 6});

        ListNode reversedHead = getReversedLinkedList(head);
        reversedHead.print();
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
