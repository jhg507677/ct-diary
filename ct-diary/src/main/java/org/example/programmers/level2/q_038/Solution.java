package org.example.programmers.level2.q_038;

import java.util.ArrayDeque;


class Solution {
  private static boolean[] visit;
  private static int[][] computer;

  private static void dfs(int now){
    visit[now] = true;
    for(int i = 0; i < computer[now].length; i++){

      // 연결되어 있지만 방문하지 않는 노드라면
      if(computer[now][i] == 1 && !visit[i]){
        dfs(i);
      }
    }
  }

  public int solution(int n, int[][]computers){
    int answer = 0;
    computer = computers;
    visit = new boolean[n];

    for(int i = 0; i < n; i++) {
      if(!visit[i]){
        dfs(i);
        answer++;
      }
    }
  }

}