package org.example.inflearn.ch_08_graph;

import java.util.*;
class Solution {
  public int solution(int[] nums){

    Arrays.sort(nums);
    int oldV = nums[0];
    int count = 0;
    ArrayList<Integer> result = new ArrayList<>();
    for(int i = 1; i < nums.length; i++){
      if(nums[i] == oldV + 1) {
        count++;
      }else {
        result.add(count);
        count=0;
      }
      oldV = nums[i];
    }

    int max = result.get(0);
    for(int i = 1; i < result.size(); i++){
      if(max < result.get(0)) max = result.get(0);
    }
    return max;

    // return result.stream().mapToInt(Integer::intValue).max(Integer::compareTo);
  }

  public static void main(String[] args){
    Solution T = new Solution();
    System.out.println(T.solution(new int[]{8, 1, 9, 3, 10, 2, 4, 0, 2, 3}));
    System.out.println(T.solution(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 0, 0, 0, 0}));
    System.out.println(T.solution(new int[]{3, 3, 3, 3, 3, 3, 3, 3}));
    System.out.println(T.solution(new int[]{-3, -1, -2, 0, 3, 3, 5, 6, 2, 2, 1, 1}));
    System.out.println(T.solution(new int[]{-5, -3, -1, -4, 3, 3, 5, 6, 2, 2, 1, 1, 7}));
  }
}