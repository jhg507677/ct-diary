package org.example.book.q_030;

import java.util.ArrayList;

// 집합 유니온-파인드 알고리즘 구현하기
// k = 3
// operations : [[0,0,1],[0,1,2],[1,1,2]]
// result : [true]
// operations 배열은 수행할 연산을 말한다.
// ex) [0,0,1]: 노드 0과 노드 1의 union 연산 수행
// ex) [1,1,2]: 노드 1과 3이 같은 집합이라면 true, 그렇지 않으면 false

class Solution
{
  private static int[] parent;

  // 루트 노드 찾기
  private static int find(int x){
    if(parent[x] == x) return x;
    parent[x] = find(parent[x]);
    return parent[x];
  }

  // 합치기
  private static void union(int a, int b){
    parent[find(b)] = find(a);
  }

  static ArrayList<Boolean> result = new ArrayList<>();
  private static Boolean[] solution(int k, int[][] operation){

    // 배열 생성 필요
    parent = new int[k];

    // 굳이 0부터 값 넣어줘야해????????????????????????????????????
    for(int i = 1; i < k + 1; i++){
      parent[i] = i;
    }

    for(int[] item : operation){

      // 유니온 연산이라면
      if(item[0] == 0){
        union(item[1], item[2]);
      }else{
        result.add(find(item[1]) == find(item[2]));
      }
    }

    return result.toArray(Boolean[]::new);
  }
}


