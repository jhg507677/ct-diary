package org.example.level2.q_012;

import java.util.*;

class Solution {
  public int[] solution(int[] prices)  {
    int[] answer = new int[prices.length];

    Stack<Integer> stack = new Stack();
    stack.push(0);

    for(int i = 1; i < prices.length; i++){

      // 스택에 항상 이전에 가격이 떨어지지 않은 인덱스
      // prices[stack.peek()]은 이전 값
      // 1 -> prices[1] 2 < 1
      // 2 -> prices[2] 3 < 2
      // 3 -> prices[3] 2 < 3 더 작으면

      // prices[i]가 더 작은 경우 주식 가격이 떨어진 순간
      while(!stack.isEmpty() && prices[i] < prices[stack.peek()]){
        int j = stack.pop(); // 이전 인덱스 제거하고 2가 빠져나가고
        answer[j] = i - j; // 이전 인덱스 길이 확정, answer[2] = 3 - 2 = 1 // 현재 인덱스 - 이전 인덱스
      }
      stack.push(i); // 인덱스 푸시 // [0, 1, 3]
    }

    // 끝까지 가격이 떨어지지 않은 인덱스
    while(!stack.isEmpty()){
      int j = stack.pop(); // 0
      answer[j] = prices.length - 1 - j ; // answer[0] = 5 - 1 - 0
    }
    return answer;
  }
}