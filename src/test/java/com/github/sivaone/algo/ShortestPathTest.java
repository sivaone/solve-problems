package com.github.sivaone.algo;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.junit.jupiter.api.Test;

import java.util.*;

public class ShortestPathTest {

    @Test
    void testShortestPath() {
        Map<String, String[]> graph = new HashMap<>();
        graph.put("w", new String[]{"x", "v"});
        graph.put("x", new String[]{"w", "y"});
        graph.put("y", new String[]{"x", "z"});
        graph.put("z", new String[]{"y", "v"});
        graph.put("v", new String[]{"z", "w"});
        graph.put("n", new String[]{"o"});

        System.out.println(shortestPath(graph, "w", "z")); // 2
        System.out.println(shortestPath(graph, "x", "o")); // -1
    }

    int shortestPath(Map<String, String[]> graph, String source, String destination) {

        int depth = 0;
        Set<String> visited = new HashSet<>();

        Queue<Pair<String, Integer>> queue = new LinkedList<>();
        queue.add(new ImmutablePair<>(source, depth));

        while (!queue.isEmpty()) {
            Pair<String, Integer> node = queue.remove();
            visited.add(node.getLeft());

            if (node.getLeft().equals(destination)) {
               return node.getRight();
            }

            for (String neighbor : graph.get(node.getLeft())) {
                if (!visited.contains(neighbor)) {
                    queue.add(new ImmutablePair<>(neighbor, node.getRight() + 1));
                }
            }
        }
        return -1;
    }
}
