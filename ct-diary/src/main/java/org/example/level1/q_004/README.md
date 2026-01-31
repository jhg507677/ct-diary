# P.172 Q.13 [두 개 뽑아서 더하기]
출처 : 프로그래머스
Level : 1
사용 알고리즘 : 트리
## 풀이 날짜
- 2026-01-26

## 문제 풀이
```java
import java.util.*;

class Solution {
    // answers : 정답 최대 10000개
    public ArrayList<Integer> solution(int[] answers) {
        ArrayList<Integer> result = new ArrayList<>(Arrays.asList(0,0,0));
        // return : 가장 많은 문제를 맞힌 사람, 동점일 경우 오름차순
        int[][] pattern = {
            {1, 2, 3, 4, 5}
            ,{2, 1, 2, 3, 2, 4, 2, 5}
            ,{3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
            };
            
        
        for(int i = 0 ; i < answers.length; i++){
            // 각 패턴만큼 반복
            for(int j = 0 ; j < pattern.length; j++){
                if(i > pattern[j].length){
                    if(answers[i] == pattern[j][i % pattern[j].length]) {
                        result.set(j , result.get(j)+1);
                    }  
                }else{
                    if(answers[i] == pattern[j][i]) {
                        // result의 0번 인딕스 값을 기존의 0번인덱스 값을 꺼내서 +1
                        result.set(j , result.get(j)+1);
                    }  
                }
                
            }
        }
                   
        // 정렬
        // max 구하는 스트림이 기억이 안나서
        // int max = Arrays.stream(result).max();
        int max = result.get(0);// result : {5. 10. 28}
        for(int item : result){
            if(item > max) max = item;
        }
        
      ArrayList<Integer> answerList = new ArrayList<>();
        for(int i = 0; i < result.size(); i++){
            if(result.get(i) == max){
                answerList.add(i+1); // 문제에서 사람 번호는 1부터
            }
        }
        
        return answerList;
    }
}
```

## 접근 방식

## 기술회고
- ArrayList 제발 초기화해야함!!!!  
  ArrayList<Integer> result = new ArrayList<>(Arrays.asList(0,0,0));
- i는 0부터 시작한다는걸..놓쳤다..
```java
if(answers[i] == pattern[j][i % pattern[j].length]) {
  ```

- ArrayList는 삭제하면 안된다. index shift 때문에, 새 리스트에 넣어야함
```java
ArrayList<Integer> answerList = new ArrayList<>();
for(int i = 0; i < result.size(); i++){
    if(result.get(i) == max){
        answerList.add(i+1); // 문제에서 사람 번호는 1부터
    }
}
```