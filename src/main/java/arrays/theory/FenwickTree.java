package arrays.theory;

public class FenwickTree {
    // 1-based indexing

    private final int n;
    private final int[] tree;

    public FenwickTree(int n) {
        this.n = n;
        this.tree = new int[n + 1];
    }

    public FenwickTree fromArray(int[] nums) {
        FenwickTree fenwickTree = new FenwickTree(nums.length);

        for (int i = 0; i < nums.length; i++) {
            fenwickTree.update(i, nums[i]);
        }

        return fenwickTree;
    }

    public void update(int index, int delta) {
        index++;

        while (index <= n) {
            tree[index] += delta;
            index += (index & -index);
        }
    }

    public int sum(int index) {
        int result = 0;
        index++;

        while (0 < index) {
            result += tree[index];
            index -= (index & -index);
        }

        return result;
    }

    public int rangeSum(int left, int right) {
        return sum(right) - sum(left - 1);
    }
}
