package helper.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GraphBuilder {

    public static Map<Integer, List<Integer>> build(int[][] edges, boolean isBiDirectional) {
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int i = 0; i < edges.length; i++) {
            addToGraph(graph, edges[i][0], edges[i][1]);
            if (isBiDirectional) addToGraph(graph, edges[i][1], edges[i][0]);
        }

        return graph;
    }

    private static void addToGraph(Map<Integer, List<Integer>> graph, int fromVertex, int toVertex) {
        List<Integer> list = graph.get(fromVertex);

        if (list == null) {
            list = new ArrayList<>();
            graph.put(fromVertex, list);
        }

        list.add(toVertex);
    }
}
