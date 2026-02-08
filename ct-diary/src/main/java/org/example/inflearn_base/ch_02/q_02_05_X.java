package org.example.inflearn_base.ch_02;

import java.util.Arrays;
import java.util.Scanner;

// 에라토스테네스 체
public class q_02_05_X {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();

    boolean[] isPrime = new boolean[n + 1]; // 0 제외
    Arrays.fill(isPrime, true);
    isPrime[0] = isPrime[1] = false;

    // 2, I 제곱보다 작거나 같은 값
    for (int i = 2; i * i <= n; i++) {
      if (isPrime[i]) {

        // i의 모든 배수들을 false로 변경
        // ex) i가 3이라면 j는 9부터 3을 더한값들?
        // 9인 이유 -> 그 이전의값은 이미 앞 조건에서 제외됨 ex) 6은 2의 배수
        // i 제곱부터 j = j + i씩 증가
        for (int j = i * i; j <= n; j = j + i) {
          isPrime[j] = false;
        }
      }
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 2; i <= n; i++) {
      if (isPrime[i]) sb.append(i).append(" ");
    }

    System.out.print(sb);
  }
}
/*
소수인지 판단하는 알고리즘이 핵심
*/