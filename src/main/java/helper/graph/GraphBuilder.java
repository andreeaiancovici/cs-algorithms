package helper.graph;

import org.apache.commons.lang3.tuple.MutablePair;
import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GraphBuilder {

    public static Map<Integer, List<Integer>> build(int[][] edges, boolean isBiDirectional) {
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int[] edge : edges) {
            addToGraph(graph, edge[0], edge[1]);
            if (isBiDirectional) addToGraph(graph, edge[1], edge[0]);
            else graph.computeIfAbsent(edge[1], k -> new ArrayList<>());
        }

        return graph;
    }

    public static Map<Integer, List<Pair<Integer, Integer>>> buildWithCost(int[][] edges, boolean isBiDirectional) {
        Map<Integer, List<Pair<Integer, Integer>>> graph = new HashMap<>();

        for (int[] edge : edges) {
            addToGraph(graph, edge[0], edge[1], edge[2]);
            if (isBiDirectional) addToGraph(graph, edge[1], edge[0], edge[2]);
            else graph.computeIfAbsent(edge[1], k -> new ArrayList<>());
        }

        return graph;
    }

    private static void addToGraph(Map<Integer, List<Integer>> graph, int fromVertex, int toVertex) {
        List<Integer> list = graph.computeIfAbsent(fromVertex, k -> new ArrayList<>());

        list.add(toVertex);
    }

    private static void addToGraph(Map<Integer, List<Pair<Integer, Integer>>> graph, int fromVertex, int toVertex, int cost) {
        List<Pair<Integer, Integer>> list = graph.computeIfAbsent(fromVertex, k -> new ArrayList<>());

        list.add(new MutablePair<>(toVertex, cost));
    }
}
