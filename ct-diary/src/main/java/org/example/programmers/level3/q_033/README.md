# P.181 Q.14 [섬 연결하기]
출처 : 프로그래머스
Level : 3

## 풀이 날짜
- 2026.02.02 X

## 나의 풀이
```java
package org.example.programmers.level3.q_033;// 2021 카카오 채용연계형 인턴십

class Solution {
  // n: 표의 행의 갯수
  // k: 처음 선택된 행의 갯수
  // cmd: ["D 2","C","U 3","C","D 4","C","U 2","Z","Z"]
  public String solution(int n, int k, String[] cmd) {
    String answer = "";
    int[] box = new int[n];

    // 삭제된 행은 0, 변함없는 행은 1로 표기

    // cmd의 길이만큼 반복해서 첫 글자를 보고 액션
    // 삭제된 행은 -1로 표기
    for(int i = 0; i < cmd.length; i++){
      char[] moveCount = cmd[i].split(" ");


      // 아 삭제된 행은 계산하면 안되는데!!!! 어떻게하지 그걸????
      // 만약에 값을 복사하면? 삭제된 행을 기록하는 표랑 실제로 삭제하는 표, 그럼 행번호를 기록해서

      // int[?] = 1인것으로부터 char[1] 값의 밑으로 가서 행 선택
      if(char[0] == "D"){
        // 만약에 ['D','2']
        // moveCount[1]은 2
        // 선택된 칸은 2
        if(k + moveCount[1] >= n -1) {
          k = n -1;
        }else{
          k = box[moveCount[1] + k;
        }
      }else if(char[0] == "U"){
        if(k - moveCount[1] <= 0) {
          k = 0;
        }else {
          k = k -  moveCount[1];
        }
        continue;
      }else if(char[0] == "C"){
        box[k] = 0;
                else int[k - moveCount[1]] = 0;
        continue;
      }else{ // Z
        if(k - moveCount[1] <= 0) box[0] = 0;
        else int[k - moveCount[1]] = 0;
        continue;
      }
    }

    // 삭제되지 않은 행은 O, 삭제된 행은 X로
    return answer;
  }
}
```
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

