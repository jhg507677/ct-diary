package org.example.inflearn_base.ch_02;

import java.util.Scanner;

public class q_02_04 {

  // 피보나치 수열을 출력
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    StringBuilder result  = new StringBuilder();
    result.append(1+ " ");
    result.append(1+ " ");
    int old1 = 1;
    int old2 = 1;
    for(int i = 2 ; i < n ; i++){
      int sum = old1 + old2;
      result.append(sum + " "); // 1 + 1 = 2, 1+ 2 = 3
      // 뒤로 한칸식 밀기
      old1 = old2;
      old2 = sum;
    }
    System.out.println(result);
  }
}
