package org.example.book.q_034;


import java.util.ArrayList;

// [깊이 우선 탐색]으로 모든 그래프의 노드를 순회하는 함수를 작성하세요.
class Solution
{
  // 인접리스트를 저장할 배열
  private static ArrayList<Integer>[] adjList;

  // 방문 여부를 저장할 boolean 배열
  private static boolean[] visited;
  private static ArrayList<Integer> answer;

  // graph = [[1,2],[2,3],[3,4],[4,5]]
  private static int[] Solution(int[][]graph, int start, int n){
    // 인접리스트 초기화(노드의 수 + 1)
    adjList = new ArrayList[n + 1];
    for(int i  =0; i < adjList.length; i++){
      adjList[i] = new ArrayList<>();
    }

    // 그래프를 인접리스트로 변환
    for(int[] edge : graph){
      adjList[edge[0]].add(edge[1]);
      // adjList[1].add(2)
    }

    // DFS를 순회한 결과를 반환
    visited = new boolean[n+1];
    answer = new ArrayList<>();
    dfs(start);

    return answer.stream().mapToInt(Integer::intValue).toArray();
  }

  private static void dfs(int now){
    visited[now] = true; // 현재 노드를 방문했음을 저장
    answer.add(now); // 현재 노드를 결과 리스트에 추가

    for(int next : adjList[now]){
      if(!visited[next]){
        dfs(next);
      }
    }
  }
}


