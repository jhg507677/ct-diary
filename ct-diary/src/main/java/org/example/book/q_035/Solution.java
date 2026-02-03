package org.example.book.q_035;


import java.util.ArrayDeque;
import java.util.ArrayList;

// [너비 우선 탐색]으로 모든 그래프의 노드를 순회하는 함수를 작성하세요.
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
    visited = new boolean[n+1]; // 방문 여부를 저장할 배열
    answer = new ArrayList<>();
    bfs(start);

    return answer.stream().mapToInt(Integer::intValue).toArray();
  }


  // BFS 탐색 메서드
  private static void bfs(int start){

    // 탐색시 맨 처음 방문할 노드를 add하고 방문 처리
    ArrayDeque<Integer> queue = new ArrayDeque<>();
    queue.add(start);
    visited[start] = true;

    while(!queue.isEmpty()){

      // 큐에 있는 원소 중 가장 먼저 추가된 원소를 poll 하고 정답 리스트에 추가
      int now = queue.poll();
      answer.add(now);

      for(int next : adjList[now]){
        if(!visited[next]){
          queue.add(next);
          visited[next] = true;
        }
      }
    }
  }
}


