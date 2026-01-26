package org.example.level2.q_037;

import java.util.ArrayDeque;

class Solution {
  // 이동할 수 있는 방향을 나타내는 배열 rx, ry 선언
  private static final int[] rx = {0, 0, 1, -1};
  private static final int[] ry = {1, -1, 0, 0};
  // 두개를 조합하면 위, 아래 , 오른쪽, 왼쪽으로 이동하는게 모두 나와있음

  private static class Node{
    int x, y;
    public Node(int x, int y){
      this.x = x;
      this.y = y;
    }
  }

  // [[1,0,1,1,1],[1,0,1,0,1],[1,0,1,1,1],[1,1,1,0,1],[0,0,0,0,1]]
  public int solution(int[][] maps) {
    // 맵의 크기를 저장하는 변수 선언
    int N = maps.length;
    int M = maps[0].length;

    // 최단 거리를 저장할 배열 생성
    int[][] dist = new int[N][M]; // dist[x][y] == 0 -> 아직 방문하지 않은 칸 / dist[x][y] > 0 -> (0,0)에서 해당 칸까지의 최단 거리

    // bfs 탐색을 위한 큐 지정
    ArrayDeque<Node> queue = new ArrayDeque<>();
    queue.addLast(new Node(0, 0));
    dist[0][0] = 1;

    // queue가 빌 때까지 반복
    while(!queue.isEmpty()){
      Node now = queue.pollFirst();

      // 현재 위치에서 이동할 수 있는 모든 방향
      for(int i = 0 ; i < 4; i ++){
        int nx = now.x  + rx[i];
        int ny = now.y  + ry[i];

        // 맵 밖으로 나가는 경우 예외 처리
        if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue; // 배열 인덱스의 유효 범위가 0 이상, N 미만이기 때문

        // 벽으로 가는 경우 예외 처리
        if(maps[nx][ny] == 0) continue;

        // 이동한 위치가 처음 방문하는 경우, queue에 추가하고 거리 갱신
        if(dist[nx][ny] == 0){
          queue.addLast(new Node(nx, ny));
          dist[nx][ny] = dist[now.x][now.y] + 1; // 현재 칸까지의 거리 + 1 = 다음 칸까지의 거리
        }
      }
    }

    // 목적지까지 최단 거리 반환, 목적지에 도달하지 못한 경우에는 -1 반환
    return dist[N -1][M - 1] == 0 ? -1  :dist[N - 1][M -1];
  }
}