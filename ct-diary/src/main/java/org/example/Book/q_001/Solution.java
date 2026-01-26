package org.example.Book.q_001;


import java.util.Arrays;

// 정수 배열을 정렬해서 반환하는 함수
// 입력: [1, -5, 2, 4, 3]
class Solution
{
  public int[] solution(int[] _param) {
    return Arrays.stream(_param).sorted().toArray();
  }
}

