# P.162 Q.11 [방문 길이]
출처 : 프로그래머스

## 접근 방식


## 개선사항


## 히스토리
- 260126 O

## 기술회고
```java
  Map<Character, int[]> manual = Map.of(
      'U', new int[]{0, 1},
      'D', new int[]{0, -1},
      'R', new int[]{1, 0},
      'L', new int[]{-1, 0}
    );
```