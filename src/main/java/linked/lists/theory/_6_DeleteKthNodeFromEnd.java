package linked.lists.theory;

import helper.linkedlist.LinkedListBuilder;
import helper.linkedlist.ListNode;

/**
 * Fast pointer is k nodes ahead of the slow pointer.
 * When the fast pointer reaches the end of the linked list, the slow pointer will be pointing at the k-th node from the end.
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class _6_DeleteKthNodeFromEnd {

    public static void main(String[] args) {
        ListNode head = LinkedListBuilder.build(new int[]{1, 2, 3, 4, 5, 6, 7});

        head = deleteKthNodeFromEnd(head, 3);
        head.print();

        System.out.println();

        head = deleteKthNodeFromEnd(head, 6);
        head.print();
    }

    private static ListNode deleteKthNodeFromEnd(ListNode head, int k) {
        ListNode fast = head;
        int count = 0;

        // we assume k is smaller than the length of the list
        while (count < k) {
            count++;
            fast = fast.next;
        }

        ListNode slow = head;
        ListNode prev = null;
        while (fast != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next;
        }

        if (prev == null) head = head.next;
        else prev.next = slow.next;

        return head;
    }
}
