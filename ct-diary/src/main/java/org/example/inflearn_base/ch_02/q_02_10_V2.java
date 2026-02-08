package org.example.inflearn_base.ch_02;

/*
이건 방향으로 계산해야함
int[] dx = {-1, 1, 0, 0};
int[] dy = {0, 0, -1, 1};
*/
public class q_02_10_V2 {
  public static int solution(int[][] board) {
    int n = board.length;
    int result = 0;

    //  U,D,L.R
    int[] rowD = {-1, 1, 0, 0};
    int[] colD = {0, 0, -1, 1};

    for (int row = 0; row < n; row++) {
      for (int col = 0; col < n; col++) {
        boolean isPeak = true;

        // 방향 오프셋만큼 반복해서 모든 수를 더함
        for (int d = 0; d < 4; d++) {
          int nextRow = row + rowD[d]; // 행의 좌표
          int nextCol = col + colD[d];

          // 범위안이라면
          if (nextRow >= 0 && nextRow < n && nextCol >= 0 && nextCol < n) {

            // 다 더한 값들중에 한개라도 내 값보다 같거나 크다면 봉우리 아님
            if (board[nextRow][nextCol] >= board[row][col]) {
              isPeak = false;
              break;
            }
          }
        }

        if (isPeak) result++;
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