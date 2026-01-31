# P.208 Q.16 [기능개발]
출처 : 프로그래머스
Level : 2

## 풀이 날짜
- 2026-01-30 --

## 문제
```java

```

## 접근 방식


## 기술 회고 
거의 다 왔는데 마지막 값 처리 하는 것에서 막힘
max를 변경해주고 count는 1로 변경, 그리고 마지막에 result.add(count)가 반드시 필요
```java
    while(!leftDayList.isEmpty()){ // 3,9
      int item = leftDayList.pollFirst();
      // 이전값 7은 9보다 작기 때문에 이전값들 모두 제출

      // 남은 9는 어떻게 하지
      // 남은값들을 처리하는 법을 모르겠네..
      if(max < item) {
        result.add(count);
        max = item;
        count = 1;
      }

      // 이전값 7은 7과 같기 때문에 배포 가능
      // 2. 이전값 7이 3보다 크기 때문에 배포 가능
      else {
        count++;
      }

    }
    result.add(count);
```
