package org.example.programmers.level1.q_017;

import java.util.*;
class Solution {
  public String solution(String[] cards1, String[] cards2, String[] goal) {
    ArrayDeque<String> c1 = new ArrayDeque<>();
    ArrayDeque<String> c2 = new ArrayDeque<>();
    for(int i = 0; i < cards1.length; i++){
      c1.addLast(cards1[i]);
    }
    for(int i = 0; i < cards2.length; i++){
      c2.addLast(cards2[i]);
    }

    for(int i = 0; i < goal.length; i++){
      if(!goal[i].equals(c1.peek()) && !goal[i].equals(c2.peek())){
        return "No";
      }
      if(goal[i].equals(c1.peek())){
        c1.pop();
      }
      if(goal[i].equals(c2.peek())){
        c2.pop();
      }
    }
    return "Yes";
  }
}
