package graph.theory.singlesourceshortestpath.bellmanford;

import java.util.Arrays;

/**
 * Suppose that we are given a weighted directed graph G with n vertices and m edges, and some specified vertex v.
 * You want to find the length of shortest paths from vertex v to every other vertex.
 * ---
 * Time Complexity: O(n * m), where n is the number of nodes / vertices and m is the number of edges
 * Space Complexity: O(n)
 */
public class BellmanFord {

    public static void main(String[] args) {
        int[][] edges = new int[][]{{0, 1, -1}, {0, 2, 4}, {1, 2, 3}, {1, 3, 2}, {1, 4, 2}, {3, 2, 5}, {3, 1, 1}, {4, 3, -3}};
        bellmanFord(5, 0, edges);
    }

    private static void bellmanFord(int n, int source, int[][] edges) {
        int[] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);

        distance[source] = 0;

        for (int i = 0; i < n - 1; i++) {
            for (int[] edge : edges) {
                if (distance[edge[0]] < Integer.MAX_VALUE) {
                    distance[edge[1]] = Math.min(distance[edge[1]], distance[edge[0]] + edge[2]);
                }
            }
        }

        Arrays.stream(distance).forEach(d -> System.out.print(d + " "));
    }
}
