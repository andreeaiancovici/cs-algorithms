package graph.grokking;

import helper.graph.GraphBuilder;

import java.util.*;

/**
 * Question:
 * Topological Sort of a directed graph (a graph with unidirectional edges) is a linear ordering of its
 * vertices such that for every directed edge (U, V) from vertex U to vertex V, U comes before V in the ordering.
 * Given a directed graph, find the topological ordering of its vertices.
 * ---
 * Time Complexity: O(n + m), where n is the number of nodes / vertices and m is the number of edges
 * Space Complexity: O(n + m), where n is the number of nodes / vertices and m is the number of edges
 */
public class _1_1_TopologicalSort {

    public static void main(String[] args) {
        solution(GraphBuilder.build(new int[][]{{3, 2}, {3, 0}, {2, 0}, {2, 1}}, false));

        System.out.println();

        solution(GraphBuilder.build(new int[][]{{4, 2}, {4, 3}, {2, 0}, {2, 1}, {3, 1}}, false));

        System.out.println();

        solution(GraphBuilder.build(new int[][]{{6, 4}, {6, 2}, {5, 3}, {5, 4}, {3, 0}, {3, 1}, {3, 2}, {4, 1}}, false));
    }

    private static void solution(Map<Integer, List<Integer>> graph) {
        Map<Integer, Integer> inDegree = new HashMap<>();
        for (Map.Entry<Integer, List<Integer>> entry : graph.entrySet()) {
            for (int node : entry.getValue()) {
                inDegree.put(node, inDegree.getOrDefault(node, 0) + 1);
            }
        }

        Deque<Integer> sourcesQueue = new ArrayDeque<>();
        for (Map.Entry<Integer, List<Integer>> entry : graph.entrySet()) {
            int node = entry.getKey();
            if (!inDegree.containsKey(node)) {
                sourcesQueue.add(node);
            }
        }

        while (!sourcesQueue.isEmpty()) {
            int node = sourcesQueue.poll();

            System.out.print(node + " ");

            List<Integer> neighbours = graph.get(node);
            for (int neighbour : neighbours) {
                inDegree.put(neighbour, inDegree.get(neighbour) - 1);
                if (inDegree.get(neighbour) == 0) sourcesQueue.add(neighbour);
            }
        }
    }
}
