package org.example.Book.q_018;

import java.util.Arrays;
import java.util.HashSet;

// n개의 양의 정수로 이루어진 배열 arr와 정수 target이 주어졌을대 이 중에서 합이 target인 두 수가 arr에 있는지 찾고
// 있으면 true, 그렇지 않으면 false

/*class Solution
{
  // {0,1,2,3}
  // target =5
  public boolean solution(int[] arr, int target)
  {
    for(int i = 0; i < arr.length; i++){
      for(int j = i+1; j < arr.length; j++){
        if(target == arr[i] + arr[j]) return true;
      }
    }
    return false;
  }
}*/

class Solution
{
  // {0,1,2,3}
  // target =5
  // 2 + 3 = 5
  // 3 = 5 -2
  public boolean solution(int[] arr, int target)
  {
    HashSet<Integer> bucket = new HashSet<>();
    for(int i = 0; i < arr.length; i++){
      // arr[i] == 2라면 이미 3을 가지고 있으면 true;
      if(bucket.contains(target - arr[i])) return true;
      bucket.add(arr[i]);
    }
    return false;
  }
}


