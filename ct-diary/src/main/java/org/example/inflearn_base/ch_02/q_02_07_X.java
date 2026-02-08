package org.example.inflearn_base.ch_02;

public class q_02_07_X {
  public static void main(String[] args){
//    int[] arr = {1, 0, 1, 1, 1, 0, 0, 1, 1, 0};
    int[] arr = {1, 1, 1};
    int cum = 1;
    int result = 0;
    for (int x : arr) {
      if (x == 1) {
        cum++; // 누적값
        result += cum;
      } else {
        cum = 0;
      }
    }
    System.out.println(result);
  }
}



/*
회고
처음에 맞았을때 점수를 주지 않고 틀렸을때 이전 점수 합산을 하고 마지막에 합산 안된사람 합산을 했더니 결과가
테스트 케이스 첫번재값에만 맞는 로직이 나옴

** 테스트 케이스 그때그때 추가하는 버릇 키워야함
더 좋은 방법은 위의 방식처럼 맞았을때 바로바로 합산하는 방식
*/