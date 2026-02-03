package org.example.book.q_009;


import java.util.ArrayDeque;

// 10진수를 2진수로 변환
class Solution
{
  public String solution(int _param) {
    ArrayDeque<Integer> stack = new ArrayDeque<>();
    while(_param > 0){
      // 10
      // 5... 0
      // 2 ...1
      stack.push(_param % 2);
      _param = _param / 2;
    }

    StringBuilder str = new StringBuilder();
    for(Integer item: stack){
      str.append(item);
    }
    return str.toString();
  }
}

