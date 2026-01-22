package org.example.level1.q_031;

import java.util.*;
class Solution {
  public int solution(int[] nums) {
    HashSet<Integer> hash = new HashSet<>();
    // 중복을 제거한다.
    // 중복 제거한 후의 사이즈  데려갈 수있는 사이의 집합을 취한다.

    for(int i = 0; i < nums.length; i++){
      hash.add(nums[i]);
    }
    // 3 2 - >2
    // 1 2 -> 1
    // 3 2
    return Math.min(hash.size(), nums.length /2 );
  }
}