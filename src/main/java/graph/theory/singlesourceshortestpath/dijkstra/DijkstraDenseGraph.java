package graph.theory.singlesourceshortestpath.dijkstra;

import helper.graph.GraphBuilder;
import org.apache.commons.lang3.tuple.Pair;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * You are given a directed or undirected weighted graph with n vertices and m edges.
 * The weights of all edges are non-negative. You are also given a starting vertex s.
 * Find the lengths of the shortest paths from a starting vertex s to all other vertices,
 * and output the shortest paths themselves.
 * ---
 * Time Complexity: O(n^2 + m), where n is the number of nodes / vertices and m is the number of edges
 * Space Complexity: O(n)
 */
public class DijkstraDenseGraph {

    public static void main(String[] args) {
        Map<Integer, List<Pair<Integer, Integer>>> graph = GraphBuilder.buildWithCost(new int[][]{{0, 1, 10}, {0, 2, 15}, {1, 3, 12}, {1, 5, 15}, {2, 4, 10}, {3, 4, 2}, {3, 5, 1}, {5, 4, 5}}, false);
        assertEquals(10, dijkstra(0, 1, graph));
        assertEquals(15, dijkstra(0, 2, graph));
        assertEquals(22, dijkstra(0, 3, graph));
        assertEquals(24, dijkstra(0, 4, graph));
        assertEquals(23, dijkstra(0, 5, graph));
    }

    private static int dijkstra(int s, int e, Map<Integer, List<Pair<Integer, Integer>>> graph) {
        int n = graph.size();

        int[] cost = new int[n];
        Arrays.fill(cost, Integer.MAX_VALUE);

        boolean[] visited = new boolean[n];

        cost[s] = 0;
        for (int i = 0; i < n; i++) {
            int index = -1;
            for (int j = 0; j < n; j++) {
                if (!visited[j] && (index == -1 || cost[j] < cost[index])) {
                    index = j;
                }
            }

            if (cost[index] == Integer.MAX_VALUE) break; // cum detcteaza ciclu?

            visited[index] = true;
            for (Pair<Integer, Integer> pair : graph.get(index)) {
                int to = pair.getKey();
                int costTo = pair.getValue();

                if (cost[index] + costTo < cost[to]) {
                    cost[to] = cost[index] + costTo;
                }
            }
        }

        return cost[e];
    }
}
