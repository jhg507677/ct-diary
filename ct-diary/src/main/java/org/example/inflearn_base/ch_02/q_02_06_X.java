package org.example.inflearn_base.ch_02;

import java.util.ArrayList;

public class q_02_06_X {
  public static void main(String[] args){
    int[] arr = {32, 55, 62, 20, 250, 370, 200, 30, 100};
    ArrayList<Integer> result = new ArrayList<>();

    for(int i = 0; i < arr.length; i++){
      int n = arr[i];

      StringBuilder sb = new StringBuilder();
      sb.append(n).reverse();

      int reverseN = Integer.parseInt(sb.toString());

      if (isPrime(reverseN)) {
        result.add(reverseN);
      }
    }

    for (int x : result) {
      System.out.print(x + " ");
    }
  }

  // 소수 판별 함수
  private static boolean isPrime(int n) {
    if (n <= 1) return false;

    // “n이 2부터 √n 사이의 어떤 수로도 나눠지지 않으면 소수다.”
    // i 제곱 조건 기억 안나면 그냥 i < n 으로 해도됨
    for (int i = 2; i * i <= n; i++) {
      if (n % i == 0) return false;
    }
    return true;
  }
}
/**
숫자 뒤집는 다른 방법
 int n = 150;
 int result = 0;

 while (n > 0) {
  int temp = n % 10;      // 맨 끝 자리 숫자 추출 ->  150 % 10 = 0 / 5 / 1
  result = result * 10 + temp; // 기존 결과에 자리 밀고 추가 0 / 10 * 10 + 5 = 0/ 5
  n = n / 10;            // 맨 끝 자리 제거 15 / 5
 }
 result = 51이 됨
 */
