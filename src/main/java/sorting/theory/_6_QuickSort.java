package sorting.theory;

import java.util.Arrays;

/**
 * https://en.wikipedia.org/wiki/Quicksort
 * <p>
 * When to use it:
 * - the programming language is good for recursion
 * - time complexity matters
 * - space complexity matters
 * <p>
 * Note on Hoare partition scheme:
 * Let's first examine the choice of recursing on (lo..p) and (p+1..hi), with the example of sorting an array
 * where multiple identical elements exist [0, 0]. If index i (the "latter" index) is returned after indices
 * cross in the partition function, the index 1 would be returned after the first partition. The subsequent
 * recursion on (lo..p)would be on (0, 1), which corresponds to the exact same array [0, 0]. A non-advancing
 * separation that causes infinite recursion is produced. It is therefore obvious that when recursing on (lo..p)
 * and (p+1..hi), because the left half of the recursion includes the returned index, it is the partition
 * function's job to exclude the "tail" in non-advancing scenarios. Which is to say, index j (the "former"
 * index when indices cross) should be returned instead of i.
 * ---
 * Time Complexity: O(n * log(n)) average and O(n^2) worst
 * *
 * It occurs when the pivot element picked is either the greatest or the smallest element.
 * This condition leads to the case in which the pivot element lies in an extreme end of the sorted array.
 * One sub-array is always empty and another sub-array contains n - 1 elements.
 * Thus, quicksort is called only on this sub-array.
 * However, the quicksort algorithm has better performance for scattered pivots.
 * *
 * Space Complexity: O(n * log(n))
 */
public class _6_QuickSort {

    public static void main(String[] args) {
        int[] arr1 = new int[]{61, 42, 67, 27, 17, 75, 56, 93, 76, 46, 63, 55, 70, 59, 98, 9, 7, 67, 95, 90};
        quickSortWithLomutoPartition(arr1, 0, arr1.length - 1);
        Arrays.stream(arr1).forEach(num -> System.out.print(num + " "));

        System.out.println();

        int[] arr2 = new int[]{61, 42, 67, 27, 17, 75, 56, 93, 76, 46, 63, 55, 70, 59, 98, 9, 7, 67, 95, 90};
        quickSortWithHoarePartition(arr2, 0, arr2.length - 1);
        Arrays.stream(arr2).forEach(num -> System.out.print(num + " "));
    }

    private static void quickSortWithLomutoPartition(int[] arr, int left, int right) {
        if (left >= right || left < 0) return;

        int pivotIndex = lomutoPartition(arr, left, right);

        quickSortWithLomutoPartition(arr, left, pivotIndex - 1);
        quickSortWithLomutoPartition(arr, pivotIndex + 1, right);
    }

    private static void quickSortWithHoarePartition(int[] arr, int left, int right) {
        if (left >= right || left < 0) return;

        int pivotIndex = hoarePartition(arr, left, right);

        quickSortWithLomutoPartition(arr, left, pivotIndex);
        quickSortWithLomutoPartition(arr, pivotIndex + 1, right);
    }

    private static int lomutoPartition(int[] arr, int left, int right) {
        int pivot = arr[right];

        int i = left - 1;

        for (int j = left; j < right; j++) {
            if (arr[j] <= pivot) {
                swap(arr, ++i, j);
            }
        }

        swap(arr, ++i, right);
        return i;
    }

    private static int hoarePartition(int[] arr, int left, int right) {
        int pivot = arr[(right - left) / 2 + left];

        int i = left - 1;
        int j = right + 1;

        while (true) {
            do i++; while (arr[i] < pivot);
            do j--; while (arr[j] > pivot);

            if (i >= j) return j;

            swap(arr, i, j);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
