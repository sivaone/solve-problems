package com.github.sivaone.algo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class HasPathDirectedGraphTest {

    @Test
    void testHasPathAcyclic() {
        Map<String, String[]> graph = new HashMap<>();
        graph.put("f", new String[]{"g", "i"});
        graph.put("g", new String[]{"h"});
        graph.put("h", new String[0]);
        graph.put("i", new String[]{"g", "k"});
        graph.put("j", new String[]{"i"});
        graph.put("k", new String[0]);

       Assertions.assertTrue(hasPath(graph, "f", "k"));
       Assertions.assertFalse(hasPath(graph, "j", "f"));

        Assertions.assertTrue(hasPathBreadthFirst(graph, "f", "k"));
        Assertions.assertFalse(hasPathBreadthFirst(graph, "j", "f"));
    }

    boolean hasPath(Map<String, String[]> graph, String source, String destination) {
        if ( source.equals(destination)) {
            return true;
        }

        for(String neighbor : graph.get(source)) {
            if (hasPath(graph, neighbor, destination)) {
                return true;
            }
        }

        return false;
    }

    boolean hasPathBreadthFirst(Map<String, String[]> graph, String source, String destination) {
        Queue<String> queue = new LinkedList<>();
        queue.add(source);

        while (!queue.isEmpty()) {
            var current = queue.remove();
            if (current.equals(destination)) {
                return true;
            }
            for(String neighbor : graph.get(current)) {
                queue.add(neighbor);
            }
        }

        return false;
    }
}
