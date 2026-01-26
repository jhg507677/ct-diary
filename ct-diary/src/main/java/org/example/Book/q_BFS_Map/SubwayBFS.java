package org.example.Book.q_BFS_Map;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class SubwayBFS {

  static class Node {
    String station;
    int distance;

    Node(String station, int distance) {
      this.station = station;
      this.distance = distance;
    }
  }

  static void bfs(
    String start,
    String target,
    Map<String, List<String>> graph
  ) {
    Queue<Node> queue = new LinkedList<>();
    Set<String> visited = new HashSet<>();

    queue.offer(new Node(start, 0));
    visited.add(start);

    System.out.println("방문 순서:");

    while (!queue.isEmpty()) {
      Node current = queue.poll();
      String station = current.station;
      int dist = current.distance;

      // 목적지 도착 시 즉시 종료
      if (station.equals(target)) {
        System.out.println("\n\n최단 거리: " + dist);
        return;
      }
      List<String> neighbors = graph.get(station);
      Collections.sort(neighbors); // 알파벳 순서

      // 인접 노드 방문
      for (String next : neighbors) {
        if (!visited.contains(next)) {
          visited.add(next);
          queue.offer(new Node(next, dist + 1));
        }
      }
    }
  }

  public static void main(String[] args) {

    Map<String, List<String>> subwayMap = new HashMap<>();

    subwayMap.put("Home", new ArrayList<>(List.of("Station_A", "Station_B")));
    subwayMap.put("Station_A", new ArrayList<>(List.of("Station_C", "Station_D")));
    subwayMap.put("Station_B", new ArrayList<>(List.of("Station_E")));
    subwayMap.put("Station_C", new ArrayList<>(List.of("Company")));
    subwayMap.put("Station_D", new ArrayList<>(List.of("Station_F")));
    subwayMap.put("Station_E", new ArrayList<>(List.of("Station_G")));
    subwayMap.put("Station_F", new ArrayList<>(List.of("Company")));
    subwayMap.put("Station_G", new ArrayList<>(List.of("Station_H")));
    subwayMap.put("Station_H", new ArrayList<>(List.of("Company")));
    subwayMap.put("Company", new ArrayList<>());

    bfs("Home", "Company", subwayMap);
  }
}