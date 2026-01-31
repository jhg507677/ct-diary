package org.example.level2.q_012;

import java.util.*;

class Solution_2 {
  public int[] solution(int[] prices)  {

    // 가격이 떨어지지 않은 기간
    int[] result = new int[prices.length];

    // 인덱스
    ArrayDeque<Integer> stack = new ArrayDeque<>();
    stack.push(0); // 첫번째는 가격이 떨어질 수 없으니 0을 삽입
    for(int i =1 ; i< prices.length; i ++){

      // 스택이 비어있지 않고, 현재 가격이 스택의 마지막 인덱스 가격(직전 가격)보다 낮으면
      while(!stack.isEmpty() && prices[i] < prices[stack.peek()]){
        int lastIndex = stack.pop(); // 마지막 인덱스값을 가져와서 현재인덱스와 빼면 길이
        result[lastIndex] = i - lastIndex;
      }

      // 가격이 떨어지지 않았을때 인덱스값을 주입
      stack.push(i);
    }

    // 단 한번도 값이 떨어지지 않은 경우
    while(!stack.isEmpty()){
      int index = stack.pop();
      result[index] = prices.length  - index - 1;
    }
    return result;
  }
}