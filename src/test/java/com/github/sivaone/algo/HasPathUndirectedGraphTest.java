package com.github.sivaone.algo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class HasPathUndirectedGraphTest {

    // @Test
    void testBuildGraph() {
        // use list of entry objects as map doesn't allow duplicate keys
        Map<String, String> edges = new HashMap<>();
        edges.put("i", "j");
        edges.put("k", "i");
        edges.put("m", "k");
        edges.put("k", "l");
        edges.put("o", "n");
    }
    @Test
    void testHasPath() {
        Map<String, String[]> graph = new HashMap<>();
        graph.put("i", new String[]{"j", "k"});
        graph.put("j", new String[]{"i"});
        graph.put("k", new String[]{"i", "m", "l"});
        graph.put("m", new String[]{"k"});
        graph.put("l", new String[]{"k"});
        graph.put("o", new String[]{"n"});
        graph.put("n", new String[]{"o"});

        Assertions.assertTrue(hasPathDepthFirst(graph, "i", "l", new HashSet<>()));
        Assertions.assertFalse(hasPathDepthFirst(graph, "i", "n", new HashSet<>()));
    }

    boolean hasPathDepthFirst(Map<String, String[]> graph, String source, String destination, Set<String> visited) {
        if (source.equals(destination)) {
            return true;
        }

        if (visited.contains(source)) {
            return false;
        }
        visited.add(source);

        for(String neighbor : graph.get(source)) {
            if (hasPathDepthFirst(graph, neighbor, destination, visited)) {
                return true;
            }
        }

        return false;
    }

    Map<String, ArrayList<String>> buildGraph(Map<String, String> edges) {
        Map<String, ArrayList<String>> graph = new HashMap<>();

        for(Map.Entry<String, String> entry : edges.entrySet()) {
            if (!graph.containsKey(entry.getKey())) {
                graph.put(entry.getKey(), new ArrayList<>());
            }
            if(!graph.containsKey(entry.getValue())) {
                graph.put(entry.getValue(), new ArrayList<>());
            }
            graph.get(entry.getKey()).add(entry.getValue());
            graph.get(entry.getValue()).add(entry.getKey());
        }

        return graph;
    }
}
