package org.example.inflearn_base.ch_02;

import java.util.Scanner;

// 배열 버전
public class q_02_04_v2 {

  // 피보나치 수열을 출력
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    int[] arr = new int[n];
    arr[0] = 1;
    arr[1] = 1;
    for(int i = 2 ; i < n; i++){
      arr[i] = arr[i -2] + arr[i - 1];
    }
    // arr 출력 하면 됨
  }
}
