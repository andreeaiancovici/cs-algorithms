package sorting.theory;

import java.util.Arrays;

/**
 * When to use it:
 * - linked list sorting
 * - external sorting
 * Time Complexity: O(n * log(n))
 * Space Complexity: O(n)
 */
public class _5_MergeSortArray {

    public static void main(String[] args) {
        int[] arr1 = new int[]{61, 42, 67, 27, 17, 75, 56, 93, 76, 46, 63, 55, 70, 59, 98, 9, 7, 67, 95, 90};
        mergeSortRecursive(arr1, 0, arr1.length - 1);
        Arrays.stream(arr1).forEach(num -> System.out.print(num + " "));

        System.out.println();

        int[] arr2 = new int[]{61, 42, 67, 27, 17, 75, 56, 93, 76, 46, 63, 55, 70, 59, 98, 9, 7, 67, 95, 90};
        mergeSortIterative(arr2);
        Arrays.stream(arr2).forEach(num -> System.out.print(num + " "));
    }

    private static void mergeSortRecursive(int[] arr, int left, int right) {
        if (left == right) return;

        int mid = (right - left) / 2 + left;

        mergeSortRecursive(arr, left, mid);
        mergeSortRecursive(arr, mid + 1, right);

        merge(arr, left, mid, right);
    }

    private static void mergeSortIterative(int[] arr) {
        int size = 2;

        for (; size <= arr.length; size *= 2) {
            int i = 0;

            for (; i <= arr.length - size; i += size) {
                int left = i;
                int right = i + size - 1;
                int mid = (right - left) / 2 + left;
                merge(arr, left, mid, right);
            }

            // merge any leftovers with last sublist
            if (i < arr.length && arr.length < i + size) {
                merge(arr, i - size, i - 1, arr.length - 1);
            }
        }
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int[] leftArr = new int[mid - left + 1];
        System.arraycopy(arr, left, leftArr, 0, mid - left + 1);

        int[] rightArr = new int[right - mid];
        System.arraycopy(arr, mid + 1, rightArr, 0, right - mid);

        int k = left;
        int i = 0, j = 0;
        while (i < leftArr.length || j < rightArr.length) {
            if (i < leftArr.length && j < rightArr.length) {
                if (leftArr[i] < rightArr[j]) arr[k++] = leftArr[i++];
                else arr[k++] = rightArr[j++];
            } else if (i < leftArr.length) arr[k++] = leftArr[i++];
            else arr[k++] = rightArr[j++];
        }
    }
}
