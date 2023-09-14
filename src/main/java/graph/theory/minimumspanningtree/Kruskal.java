package graph.theory.minimumspanningtree;

import helper.graph.DisjointSetUnion;

import java.util.Arrays;
import java.util.Comparator;

import static org.junit.Assert.assertEquals;

/**
 * Given a weighted undirected graph. We want to find a subtree of this graph which connects all vertices
 * (i.e. it is a spanning tree) and has the least weight (i.e. the sum of weights of all the edges is minimum)
 * of all possible spanning trees. This spanning tree is called a minimum spanning tree.
 * ---
 * Time Complexity: O(m * log(n)), where n is the number of nodes / vertices and m is the number of edges
 * Space Complexity: O(n)
 */
public class Kruskal {

    public static void main(String[] args) {
        assertEquals(25, MSTKruskal(7, new int[][]{{0, 1, 1}, {1, 2, 2}, {2, 3, 3}, {3, 4, 4}, {4, 2, 5}, {0, 2, 6}, {1, 5, 7}, {0, 6, 8}}));
    }

    private static int MSTKruskal(int n, int[][] edges) {
        Arrays.sort(edges, Comparator.comparingInt(edge -> edge[2]));

        int totalCost = 0;
        int connected = 0;

        DisjointSetUnion dsu = new DisjointSetUnion(n);
        for (int[] edge : edges) {
            int x = edge[0];
            int y = edge[1];
            int cost = edge[2];

            if (!dsu.connected(x, y)) {
                dsu.union(x, y);
                totalCost += cost;
                connected++;
            }

            if (connected == n - 1) break;
        }

        return totalCost;
    }
}
