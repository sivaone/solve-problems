package com.github.sivaone.algo;

import org.junit.jupiter.api.Test;

import java.util.*;

class GraphTraversalDirectedGraphTest {

    @Test
    void test() {

        Map<String, String[]> graph = new HashMap<>();
        graph.put("a", new String[]{"b", "c"});
        graph.put("b", new String[]{"d"});
        graph.put("d", new String[]{"f"});
        graph.put("c", new String[]{"e"});
        graph.put("e", new String[0]);
        graph.put("f", new String[0]);

        // Depth first traversal
        System.out.println("Depth first traversal");
        Deque<String> stack = new ArrayDeque<>();
        String root = "a";
        stack.push(root);

        while (!stack.isEmpty()) {
            String text = stack.pop();
            System.out.println(text);
            String[] nbrs = graph.get(text);
            for (String nbr : nbrs) {
                stack.push(nbr);
            }
        }

        // Breadth first traversal
        System.out.println("Breadth first traversal");
        Queue<String> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            String text = queue.remove();
            System.out.println(text);
            String[] nbrs = graph.get(text);
            for (String nbr : nbrs) {
                queue.add(nbr);
            }
        }

    }
}