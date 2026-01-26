package org.example.Book.q_DFS_Map;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution {

  // DFS 함수
  static void dfs(
    String node,
    Map<String, List<String>> graph,
    Set<String> visited
  ) {
    // 이미 방문했으면 종료
    if (visited.contains(node)) return;

    // 방문 처리
    visited.add(node);
    System.out.print(node + "방문 완료");

    // 인접 노드 가져오기
    List<String> neighbors = graph.get(node);

    // 알파벳 오름차순 방문
    Collections.sort(neighbors);

    // 깊이 우선 탐색
    for (String next : neighbors) {
      dfs(next, graph, visited);
    }
  }

  public static void main(String[] args) {

    // 그래프 생성 (Map 기반 인접 리스트)
    Map<String, List<String>> graph = new HashMap<>();

    graph.put("Start", new ArrayList<>(List.of("B", "A")));
    graph.put("A", new ArrayList<>(List.of("C", "D")));
    graph.put("B", new ArrayList<>(List.of("E")));
    graph.put("C", new ArrayList<>());
    graph.put("D", new ArrayList<>(List.of("F")));
    graph.put("E", new ArrayList<>(List.of("F")));
    graph.put("F", new ArrayList<>());
    Set<String> visited = new HashSet<>(); // 방문 기록

    // DFS 실행
    dfs("Start", graph, visited);
  }
}