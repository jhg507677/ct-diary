# P.208 Q.16 [다단계 칫솔 판매]
출처 : 프로그래머스
Level : 2

## 풀이 날짜
- 2026-01-18 X

```java
import java.util.*;
class Solution {
  HashMap<String, String> bt = new HashMap<>();
  HashMap<String, Integer> price = new HashMap<>();
  public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
    int[] answer = new int[enroll.length];
    // key = 자식, value = 부모
    for(int i = 0; i < enroll.length; i++){
      bt.put(enroll[i], referral[i]);
    }


    // 판 사람
    for(int i = 0; i < seller.length; i++){
      String s = seller[i];
      Integer p = amount[i] * 100; // 해당 판매자의 가격 ex_ 1200
      // 자기 자신에게 0.9를 부여

      Integer minusP = p / 10; // 부모가 받을 돈 1200 / 10 = 120원
      Integer myP = p - minusP; // 내가 받을 돈 1200 - 120 = 1080원
      price.put(s, price.getOrDefault(s, 0)+myP); // 1080원 넣고
      if(minusP == 0) price.put(s, price.getOrDefault(s, 0)+minusP);


      if(!bt.get(s).equals("-")){
        // 판매자는 90프로가져가고 그 위에는 10퍼센트씨 가져감
        parentCheck(bt.get(s), minusP);
      }
    }

    for(int i = 0; i < enroll.length; i++){
      if(!price.containsKey(enroll[i])) continue;
      answer[i] = price.get(enroll[i]);
    }
    return answer;
  }

  // parent : 부모
  public void parentCheck(String parent, Integer money){

    Integer minusP = money / 10; // 부모가 받을 돈
    Integer myP = money - minusP; // 내가 받을 돈

    // 자기자신에게 0.9 부여
    price.put(parent, price.getOrDefault(parent, 0)+myP);
    if(money / 10 == 0) price.put(parent, price.getOrDefault(parent, 0)+minusP);
    // 그 이상의부모에게 0.1
    if(!bt.get(parent).equals("-")){
      parentCheck(bt.get(parent), minusP);
    }
  }
}
```

## 기술 회고
단, 10% 를 계산할 때에는 원 단위에서 절사하며, 10%를 계산한 금액이 1 원 미만인 경우에는 이득을 분배하지 않고 자신이 모두 가집니다.
-> 이 문장이 매우 중요해서 곱하기 0.9 0.1이아니라 원금에 10을 몫이 0일경우 부모한테 분배 안함
그리고 재귀로 구현했다가 **효율성** 문제에서 떨어짐.......ㅋㅋㅋㅋ......
## 회고
트리 문제는 반드시 일정 시간이 흐른 후 다시 풀어볼것
아직은 재귀가 너무 어색하니 재귀에 익숙해질것

