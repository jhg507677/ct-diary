package org.example.inflearn_base.ch_02;

public class q_02_11_V2 {
  public static int solution(int[][] board){
    int maxCount = 0;
    int candidate = 0; // 임시 반장 번호 (0-indexed)
    int n =board.length;

    for (int row = 0; row < n; row++){
      int count = 0; // i번째 학생과 한번이라도 같은 반이었던 학생 수

      for (int col = 0; col < n; col++){
        if(row == col) continue; // 자기 자신 제외

        // 학년 비교: 다시 오른쪽으로 반복하기 위해서
        for (int k = 0; k < 5; k++){ // 1~5학년

          // i번 학생의 K 학년과 j번 학생의 k과 같으면
          if(board[row][k] == board[col][k]){
            count++;
            break; // 한번이라도 같은 반이면 중복 카운트 방지(학생수를 세는거니까 )
          }
        }
      }

      if(count > maxCount){
        maxCount = count;
        candidate = row; // 0-based학생 번호 - 1
      }
    }

    return candidate + 1; // 1-based 출력
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
