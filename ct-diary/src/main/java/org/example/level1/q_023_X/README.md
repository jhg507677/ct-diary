# P.357 Q.31 [신고결과받기]
출처 : 프로그래머스
Level : 1

## 풀이 날짜
- 2026-02-01 X

## 문제 풀이
```java

```

## 접근 방식
HashMap을 반복문을 돌릴려면

```java
import java.util.HashMap;
import java.util.HashSet;

HashMap<String, HashSet<String>> reportedUser = new HashMap<>();
for(Map.Entry<String, HashSet<String>> entry : reportedUser.entrySet()){
  
}

// 혹은
reportedUser.forEach((reported, reporters) -> {
  reporters.forEach(reporter -> {
    System.out.println(reported + " 신고한 사람: " + reporter);
  
    });
});
```

## 기술 회고


