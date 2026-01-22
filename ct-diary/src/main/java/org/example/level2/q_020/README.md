# P.208 Q.16 [할인행사]
출처 : 프로그래머스
Level : 2

## 풀이 날짜
- 2026-01-18 X

## 정답
```java
import java.util.*;
/**
시작 날짜를 하루씩 옮긴다.
그 날짜부터 10을 본다
수량을 하나씩 줄인다.
중간에 실패하면 맨 위부터 다시 시작한다.
*/
class Solution {
    // want 원하는 제품
    // number 원하는 제품의 수량
    // discount 할인 ㄴ목록
    // return :  모두 할인 받을 수 있는 날짜의 총 일수
   
    public int solution(String[] want, int[] number, String[] discount) {
        HashMap<String, Integer> hWant = new HashMap<>();
   
       int sucDay = 0;
        for(int i = 0 ; i < want.length; i++){ 
            hWant.put(want[i], number[i]); 
        }
    
        // 10일동안 반복하는데
        for(int start = 0 ; start < discount.length - 9; start++){
            boolean success = true;
            Map<String, Integer> map = new HashMap<>(hWant);

            // 시작 날짜가 달라짐
           for(int day = start ; day < start + 10; day++){
               String check = discount[day]; // chicken
               
                if(!map.containsKey(check)) {
                    success = false;
                    break;   
                }
                if(map.get(check) == 0) {
                     success = false;
                    break;   
                }
                map.put(check, map.get(check) - 1);
           }
            if(success) sucDay++;
        }
        return sucDay;
    }
}
```

## 배울 점
해시맵 값 복사
```java
Map<String, Integer> map = new HashMap<>(hWant);
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