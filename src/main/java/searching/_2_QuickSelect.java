package searching;

import static org.junit.Assert.assertEquals;

/**
 * Time Complexity: O(n) average and O(n^2) worst
 * Space Complexity: O(1)
 */
public class _2_QuickSelect {

    public static void main(String[] args) {
        int[] arr = new int[]{61, 42, 67, 27, 17, 75, 56, 93, 76, 46, 63, 55, 70, 59, 98, 9, 7, 67, 95, 90};
        assertEquals(42, quickSelect(arr, 0, arr.length - 1, 4));
        System.out.println("lala");
    }

    // Lomuto partition
    private static int quickSelect(int[] arr, int left, int right, int k) {
        if (left >= right) return arr[left];

        int pivotIndex = partition(arr, left, right);

        if (pivotIndex == k) return arr[k];
        if (k < pivotIndex) return quickSelect(arr, left, pivotIndex - 1, k);
        return quickSelect(arr, pivotIndex + 1, right, k);
    }

    private static int partition(int[] arr, int left, int right) {
        int pivotIndex = (right - left) / 2 + left;
        int pivot = arr[pivotIndex];
        swap(arr, pivotIndex, right);

        int i = left - 1;

        for (int j = left; j < right; j++) {
            if (arr[j] < pivot) {
                swap(arr, ++i, j);
            }
        }

        swap(arr, ++i, right);
        return i;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
