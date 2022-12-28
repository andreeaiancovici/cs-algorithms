package graph.theory.unionfind;

import helper.graph.DisjointSetUnion;

import static org.junit.Assert.assertTrue;

/**
 * alfa -> Inverse Ackermann function
 * Time Complexity: O(m + alfa(n)) where n is the number of nodes / vertices and m is the number of edges
 * Space Complexity: O(n), where n is the number of nodes / vertices
 */
public class UnionFind {

    public static void main(String[] args) {
        int n = 3;
        int[][] edges = new int[][]{{0, 1}, {1, 2}, {2, 0}};
        DisjointSetUnion dsu = new DisjointSetUnion(n);

        for (int[] edge : edges) dsu.union(edge[0], edge[1]);

        assertTrue(dsu.connected(0, 2));
    }
}
