package graph.grokking;

import helper.graph.GraphBuilder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Question:
 * There are ‘N’ tasks, labeled from ‘0’ to ‘N-1’. Each task can have some prerequisite tasks which need to be completed
 * before it can be scheduled. Given the number of tasks and a list of prerequisite pairs, find out if it is possible to
 * schedule all the tasks.
 * ---
 * Time Complexity:
 * Space Complexity:
 */
public class _2_1_TasksScheduling {

    public static void main(String[] args) {
        assertTrue(solution(3, new int[][]{{0, 1}, {1, 2}}));
        assertFalse(solution(3, new int[][]{{0, 1}, {1, 2}, {2, 0}}));
    }

    private static boolean solution(int n, int[][] taskDependencies) {
        Map<Integer, List<Integer>> graph = GraphBuilder.build(taskDependencies, false);

        Map<Integer, Integer> inDegree = new HashMap<>();
        for (Map.Entry<Integer, List<Integer>> entry : graph.entrySet()) {
            for (int node : entry.getValue()) {
                inDegree.put(node, inDegree.getOrDefault(node, 0) + 1);
            }
        }

        return true;//todo
    }
}
