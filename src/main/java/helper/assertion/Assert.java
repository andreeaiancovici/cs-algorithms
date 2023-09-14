package helper.assertion;

import helper.linkedlist.ListNode;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class Assert {

    public static void assertEqualsForTest(List<Integer> expected, ListNode head) {
        ListNode node = head;
        int i = 0;
        while (node != null) {
            assertEquals(expected.get(i).intValue(), node.value);
            node = node.next;
            i++;
        }

        assertEquals(i, expected.size());
    }
}
