package org.example.programmers.level1.q_004;

import java.util.*;

class Solution {
  // answers : 정답 최대 10000개
  public ArrayList<Integer> solution(int[] answers) {
    ArrayList<Integer> result = new ArrayList<>(); // {0, 0, 0}
    // return : 가장 많은 문제를 맞힌 사람, 동점일 경우 오름차순
    int[][] pattern = {
      {1, 2, 3, 4, 5}
      ,{2, 1, 2, 3, 2, 4, 2, 5}
      ,{3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
    };


    for(int i = 0 ; i < answers.length; i++){
      // 각 패턴만큼 반복
      for(int j = 0 ; j < pattern.length; j++){
        // answers[0] = 1 == pattern[0][0 % 5 - 1] // 0 나누기 5를 해서 index -1 out of bounds가 나오나?
        if(i > pattern[j].length){
          if(answers[i] == pattern[j][i % pattern[j].length - 1]) {
            result.set(j , result.get(j)+1);
          }
        }else{
          if(answers[i] == pattern[j][i]) {
            // result의 0번 인딕스 값을 기존의 0번인덱스 값을 꺼내서 +1
            result.set(j , result.get(j)+1);
          }
        }

      }
    }

    // 정렬
    // max 구하는 스트림이 기억이 안나서
    // int max = Arrays.stream(result).max();
    int max = result.get(0);// result : {5. 10. 28}
    for(int item : result){
      if(item < max) max = item;
    }

    for(int i = 0 ; i < result.size(); i++){
      if(result.get(i) != max) result.remove(i);
    }

    // return result.stream().sorted().mapToInt(Integer::intValue).toArray();
    return result;
  }
}