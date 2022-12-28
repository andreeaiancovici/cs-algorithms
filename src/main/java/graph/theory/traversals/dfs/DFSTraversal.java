package graph.theory.traversals.dfs;

import helper.graph.GraphBuilder;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.Map;

/**
 * Time Complexity: O(n + m), where n is the number of nodes / vertices and m is the number of edges
 * Space Complexity: O(n + m), where n is the number of nodes / vertices and m is the number of edges
 */
public class DFSTraversal {

    public static void main(String[] args) {
        Map<Integer, List<Integer>> graph = GraphBuilder.build(new int[][]{{0, 1}, {1, 2}, {2, 0}}, true);
        boolean[] visited = new boolean[graph.size()];
        dfsRecursive(graph, 0, visited);

        System.out.println();
        visited = new boolean[graph.size()];
        dfsIterative(graph, 0, visited);
    }

    private static void dfsRecursive(Map<Integer, List<Integer>> graph, int node, boolean[] visited) {
        if (visited[node]) return;

        visited[node] = true;
        System.out.print(node + " ");

        List<Integer> neighbours = graph.get(node);
        for (int neighbour : neighbours) dfsRecursive(graph, neighbour, visited);
    }

    private static void dfsIterative(Map<Integer, List<Integer>> graph, int node, boolean[] visited) {
        Deque<Integer> stack = new ArrayDeque<>();

        visited[node] = true;
        System.out.print(node + " ");
        stack.push(node);

        while (!stack.isEmpty()) {
            node = stack.pop();

            List<Integer> neighbours = graph.get(node);
            for (int neighbour : neighbours) {
                if (!visited[neighbour]) {
                    visited[neighbour] = true;
                    System.out.print(neighbour + " ");
                    stack.push(neighbour);
                }
            }
        }
    }
}
