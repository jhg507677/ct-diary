package org.example.level1.q_003;

import java.util.TreeSet;

class Solution
{
  public TreeSet<Integer> solution(int[] numbers) {
    TreeSet<Integer> result = new TreeSet<>();
    for(int i = 0; i < numbers.length; i++){
      for(int j = i+1; j < numbers.length; j++){
        result.add(numbers[i] + numbers[j]);
      }
    }
    return result;
  }
}
