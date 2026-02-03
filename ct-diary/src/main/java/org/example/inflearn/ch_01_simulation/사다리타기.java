package org.example.inflearn.ch_01_simulation;

import java.util.*;
class Solution {
  public char[] solution(int n, int[][] ladder){
    // 바로 값 못넣지
    char[] answer = new char[n];
    String al = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    for(int i = 0 ; i < n; i ++){
      answer[i] = al.charAt(i);// 'A'
    }

    // 첫번째 반복문은 사다리 가로줄의 높이
    for(int i = 0 ; i < ladder.length; i ++){

      //  두번째 반복문은 사다리 가로줄
      for(int j = 0 ; j < ladder[0].length; j ++){
        // ladder[i][j] == 1 이라면
        // answer의 1-1 번째와 1번째의 순서를 변경

        // ladder[i][j] == 3 이라면
        // answer의 3-1 번째와 3번째의 순서를 변경
        int item = ladder[i][j]; // 1이라면

        // 두 인덱스 순서 변경 어떻게하지?
        char temp = answer[item - 1];
        answer[item -1] = answer[item];
        answer[item] = temp;
      }
    }
    return answer;
  }

  public static void main(String[] args){
    Solution T = new Solution();
    System.out.println(Arrays.toString(T.solution(5, new int[][]{{1, 3}, {2, 4}, {1, 4}})));
    System.out.println(Arrays.toString(T.solution(7, new int[][]{{1, 3, 5}, {1, 3, 6}, {2, 4}})));
    System.out.println(Arrays.toString(T.solution(8, new int[][]{{1, 5}, {2, 4, 7}, {1, 5, 7}, {2, 5, 7}})));
    System.out.println(Arrays.toString(T.solution(12, new int[][]{{1, 5, 8, 10}, {2, 4, 7}, {1, 5, 7, 9, 11}, {2, 5, 7, 10}, {3, 6, 8, 11}})));
  }
}

/*
사다리 그림에서 가로선이 있는 곳은 두 사람의 위치가 서로 바뀌는 포인트
사다리를 위에서 아래로 내려오면서,가로선이 있으면 그 두 칸의 값을 교환
모든 가로선을 다 지나면 최종 순서가 정답
*/