package com.company;

// LC 127. Topological Sorting
// bfs solution

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

class DirectedGraphNode {
    int label;
    ArrayList<DirectedGraphNode> neighbors;
    DirectedGraphNode(int x) {
        label = x;
        neighbors = new ArrayList<>();
    }
}

public class Main {

    public static ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        ArrayList<DirectedGraphNode> result = new ArrayList<>();

        HashMap<DirectedGraphNode, Integer> map = new HashMap<>();
        for (DirectedGraphNode node : graph) {
            for (DirectedGraphNode nei : node.neighbors) {
                if (map.containsKey(nei)) {
                    map.put(nei, map.get(nei) + 1);
                } else {
                    map.put(nei, 1);
                }
            }
        }

        Queue<DirectedGraphNode> queue = new LinkedList<>();
        for (DirectedGraphNode node : graph) {
            if (!map.containsKey(node)) {
                result.add(node);
                queue.offer(node);
            }
        }
        while (!queue.isEmpty()) {
            DirectedGraphNode node = queue.poll();
            for (DirectedGraphNode nei : node.neighbors) {
                map.put(nei, map.get(nei) - 1);
                if (map.get(nei) == 0) {
                    result.add(nei);
                    queue.offer(nei);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        // write your code here
        ArrayList<DirectedGraphNode> graph = new ArrayList<>();
        DirectedGraphNode node = new DirectedGraphNode(0);
//        node.neighbors = new ArrayList<>();
        DirectedGraphNode node1 = new DirectedGraphNode(10);
        node.neighbors.add(node1);
        DirectedGraphNode node2 = new DirectedGraphNode(20);
        node1.neighbors.add(node2);
        DirectedGraphNode node3 = new DirectedGraphNode(3);
//        node.neighbors.add(node3);

        graph.add(node);
        graph.add(node1);
        graph.add(node2);
        graph.add(node3);
        ArrayList<DirectedGraphNode> list = topSort(graph);
        System.out.println(list.get(0).label);
        System.out.println(list.get(1).label);
        System.out.println(list.get(2).label);
        System.out.println(list.get(3).label);
    }
}