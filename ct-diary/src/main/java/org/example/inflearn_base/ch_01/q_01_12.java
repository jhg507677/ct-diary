package org.example.inflearn_base.ch_01;

import java.util.ArrayList;
import java.util.Scanner;

public class q_01_12 {
  static ArrayList<String> arr = new ArrayList<>();

  // 해당문자열을 7개씩 나눈 배열에 넣은 다음에
  // “#*****#”를 일곱자리의 이진수로 바꿉니다. #은 이진수의 1로, *이진수의 0으로 변환
  private static void createArr(String str){
    if(str.length() < 7) return; // 재귀 종료 조건 필수
    String temp = str.substring(0, 7).replace("#", "1").replace("*", "0");
    arr.add(temp);
    createArr(str.substring(7)); // 다음 7글자
  }

  // 이제 이진수를 10진수로 변경해야함
  public static void main(String[] args){
    Scanner in=new Scanner(System.in);
    String str = in.next();

    // 배열 생성
    createArr(str);

    // 10진수 한걸 아스키로
    StringBuilder result = new StringBuilder();
    for(String binary : arr){
      int value = Integer.parseInt(binary, 2); // 이진수 -> 10진수
      result.append((char)value); // ASCII 문자
    }
    System.out.print(result);
  }
}
/*
재귀 종료 조건 반드시!!! 넣자
*/

/*
# 반복문 사용하는법
private static String decode(String str){
    StringBuilder result = new StringBuilder();

    while (str.length() >= 7) {
        String binary = str.substring(0, 7)
                .replace("#", "1")
                .replace("*", "0");

        int value = Integer.parseInt(binary, 2);
        result.append((char) value);

        str = str.substring(7);
    }
    return result.toString();
}
*/