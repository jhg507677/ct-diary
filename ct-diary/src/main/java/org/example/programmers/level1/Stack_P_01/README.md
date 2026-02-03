# P.172 Q.13 [같은 숫자는 싫어]
출처 : [출처, 예: 프로그래머스]
Level : 1

## 풀이 날짜
- 2026-01-17

## 정답
```java
public class Solution {
    public int[] solution(int []arr) {
        ArrayList<Integer> result = new ArrayList<>();
        int last = -1; // 마지막 추가한 값 저장 (arr에 음수 없다고 가정)
        
        for(int num : arr){
            if(num != last){ // 이전 값과 다르면 추가
                result.add(num);
                last = num;
            }
        }
        
        // ArrayList -> int[]
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
```
반복문 하나로 가능했네...?

## 접근 방식

## 개선사항
- Queue에서는 값 비교할ㄷ peekLast()로 비교해야함