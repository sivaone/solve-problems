package com.github.sivaone.algo;

import org.junit.jupiter.api.Test;

import java.util.*;

public class BinaryTreeTest {

    @Test
    void testBinaryTree() {
        var a = new Node("a");
        var b = new Node("b");
        var c = new Node("c");
        var d = new Node("d");
        var e = new Node("e");
        var f = new Node("f");

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.right = f;

//        traverseBinaryTreeDepthFirst(a);
//        traverseBinaryTreeRecursive(a);
        traverseBinaryTreeBreadthFirst(a);
    }

    void traverseBinaryTreeDepthFirst(Node root) {
        Deque<Node> stack = new ArrayDeque<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node current = stack.pop();
            System.out.println(current.value);

            if (null != current.right) {
                stack.push(current.right);
            }

            if (null != current.left) {
                stack.push(current.left);
            }
        }
    }

    void traverseBinaryTreeRecursive(Node root) { // depth first
        if (null == root) return;

        System.out.println(root.value);
        traverseBinaryTreeRecursive(root.left);
        traverseBinaryTreeRecursive(root.right);
    }

    void traverseBinaryTreeBreadthFirst(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node current = queue.remove();
            System.out.println(current.value);

            if (null != current.left) {
                queue.add(current.left);
            }

            if (null != current.right) {
                queue.add(current.right);
            }
        }
    }

    void traverseBinaryTreeRecursiveBF(Node root) { // depth first
        if (null == root) return;

        System.out.println(root.value);
        traverseBinaryTreeRecursive(root.left);
        traverseBinaryTreeRecursive(root.right);
    }

}
