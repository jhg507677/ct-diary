package org.example.programmers.level2.q_026_X;

// 부모노드의 인덱스는 (a+1)/2이기 때문에 부모 노드 인덱스가 같으면 서로 토너먼트에서 만난것
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
class Solution {
  public int solution(int n, int a, int b) {
    int result = 0;
    for(result = 0; a != b; result++){
      a = (a + 1) / 2;
      b = (b + 1) / 2;
    }
    return result;
  }
}