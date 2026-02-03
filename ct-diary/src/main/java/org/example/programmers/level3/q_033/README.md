# P.181 Q.14 [섬 연결하기]
출처 : 프로그래머스
Level : 3

## 풀이 날짜
- 2026.02.02 X

## 문제 풀이
```java
import java.util.*;
class Solution {
  private static int[] parent;

  // 사이클이 있으면 안됨, 사이클이 있다는 조건 -> 두 노드의 부모 노드가 같다
  private static int find(int x){
    if(parent[x] == x) return x;
    return parent[x] = find(parent[x]);
  }


  // 다리 잇기
  private static void union(int a, int b){
    parent[find(b)] = find(a);
  }



  public int solution(int n, int[][] costs) {
    int answer = 0;

    // 최소의 비용으로 모든 섬이 통행 가능하게 해야하니 비용을 기준으로 오름차순
    Arrays.sort(costs, (o1, o2) -> Integer.compare(o1[2], o2[2]));

    // parent 배열 초기화
    parent = new int[costs.length];
    for(int i = 0; i < costs.length; i++){
      parent[i] = i;
    }

    int result = 0; // 최소 신장 트리의 총 비용
    int edges = 0;

    for(int[] edge : costs){

      // 다리 수가 n-1이라면 모두 연결되었으니 종료             
      if(edges == n - 1) break;

      // 사이클을 형성하는지 체크
      if(find(edge[0]) == find(edge[1])) continue;
      union(edge[0], edge[1]);
      result += edge[2];
      edges++;
    }
    return result;
  }
}
```

## 기술 회고

