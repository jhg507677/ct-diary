package org.example.book.q_002;


import java.util.Arrays;
import java.util.Collections;

// 배열의 중복값을 제거하고 배열 데이터를 내림차순으로 정렬
// 입력: [1, -5, 2, 4, 3]
class Solution
{
  public int[] solution(int[] _param) {
    Integer[] result = Arrays.stream(_param).distinct().boxed().toArray(Integer[]::new);
    Arrays.sort(result, Collections.reverseOrder());
    return Arrays.stream(result).mapToInt(Integer::intValue).toArray();
  }
}

