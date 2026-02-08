package org.example.inflearn_base.ch_01;

import java.util.ArrayList;
import java.util.Scanner;

public class q_01_12_V2 {
  public static void main(String[] args){
    Scanner in=new Scanner(System.in);
    String str = in.next();

    StringBuilder result = new StringBuilder();

    /* 값을 7개씩 가져오기위해 반복문 */
    while (str.length() >= 7) {
      String binary = str.substring(0, 7)
        .replace("#", "1")
        .replace("*", "0");

      // 이름 10진수로 변환
      int value = Integer.parseInt(binary, 2);
      result.append((char) value);

      str = str.substring(7);
    }
    System.out.print(result);
  }
}