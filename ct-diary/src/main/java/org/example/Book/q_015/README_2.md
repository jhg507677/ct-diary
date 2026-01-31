# P.172 Q.13 [요세푸스 문제]
출처 : 코딩테스트 합격자 되기
Level : -

## 풀이 날짜
- 2026-01-17 X
- 2026-01-30 X

## 정답

## 접근 방식

## 기술 회고
1. while(queue.size() == 1) while문 범위 잘 적자!! while(queue.size() > 1)로 적어야한다!
2. 반복문 틀림
```java
// 마지막 한 명 남을 때까지
while (queue.size() > 1) {

  // K-1명만 뒤로 보냄
  for (int i = 0; i < K - 1; i++) {
    queue.addLast(queue.pollFirst());
  }

  // K번째 사람 제거
  queue.pollFirst();
}

```
## 회고




