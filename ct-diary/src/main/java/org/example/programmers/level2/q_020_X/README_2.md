# P.208 Q.16 [할인행사]
출처 : 프로그래머스
Level : 2

## 풀이 날짜
- 2026-01-18 X

## 풀이
```java
import java.util.*;

class Solution {

  // 10일도안 회원자격
  // 하루에 한개씩만 구매 가능
  public int solution(String[] want, int[] number, String[] discount) {
    // 먼저 want만큼 반복문을 돌면서 want를 key, number를 value로 하는 HashMap 생성
    // discount길이만큼 반복문을 돌면서
    // discount길이만큼 반복문 2개를 돌면서
    // 날짜 하나씩 제거하다가 나중에 Map의 value가 모두 0이되면 카운트 증가
    // 시간복잡도는 빅오엔 중접 반복문도 빅오엔이었나? 중첩아닌 박복문도 빅오엔이고? ???????????????
    HashMap<String, Integer> wish = new HashMap();
    for(int i = 0; i < want.length; i++){
      wish.put(want[i], wish.getOrDefault(want[i], 0)+1);
    }

    // 첫째날이 chicken이고 둘째날
    int result = 0;
    for(int i = 0; i < discount.length; i++){
      HashMap<String, Integer> wishCopy= new HashMap(wish);
      for(int j = i; j < discount.length - 10; j++){
        String dayItem = discount[j];
        if(!wishCopy.containsKey(dayItem)){
          // isSum = false;
          break;
        }
        // 더 이상 뺄 수 없을때
        if(wishCopy.get(dayItem) == 0){
          // isSum = false;
          break;
        }
        wishCopy.put("dayItem", wishCopy.get(dayItem) - 1);
      }

      boolean isSum = true;
      // wishCopy는 HashMap이고 HashMap은 이렇게 반복하면 안됨, 와 이거 문법 모르겠다
      for(int j = 0; j < wishCopy.entrySet(); j++){
        wishCopy.get(j) != 0) isSum = false;
      }

      if(isSum) result++;
    }
    return result - 10; // 아나 왜 이게 답임
  }
}
```

## 기술 회고
해시맵 값 복사
```java
Map<String, Integer> map = new HashMap<>(hWant);

// HashMap<String, Integer> wishCopy= new HashMap(wish); 이게 아님!!!
```

아래는 공부한 내용
* 반복믄 규칙
1. 기준점이 이동하는가?
날짜가 하루씩 이동해야하므로 -> 바깥 반복문
2. 각 기준점마다 검사해야하는 범위가 있는가?
기준점마다 할인 목록이 잘 들어가는지 확인해야하니 -> 안쪽 반복문

## 회고
- 해당 부분은 비록 틀렸지만 이중 반복문에 대한 개념을 다시 한번 정립하는 시간을 가졌다.
이중 반복문안에서 continue A와 break을 쓰면 어떤 점이 다른지
- 실무에서 개발할때 자동완성 쓰고 ai 쓰다보니 너무 간단한것조차 기억이 안나 머리를 쥐어 뜯을때가 있다.
코딩테스트 준비 시간이 그동안 부족했던 나에 대해서 매우 뜻 깊은 시간이 되었다.