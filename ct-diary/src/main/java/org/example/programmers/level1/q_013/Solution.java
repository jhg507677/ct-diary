package org.example.programmers.level1.q_013;

import java.util.*;
class Solution {
  // 크레인 인형뽑기 게임
  public int solution(int[][] board, int[] moves) {

    int resultCount = 0;
    int width = board[0].length;
    int height = board.length;


    List<Deque<Integer>> mainBox = new ArrayList<>();
    for (int i = 0; i < width; i++) {
      mainBox.add(new ArrayDeque<>());
    }

    // 3,4,1,3,1이 가장 늦게 뽑혀야하니 스택 구조상 가장 처음에 넣어야함
    for (int row = height - 1; row >= 0; row--) {   // ↓ 아래에서 위로
      for (int col = 0; col < width; col++) {     // → 왼쪽에서 오른쪽
        if (board[row][col] != 0) {
          mainBox.get(col).push(board[row][col]);
        }
      }
    }


    ArrayDeque<Integer> finalBox = new ArrayDeque<>();

    // moves : [1,5,3,5,1,2,1,4]
    for(int i = 0 ; i < moves.length; i++){
      // moves[i]의 값이 1이라면 mainBox[moves[i] - 1]
      int pickIndex = moves[i]; // 1 -1
      if(mainBox.get(pickIndex - 1).isEmpty()) continue;
      int pop = mainBox.get(pickIndex - 1).pop();
      if(finalBox.isEmpty()) {
        finalBox.push(pop);
        continue;
      }
      if(finalBox.peek() == pop) {
        finalBox.pop();
        resultCount += 2;
        continue;
      }
      finalBox.push(pop);

    }
    return resultCount;
  }
}
