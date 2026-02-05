```java
import java.util.*;

/**
문제: 중복 허용 순열

1부터 N까지 번호가 적힌 구슬이 있습니다.
이 중 중복을 허용하여 M번을 뽑아 일렬로 나열하는 방법을 모두 출력하세요.

입력
N: 구슬 개수
M: 뽑는 횟수

출력: 가능한 모든 순열을 문자열 배열 형태로 반환

예시: N = 3, M = 2

출력:
[ "1 1", "1 2", "1 3",
  "2 1", "2 2", "2 3",
  "3 1", "3 2", "3 3" ]
*/
class Solution {
  static int[] result;
  static int n;
  static int m;
  
  public void DFS(int level){
    if(level == m){
      // [1 , 1]
      for(int x : result) System.out.print(x + " ");
      System.out.println();
    }else{
      for(int i = 1; i< n+1; i++){
//        DFS(0): result[0] = 1 → DFS(1) 호출
//        DFS(1): result[1] = 1 → DFS(2) 호출
//        DFS(2): [1, 1] 출력 → return
//        Call 남은 For문 돔, i는 2를 실행해야함/DFS(1): result[1] = 2 → DFS(2) 호출
//        DFS(2): [1, 2] 출력 → return
//        Call 남은 For문 돔, i는 3를 실행해야함/DFS(1): result[1] = 3 → DFS(2) 호출
//        DFS(2): [1, 3] 출력 → return
        
//        DFS(1)은 For문 다 돌았기때문에 사라지고 /
//        Call DFS(0) 남은 For문 돔, i는 2를 실행해야함/ 이때 level은 0
//        DFS(0): result[0] = 2 → DFS(1) 호출
//        DFS(1): result[1] = 1 → DFS(2) 호출
//        DFS(2): [2, 1] 출력 → return
        
//          DFS(1): result[1] = 2 → DFS(2) 호출
//        DFS(2): [2, 2] 출력 → return
//          DFS(1): result[1] = 3 → DFS(2) 호출
//        DFS(2): [2, 3] 출력 → return
//          DFS(0): result[0] = 3 → DFS(1) 호출
        
//        DFS(1): result[1] = 1 → DFS(2) 호출
//        DFS(2): [3, 1] 출력 → return
//          DFS(1): result[1] = 2 → DFS(2) 호출
//        DFS(2): [3, 2] 출력 → return
//          DFS(1): result[1] = 3 → DFS(2) 호출
//        DFS(2): [3, 3] 출력 → return
        result[level] = i;
        DFS(level + 1);
      }
    }
  }
  
  public void solution(int _n, int _m) {
      n = _n;
      m = _m;
      result = new int[m];
      DFS(0);
  }

  public static void main(String[] args) {
      Solution sol = new Solution();
      System.out.println(Arrays.toString(sol.solution(3, 2)));
      // 출력: [1 1, 1 2, 1 3, 2 1, 2 2, 2 3, 3 1, 3 2, 3 3]
  }
}
```