# P.357 Q.31 [폰켓몬]
출처 : 프로그래머스
Level : 1

## 풀이 날짜
- 2026-01-18 O

## 문제 풀이
```java

```

## 접근 방식

## 기술 회고
반복문으로 HashSet에 값을 넣는 방식도 있지만 아래 방식도 있다.
다만 시간 복잡도 똑같으니까 기억 안나면 반복문쓰자
```java
HashSet<Integer> set = Arrays.stream(nums).boxed.collect(Collectors.toCollection(HashSet::new));
```

