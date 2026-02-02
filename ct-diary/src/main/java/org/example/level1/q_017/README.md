# P.213 Q.17 [카드뭉치]
출처 : 프로그래머스
Level : 1

## 풀이 날짜
- 2026-01-17 O

## 문제 풀이
```java

```

## 접근 방식

## 개선사항
### ArrayDeque 확실히 공부할 
것
ArrayDeque<String> c1 = new ArrayDeque<>(Arrays.asList(card1)); 하면 한번에 
변환됨

ArrayDeque의 동작
| 동작             | Stack 메서드 | Queue 메서드 | 비고                        |
|-----------------|-------------|-------------|-----------------------------|
| 삽입             | push        | addLast     | Stack: front, Queue: rear  |
| 제거 + 반환      | pop         | pollFirst   | Stack: front, Queue: front |
| 확인만           | peek        | peekFirst   | Stack: front, Queue: front |
| 마지막 확인/삭제 | peekLast / pollLast | pollLast / peekLast | 덱에서 뒤쪽 조작 가능 |