package graph.grokking;

import helper.graph.GraphBuilder;

import java.util.*;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Question:
 * Find if a given Directed Graph has a cycle in it or not.
 * ---
 * Time Complexity: O(n + m), where n is the number of nodes / vertices and m is the number of edges
 * Space Complexity: O(n + m), where n is the number of nodes / vertices and m is the number of edges
 */
public class _1_2_DetectCycleInDirectedGraph {

    public static void main(String[] args) {
        assertTrue(solution(GraphBuilder.build(new int[][]{{3, 2}, {3, 0}, {2, 0}, {2, 1}}, false)));
        assertFalse(solution(GraphBuilder.build(new int[][]{{3, 2}, {3, 0}, {2, 0}, {2, 1}, {1, 3}}, false)));
    }

    private static boolean solution(Map<Integer, List<Integer>> graph) {
        List<Integer> topologicalSortedList = new ArrayList<>();

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

            topologicalSortedList.add(node);

            List<Integer> neighbours = graph.get(node);
            for (int neighbour : neighbours) {
                inDegree.put(neighbour, inDegree.get(neighbour) - 1);
                if (inDegree.get(neighbour) == 0) sourcesQueue.add(neighbour);
            }
        }

        return topologicalSortedList.size() == graph.size();
    }
}
