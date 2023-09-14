package helper.linkedlist;

public class LinkedListBuilder {

    public static ListNode build(int[] arr) {
        ListNode head = null;
        ListNode node = null;

        for (int num : arr) {
            ListNode newNode = new ListNode(num);

            if (head == null) head = newNode;
            if (node != null) node.next = newNode;
            node = newNode;
        }

        return head;
    }
}
