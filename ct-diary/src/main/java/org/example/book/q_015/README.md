# P.172 Q.13 [요세푸스 문제]
출처 : 코딩 테스트 합격자 되기
Level : x

## 풀이 날짜
- 2026-01-17 X

## 정답
```java
    // 사람의 번호수를 Queue에 삽입
    // 첫번째에 넣은건 가장 마지막ㅇ
    ArrayDeque<Integer> number = new ArrayDeque<Integer>();
    for(int i = 1; i < N+1; i++){
      number.addLast(i);
    }

    while(number.size() > 1){
      // K 번째 요소를 찾기 위해 앞에서부터 제거하고 뒤에 추가
      // 만약에 k가 2라면
      for(int i = 0; i < K -1; i++){
        number.addLast(number.pollFirst()); // 0번째걸 빼서 가장 마지막에 붙이기
      }
      number.pollFirst();
    }
    return number.pollFirst();
```

## 접근 방식

## 개선사항