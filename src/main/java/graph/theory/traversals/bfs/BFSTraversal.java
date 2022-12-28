package graph.theory.traversals.bfs;

import helper.graph.GraphBuilder;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.Map;

/**
 * Time Complexity: O(n + m), where n is the number of nodes / vertices and m is the number of edges
 * Space Complexity: O(n + m), where n is the number of nodes / vertices and m is the number of edges
 */
public class BFSTraversal {

    public static void main(String[] args) {
        Map<Integer, List<Integer>> graph = GraphBuilder.build(new int[][]{{0, 1}, {1, 2}, {2, 0}}, true);
        boolean[] visited = new boolean[graph.size()];
        bfs(graph, 0, visited);
    }

    private static void bfs(Map<Integer, List<Integer>> graph, int node, boolean[] visited) {
        Deque<Integer> queue = new ArrayDeque<>();

        visited[node] = true;
        System.out.print(node + " ");
        queue.add(node);

        while (!queue.isEmpty()) {
            node = queue.poll();

            List<Integer> neighbours = graph.get(node);
            for (int neighbour : neighbours) {
                if (!visited[neighbour]) {
                    visited[neighbour] = true;
                    System.out.print(neighbour + " ");
                    queue.add(neighbour);
                }
            }
        }
    }
}
