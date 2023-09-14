package sorting.theory;

import helper.linkedlist.LinkedListBuilder;
import helper.linkedlist.ListNode;

public class _5_MergeSortLinkedList {

    public static void main(String[] args) {
        ListNode head = LinkedListBuilder.build(new int[]{703, 843, -259, -959, 276, 277, 207, -125, -845, -637,
                -731, -927, -401, -58, -63, 588, -586, 230, -415, 406, 235, 811, -55, -382, -843, 943, 656,
                504, 822, -159, -620, 558, -452, -529, 199, -321, -905, 716, 113, -337, 878, 417, -652, 40,
                365, 711, 662, 0, 637, 598, 469, 759, 173, 418, 421, -296, 610, 647, -287, 506, -74, 461,
                -299, 592, 308, -247, 275, -898, 752, 775, 385, 894, 788, 98, -53, 270, 622, -94, -693, 945,
                231, -690, -706, 761, 145, -69, -404, -493, 106, -56, 455, -621, 63, 912, -279, 212, -548,
                196, -628, 312, 905, -866, -89, -245, -966, -334, -919, -264, -758, 514, -865, -613, -993,
                617, 324, 846, -486, -593, -977, -515, -238, 466, 474, -848, 18, -19, 138, -867, 931, 484,
                479, -894, -478, -863, -926, 983, -161, 534, 292, 958, -827, -87, -475, -331, -292, 604, 169,
                -188, -354, 733, 254, -718, -395, 76, 172, -128, 556, -899, -624, -567, 970, -642, 162, -747,
                963, -422, 269, -779, -952, 399, -466, 9, -752, -224, 648, -717, 833, -950, -409, 694, -410,
                -649, 442, -156, 333, -574, -970, -805, 146, -79, 997, -301, 150, -938, -373, 698, 766, 531,
                962, -794, -698, -339, 451, -804, -795, -350, 681, 673, 285, 555, 130, 665, -549, -639, -743,
                -546, 710, -499, -177, -703, 675, -664, -943, 839, 24, 255, 561, 865, -937, -162, 840, 336,
                -520, 137, 738, -587, -732, -310, 570, 634, -309, -10, 49, -33, -695, -22, 925, -517, -831,
                714, 214, -990, -884, -756, 30, -118, 42, -953, -634, -875, -687, 919, 885, 582, -606, -704,
                -48, -565, 686, 882, 70, 294, 287, -796, 218, 684, -352, -474, 498, 112, -913, 376, -34, 432,
                -476, 35, 615, 902, 281, 825, 653, 938, -932, -700, -815, 404, 182, 149, 227, 166, 299, 863,
                244, 67, 443, 374, -623, 205, -353, -116, -820, 593, 271, -346, 10, 427, 144, 725, 3, -641,
                765, 587, -770, 732, -71, 187, -457, -204, 344, 918, 959, 864, 400, 974, -961, 602, 636,
                460, 964, -792, -8, 757, -428, 410, 631, 282, -997, 517, 633, -143, -316, -66, -202, 754,
                888, -923, -383, -720, -307, 485, 696, -521, -381, -262, 932, 134, -676, -406, -400, 392, 78,
                375, -340, 803, -849, -603, -127, 107, 459, 533, 672, -682, 852, -566, -963, 211, 204, -638,
                870, -838, 989, -528, -777, -368, -773, 663, 597, 295, 97, 121, 180, 525, 802, 52, 901, 243,
                526, 677, 16, 926, 724, -596, -684, 100, 796, 920, -622, -420, 797, -503, 549, -137, 936, 891,
                -886, -242, -411, 71, 338, -790, -625, -47, -38, -757, 337, -631, -808, -488, 248, -669, 94,
                -246, 306, -467, 749, 445, -2, 267, -194, 85, 347, 691, 627, -778, 756, -217, 387, 792, -644,
                -212, 642, -1000, -371, 967, 92, -117, 381, -999, -741, 791, -92, 819, -735, 152, 523, 715,
                -473, -104, -715, -542, -979, -871, -179, -165, 726, -933, 236, 398, -324, -101, -461, -28,
                -555, -418, 856, 524, 190, 969, 607, 39, -822, 185, 975, 34, 569, 542, -880, -891, -983,
                -120, -920, -844, -465, 91, 586, 405, 651, 157, 200, 50, 883, 910, -72, -141, -174, 143, 343,
                201, -394, 814, 430, -136, -971, 898, -283, -280, 942, -781, 170, 4, -560, 927, -205, -802,
                603, -434, -147, -110, -890, -629, 321, 799, -44, 298, 225, 720, -191, 499, -313, 961, 246,
                -828, 679, 314, 929, 342, -818, 769, -442, 353, -819, 222, 649, -507, -702, -551, 624, 84, -888,
                -229, -791, 301, -598, -129, -846, 999, 349, -859, 395, 186, 87, 128, 318, 256, 456, 871, 867,
                -389, -190, -864, 234, -481, 536, -697, 906, 747});

        head = mergeSortIterative(head);

        head.print();
    }

    private static ListNode mergeSortIterative(ListNode head) {
        if (head == null || head.next == null) return head;

        int length = getLength(head);
        int size = 2;

        for (; size <= length; size *= 2) {
            ListNode node = head;
            ListNode prev = null;

            int i = 0;

            for (; i <= length - size; i += size) {
                ListNode[] nodes = getSubListNodes(node, size);
                ListNode next = nodes[1].next;
                nodes[1].next = null;

                ListNode mid = getMidNode(node);

                ListNode[] merged = merge(node, mid);

                if (prev == null) head = merged[0];
                else prev.next = merged[0];

                merged[1].next = next;
                prev = merged[1];
                node = next;
            }

            // merge any leftovers with last sublist
            if (i < length && length < i + size) {
                prev.next = null;

                ListNode[] nodes = getKthNodeAndPrev(head, i - size);
                ListNode[] merged = merge(nodes[0], node);

                if (nodes[1] == null) head = merged[0];
                else nodes[1].next = merged[0];
            }
        }

        return head;
    }

    private static int getLength(ListNode node) {
        int length = 0;

        while (node != null) {
            node = node.next;
            length++;
        }

        return length;
    }

    private static ListNode[] getSubListNodes(ListNode head, int size) {
        int count = 0;
        ListNode node = head;
        ListNode prev = null;

        while (count < size && node != null) {
            count++;
            prev = node;
            node = node.next;
        }

        return new ListNode[]{head, prev};
    }

    private static ListNode getMidNode(ListNode node) {
        ListNode mid = node, fast = node, prev = null;
        while (fast != null && fast.next != null) {
            prev = mid;
            mid = mid.next;
            fast = fast.next.next;
        }

        if (prev != null) prev.next = null;

        return mid;
    }

    private static ListNode[] getKthNodeAndPrev(ListNode node, int k) {
        int count = 0;
        ListNode left = node;
        ListNode leftPrev = null;
        while (count < k && left != null) {
            leftPrev = left;
            left = left.next;
            count++;
        }

        if (leftPrev != null) leftPrev.next = null;

        return new ListNode[]{left, leftPrev};
    }

    private static ListNode[] merge(ListNode node, ListNode mid) {
        ListNode head = null;
        ListNode current = null;

        while (node != null || mid != null) {
            ListNode tempNode;
            if (node != null && mid != null) {
                if (node.value < mid.value) {
                    tempNode = node;
                    node = node.next;
                } else {
                    tempNode = mid;
                    mid = mid.next;
                }
            } else if (node != null) {
                tempNode = node;
                node = node.next;
            } else {
                tempNode = mid;
                mid = mid.next;
            }

            if (head == null) head = tempNode;
            if (current != null) current.next = tempNode;
            current = tempNode;
        }

        return new ListNode[]{head, current};
    }
}
