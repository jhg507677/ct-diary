package org.example.template;

import java.util.ArrayDeque;
class Solution
{
  ArrayDeque<Character> stack = new ArrayDeque<>();
  public int solution(String s)
  {
    int answer = -1;
    for(int i = 0; i < s.length(); i++){
      char c = s.charAt(i);
      if(stack.isEmpty()) {
        stack.push(c);
        continue;
      }
      if(stack.peek() == c){
        stack.pop();
      }else{
        stack.push(c);
      }

    }
    return stack.isEmpty() ? 1 : 0;
  }
}
