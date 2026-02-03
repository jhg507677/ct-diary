package org.example.programmers.level1.Stack_P_01;

import java.util.*;

import java.util.*;
public class Solution {
  public int[] solution(int []arr) {
    ArrayList<Integer> result = new ArrayList<>();
    // 순서 유지해야하니 Queue로
    ArrayDeque<Integer> queue = new ArrayDeque<>();

    for(int i=0; i < arr.length; i++){
      if(queue.isEmpty()) {
        queue.addLast(arr[i]);
        continue;
      }

      // 1 넣고 1은 안넣고 3 넣고 3 안넣고 0 넣고
      if(queue.peekLast() != arr[i]){
        queue.addLast(arr[i]);
      }

    }

    while(!queue.isEmpty()){
      result.add(queue.pollFirst());
    }

    return result.stream().mapToInt(Integer::intValue).toArray();
  }
}