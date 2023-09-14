package sorting.theory;

import java.util.*;

/**
 * When to use it:
 * - input is uniformly distributed over a range
 * - floating point values are present
 * ---
 * Time Complexity: O(n), but worst O(n^2), when one bucket contains too many elements
 * Space Complexity: O(n + k)
 */
public class _4_BucketSort {

    public static void main(String[] args) {
        int[] arr = new int[]{61, 42, 67, 27, 17, 75, 56, 93, 76, 46, 63, 55, 70, 59, 98, 9, 7, 67, 95, 90};
        bucketSort(arr);
        Arrays.stream(arr).forEach(num -> System.out.print(num + " "));
    }

    private static void bucketSort(int[] arr) {
        List<List<Integer>> buckets = new ArrayList<>(Collections.nCopies(10, null));

        for (int num : arr) {
            List<Integer> bucket = buckets.get(num / 10);

            if (bucket == null) {
                bucket = new LinkedList<>();
                buckets.set(num / 10, bucket);
            }

            insertInBucket(bucket, num);
        }

        int k = 0;
        for (List<Integer> bucket : buckets) {
            if (bucket != null) {
                for (int num : bucket) {
                    arr[k++] = num;
                }
            }
        }
    }

    // insertion sort
    private static void insertInBucket(List<Integer> bucket, int num) {
        int index = 0;
        while (index < bucket.size() && bucket.get(index) < num) index++;

        if (index == bucket.size()) bucket.add(num);
        else {
            bucket.add(-1);
            for (int i = bucket.size() - 1; i > index; i--) {
                bucket.set(i, bucket.get(i - 1));
            }

            bucket.set(index, num);
        }
    }
}
