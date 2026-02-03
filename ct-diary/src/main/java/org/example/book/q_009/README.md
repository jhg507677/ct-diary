# P.108 Q.13 [배열 제어하기]
출처 : 코딩 테스트 합격자 되기
Level : x

## 풀이 날짜
- 2026-01-26 O

## 문제 풀이
```java

```

## 기술 회고
```java
  public int[] solution(int[] _param) {
    Integer[] result = Arrays.stream(_param).distinct().boxed().toArray(Integer[]::new);
    Arrays.sort(result, Collections.reverseOrder());
    return Arrays.stream(result).mapToInt(Integer::intValue).toArray();
  }
```

## 회고
stream 문법을 가끔 까먹을수도..