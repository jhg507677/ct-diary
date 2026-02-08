package org.example.inflearn_base.ch_02;

import java.util.Scanner;

public class q_02_09_X {
  public static int solution(int[][] board){
    int result = Integer.MIN_VALUE;
    int rowSumMax;
    int colSumMax;
    int n = board.length;

    // 행과 열의 합의 최댓값 구하기
    for(int row = 0; row < n; row++){
      rowSumMax = 0;
      colSumMax = 0;
      for(int col = 0; col  < n; col ++){
        // row가 0일때 col 1부터 4까지 움직이니 col의 합이 반환
        // 행이 고정되고 열이 1부터 4까지 움직임
        // 즉 0행의 합계를 반환
        rowSumMax+=board[row][col];
        colSumMax+=board[col][row];
      }
      result = Math.max(result, rowSumMax);
      result = Math.max(result, colSumMax);
    }

    // 대각선의 최댓값 구하기
    int sum1 = 0;
    int sum2 = 0;
    for(int i = 0; i < n; i++) {
      sum1+=board[i][i];
      sum2+=board[i][n - i - 1];
    }
    result = Math.max(result, sum1);
    result = Math.max(result, sum2);
    return result;
  }

  public static void main(String[] args){
    Scanner in=new Scanner(System.in);
    int n = in.nextInt();
    int[][] board = new int[n][n];
    for(int row = 0; row < n; row++){
      for(int col = 0; col  < n; col ++){
        board[row][col] = in.nextInt();
      }
    }
    System.out.println(solution(board));
  }
}
