package org.example.book.q_Backtracking;

import java.util.ArrayList;
import java.util.List;

// 가능한 모든 경우의 수를 “하나의 길씩 끝까지 가보고 끝나면 직전 갈림길로 돌아와 다른 선택지를 시도하는 알고리즘
public class BacktrackingTemplate {

  static int[] choices = {1, 2, 3};
  static boolean[] used = new boolean[choices.length]; // [false, false, false]
  static List<Integer> path = new ArrayList<>();

  static void backtrack() {

    // 1. 종료 조건
    if (path.size() == choices.length) {
      System.out.println(path);
      return;
    }

    // 2. 선택지 반복
    for (int i = 0; i < choices.length; i++) {

      if (used[i]) continue;

      // 3. 선택
      used[i] = true;
      path.add(choices[i]);

      // 4. 재귀
      backtrack();

      // 5. 상태 복구
      // 한 선택을 시도한 후 그 선택이 끝나면 상태를 원래대로 되돌려 놓는것
      path.remove(path.size() - 1);
      used[i] = false;
    }
  }

  public static void main(String[] args) {
    backtrack();
  }
}