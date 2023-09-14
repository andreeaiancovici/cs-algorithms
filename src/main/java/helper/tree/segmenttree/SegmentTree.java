package helper.tree.segmenttree;

public class SegmentTree {

    private final int size;
    private final int[] tree;

    public SegmentTree(int size) {
        this.size = size;
        tree = new int[4 * (size + 1)];
    }

    public void build() {
        build(1, 1, size);
    }

    private void build(int node, int low, int high) {
        if (low == high) {
            tree[node] = low;
        } else {
            int mid = (high - low) / 2 + low;
            build(2 * node, low, mid);
            build(2 * node + 1, mid + 1, high);
            tree[node] = Math.min(tree[2 * node], tree[2 * node + 1]);
        }
    }

    public int query(int left, int right) {
        return query(1, 1, size, left, right);
    }

    private int query(int node, int low, int high, int left, int right) {
        if (high < low || right < low || high < left || right < left) return Integer.MAX_VALUE;

        if (low == left && high == right) return tree[node];

        int mid = (high - low) / 2 + low;

        if (left <= mid) {
            int leftQuery = query(2 * node, low, mid, left, Math.min(mid, right));
            if (leftQuery != Integer.MAX_VALUE) return leftQuery;
        }

        if (mid < right) {
            int rightQuery = query(2 * node + 1, mid + 1, high, Math.max(mid, left), right);
            return rightQuery;
        }

        return Integer.MAX_VALUE;
    }

    public void update(int position) {
        update(1, 1, size, position);
    }

    private void update(int node, int low, int high, int position) {
        if (!(low <= position && position <= high)) return;

        if (low == high) {
            tree[node] = Integer.MAX_VALUE;
            return;
        }

        int mid = (high - low) / 2 + low;

        if (position <= mid) update(2 * node, low, mid, position);
        else update(2 * node + 1, mid + 1, high, position);

        tree[node] = Math.min(tree[2 * node], tree[2 * node + 1]);
    }
}
