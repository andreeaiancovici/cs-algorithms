import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MedianOfTwoSorted {
    public static void main(String[] args) {
        List<? extends Object> strings = Arrays.asList("hi there");
        System.out.println(findMedianSortedArrays(new int[]{4, 6, 8, 9, 10}, new int[]{1, 2, 3, 5, 7}));
        System.out.println(findMedianSortedArrays(new int[]{1, 2, 3}, new int[]{1, 2, 2}));
    }

    // 1 1 2 2 2 3

    // 1 2 3 4 5 6 7 8 9 10

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        if (nums1[m - 1] <= nums2[0]) {
            if (m + n % 2 == 1) {
                int medianIndex = (m + n) / 2;
                if (medianIndex < m) return nums1[medianIndex];
                else return nums2[medianIndex - m];
            } else {
                int medianIndex1 = (m + n) / 2 - 1;
                int medianIndex2 = (m + n) / 2;

                if (medianIndex1 < m && medianIndex2 < m) {
                    return (double) (nums1[medianIndex1] + nums1[medianIndex2]) / 2;
                } else if (medianIndex1 < m) {
                    return (double) (nums1[medianIndex1] + nums2[medianIndex2 - m]) / 2;
                } else {
                    return (double) (nums1[medianIndex1 - m] + nums2[medianIndex2 - m]) / 2;
                }
            }
        }

        if (m <= n) return helper(nums1, nums2, m, n);
        return helper(nums2, nums1, n, m);
    }

    // 1 1 2 2 2 3

    private static double helper(int[] nums1, int[] nums2, int m, int n) {
        int left = 0, right = m - 1;

        while (left < right) {
            int mid1 = (right - left) / 2 + left;
            int mid2 = get(nums1[mid1], nums2, n);

            int countLeft = mid1 + mid2;
            int countRight = (m - mid1) + (n - mid2);

            if (countRight < countLeft) right = mid1;
            else left = mid1 + 1;
        }

        int mid2 = get(nums1[left], nums2, n);

        int countLeft = left + mid2;
        int countRight = (m - left) + (n - mid2);

        if ((countLeft + countRight) % 2 == 0) {
            List<Integer> list = new ArrayList<>();
            list.add(nums1[left]);
            if (0 < left) list.add(nums1[left - 1]);
            list.add(nums2[mid2]);
            if (0 < mid2) list.add(nums2[mid2 - 1]);

            Collections.sort(list);

            if (list.size() == 2) return (double) (list.get(0) + list.get(1)) / 2;

            return (double) (list.get(1) + list.get(2)) / 2;
        }

        return (nums1[left]);
    }

    private static int get(int target, int[] nums2, int n) {
        int left = 0, right = n - 1;

        while (left < right) {
            int mid = (right - left) / 2 + left;

            if (target <= nums2[mid]) right = mid;
            else left = mid + 1;
        }

        if (nums2[left] < target) return n;

        return left;
    }
}
