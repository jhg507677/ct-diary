# P.213 Q.17 [완주하지 못한 선수]
출처 : 프로그래머스
Level : 1

## 풀이 날짜
- 2026-01-17 O

## 문제 풀이
```java

```

## 접근 방식

## 개선사항
### 
- 문제를 제대로 읽지 않아서 동명이인이 있다는걸 나중에 알았고
-  for(String key : hash.keySet()){
   if(hash.get(key) != 0) return key;
   }
해당 함수가 기억이 안났음(hash.keySet())
- 그리고 다른 사람은 반복문 2개로 품
- getOrDefault를 사용하면 containsKey 분기 태울 필요 없이 아래처럼 작동 가능
```java
 for (String player : participant) hm.put(player, hm.getOrDefault(player, 0) + 1);
```


와 근데 완주한 사람 - 참여자를 하면 반복문 2개만 써도됨!! 같은 빅오N이긴 하지만 