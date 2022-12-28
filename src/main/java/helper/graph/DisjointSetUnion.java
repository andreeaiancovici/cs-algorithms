package helper.graph;

public class DisjointSetUnion {

    private final int[] root;
    private final int[] size;

    public DisjointSetUnion(int n) {
        this.root = new int[n];
        this.size = new int[n];

        for (int i = 0; i < n; i++) {
            this.root[i] = i;
            this.size[i] = 1;
        }
    }

    public int find(int x) {
        if (root[x] != x) root[x] = find(root[x]);
        return root[x];
    }

    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX != rootY) {
            if (size[rootX] < size[rootY]) {
                int temp = rootX;
                rootX = rootY;
                rootY = temp;
            }

            root[rootY] = rootX;
            size[rootX] += size[rootY];
        }
    }

    public boolean connected(int x, int y) {
        return find(x) == find(y);
    }
}
