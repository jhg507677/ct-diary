# P.172 Q.13 [예상 대진표]
출처 : 프로그래머스
Level : 2
사용 알고리즘 : 트리

## 풀이 날짜
- 2026-01-18 X

## 정답
```java
class Solution {
    public int solution(int N, int A, int B) {
        int round = 0;
        while (A != B) {
            A = (A + 1) / 2;
            B = (B + 1) / 2;
            round++;
        }
        return round;
    }
}
```

## 접근 방식

## 기술 회고
Math.ceil(A/2.0) =(A+1)/2 와 같다. double을 사용하지 않기 때문에 계산이 더욱 간단해짐

## 회고
트리문제가 아니라 매우 간단한 문제..





