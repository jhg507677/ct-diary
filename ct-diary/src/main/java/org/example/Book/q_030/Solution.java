package org.example.Book.q_030;

import java.util.ArrayList;

// 집합 유니온-파인드 알고리즘 구현하기
class Solution
{
  private static int[] parent;

  // 부모 노드 찾기
  private static int find(int x){
    // parent[x]는 부모노드
    if(parent[x] == x) return x;

    parent[x] = find(parent[x]);

    // 집합은 깊이가 1이라서 바로 부모노드 전달해도 됨
    return parent[x];
  }

  private static void union(int x, int y){
    int root1 = find(x);
    int root2 = find(y);
    parent[root2] = root1; // y가 속한 집합을 x가 속한 집합에 합침
  }

  private static Boolean[] solution(int k, int[][] operation){
    parent = new int[k];

    // 처음에는 노드가 자기 자신을 부모로 가지도록 초기화
    for(int i = 0; i < k; k++){
      parent[i] = 1;
    }

    ArrayList<Boolean> answer = new ArrayList<>();
    // [0, 0, 1]
    for(int[] op : operation){
      if(op[0] == 0){
        union(op[1], op[2]);
      }else{
        answer.add(find(op[1]) == find(op[1]));
      }
    }
    return answer.toArray(new Boolean[0]);
  }
}


