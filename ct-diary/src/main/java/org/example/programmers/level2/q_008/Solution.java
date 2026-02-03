package org.example.programmers.level2.q_008;

import java.util.*;
class Solution {
  boolean solution(String s) {
    Map<Character,Character> manual = Map.of(
      '(',')'
    );
    ArrayDeque<Character> stack = new ArrayDeque<>();
    for(int i = 0; i < s.length(); i++){
      char item = s.charAt(i);

      // 비어 있을경우 값을 넣고
      if(stack.isEmpty()) {
        stack.push(item);
        continue;
      }

      // 서로 다른 모양이라면 뿐만아니라 서로 같은 방향을 바라보게 추가해야함
      // 기존에 있는게 ( 이고 새로 들어온것이 ) 라면
      if(manual.containsKey(stack.peek()) && manual.get(stack.peek()) == item){
        stack.pop();
        continue;
      }
      stack.push(item);
    }

    // 비어있을경우 성공, 비어있지않을 경우 실패
    return stack.isEmpty();
  }

  // )(

}