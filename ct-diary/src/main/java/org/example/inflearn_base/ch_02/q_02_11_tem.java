package org.example.inflearn_base.ch_02;

public class q_02_11_tem {
  public static int solution(int[][] board){
    int result = 0;
    return result;
  }

  public static void main(String[] args){
//    Scanner in=new Scanner(System.in);
//    int n = in.nextInt();
//    int[][] board = new int[n][n];
//    for(int row = 0; row < n; row++){
//      for(int col = 0; col  < n; col ++){
//        board[row][col] = in.nextInt();
//      }
//    }
    int[][] board = {
      {2, 3, 1, 7, 3},
      {4, 1, 9, 6, 8},
      {5, 5, 2, 4, 4},
      {6, 5, 2, 6, 7},
      {8, 4, 2, 2, 2}
    };

    // row 3일때 col이 2인게 출력이 안됨
    System.out.println(solution(board));
  }
}
