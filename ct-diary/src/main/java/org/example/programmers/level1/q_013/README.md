# P.172 Q.13 [크레인 인형뽑기 게임]
출처 : [출처, 예: 프로그래머스]
Level : 1

## 풀이 날짜
- 2026-01-17


## 문제 풀이
```java
import java.util.*;
class Solution {
    public int solution(int[][] board, int[] moves) {
        Stack<Integer> finalBucket = new Stack<>();
        Stack<Integer>[] bucketList = new Stack[board.length];
        
        // 5번 반복
        for(int i =0; i < board.length; i++){
            // 가장 처음에 넣은게 가장 마지막에 뽑혀야함
            for(int j =0; j < board[0].length; j++){
                bucketList[i].push(board[j][i]);
                // board[0][0] board[1][0]
                // 첫번째 버킷리스트에 0.0.0.4,3 넣어주고
            }
        }
        
        int result = 0;
        for(int i =0; i < moves.length; i++){
            if(bucketList[moves[i]-1].isEmpty()) continue;
            // bucketList[0]번째 값을 가져옴
            // 근데 0이라면 무시해얗마
            int getValue = bucketList[moves[i]-1].pop();
            if(getValue == 0) continue;
            
            if(finalBucket.isEmpty()) {
                finalBucket.push(getValue);    
                continue;
            }
    
            if(finalBucket.peek() == getValue){
                result++;
                finalBucket.pop();
            }else{
                finalBucket.push(getValue);    
            }
            
        }
        
        // 크레인을 모두 작동시킨 후 터트려져 사라진 인형의 갯수
        return result;
    }
}

```

## 접근 방식
- [문제를 어떻게 접근했는지 단계별로 정리]
- [예: 브루트포스, DFS/BFS, DP, 그리디, 해시 등]

## 개선사항
- 스택 배열 선언 방법 Stack;
- 반드시 스택을 배열로 선언한 후 각 인덱스마다 Stack 생성해줘야함


```java
<Integer>[] bucketList = new Stack[board.length];
for(int i=0; i<board.length; i++){
bucketList[i] = new Stack<>();
}
```
- 스택은 가장 처음에 넣은게 가장 마지막에 뽑히니까 역순으로 정렬해야함
- 연속된 두 인형 제거 하는거니까 result += 2;

## 정답
```java
import java.util.*;
class Solution {
    public int solution(int[][] board, int[] moves) {
        Stack<Integer> finalBucket = new Stack<>();
        Stack<Integer>[] bucketList = new Stack[board.length];
        
        for(int i=0; i<board.length; i++){
            bucketList[i] = new Stack<>();
        }
        
        // 5번 반복
        for(int i = board.length - 1; i >= 0; i--){
            // 스택은 가장 처음에 넣은 board[0][0]이 가장 마지막에 뽑히는 구조니까 역순으로 정렬해야함
            for(int j =0; j < board[0].length; j++){
                // 0은 푸시 안함
                if(board[i][j] != 0){
                    bucketList[j].push(board[i][j]);
                }
                // board[0][0] board[0][1]
                // 첫번째 버킷리스트에 0.0.0.4,3 넣어주고
            }
        }
        
        int result = 0;
        for(int i =0; i < moves.length; i++){
            if(bucketList[moves[i]-1].isEmpty()) continue;
            // bucketList[0]번째 값을 가져옴
            // 근데 0이라면 무시해얗마
            int getValue = bucketList[moves[i]-1].pop();
            
            if(finalBucket.isEmpty()) {
                finalBucket.push(getValue);    
                continue;
            }
    
            if(finalBucket.peek() == getValue){
                result += 2;
                finalBucket.pop();
            }else{
                finalBucket.push(getValue);    
            }
            
        }
        
        // 크레인을 모두 작동시킨 후 터트려져 사라진 인형의 갯수
        return result;
    }
}

```