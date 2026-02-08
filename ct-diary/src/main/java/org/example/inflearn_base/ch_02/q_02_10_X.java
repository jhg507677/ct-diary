package org.example.inflearn_base.ch_02;

public class q_02_10_X {
  public static int solution(int[][] board){
    int result = 0;
    int n = board.length;


    for(int row = 0; row  < n ; row++){
      for(int col = 0; col < n; col ++){
        // 배열 범위를 안벗어나게 할려면 그냥 제일 시작과 끝에 있는 행을 무시하면 됨

        if(row == 0 || row == n-1) continue;
        if(col == 0 || col == n-1) continue;

        // 무조건 점수 낮은걸로 판단
        if(row - 1 == -1 || row + 1 == 11){

        }

        // row 3일때 col이 2인게 출력이 안됨
        if(board[row][col] > board[row - 1][col]
          && board[row][col] > board[row + 1][col]
          && board[row][col] > board[row][col + 1]
          && board[row][col] > board[row][col - 1]
        ){
          result++;
//          System.out.println("|| row : "+row +","+"col : "+col+"||");
        }
      }
    }
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
      {5, 3, 7, 2, 3},
      {3, 7, 1, 6, 1},
      {7, 2, 5, 3, 4},
      {4, 3, 6, 4, 1},
      {8, 7, 3, 5, 2}
    };

    // row 3일때 col이 2인게 출력이 안됨
    System.out.println(solution(board));
  }
}


/*
테투리 검사 안해서 틀림
*/