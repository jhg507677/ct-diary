# P.181 Q.14 [표 편집]
출처 : 프로그래머스
Level : 3

## 풀이 날짜
- 2026.01.30 X
## 나의 풀이

```java
package org.example.programmers.level3.q_030;// 2021 카카오 채용연계형 인턴십

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

```

## 기술 회고
해당 문제는 삭제된 행은 계산하면 안되기때문에 배열이 아닌 연결리스트처럼 구현했어야함
next와 prev를 저장해놓고 해당 값이 삭제될 경우에는 삭제된 값은 스택으로 저장 따로하고
해당 행의 next와 prev의 연결을 삭제해주면 됨
Class로 구현할 필요는 없고 up, down 두개의 배열이 있으면 된다.
```java
int[] up = new int[n + 2]
int[] down = new int[n + 2]
for(int i = 0 ; i < n + 2; i++){
  up[i] = i - 1;
  down[i] = i + 1;
}
```
