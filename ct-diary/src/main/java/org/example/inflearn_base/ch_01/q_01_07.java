package org.example.inflearn_base.ch_01;

import java.util.Scanner;

public class q_01_07 {

  public static void main(String[] args){
    Scanner in=new Scanner(System.in);
    String str = in.next().toUpperCase();
    char[] charArr = str.toCharArray();
    int left = 0;
    int right = charArr.length - 1;
    String result = "YES";


    while(left < right){
      if(charArr[left] != charArr[right]){
        result = "No";
        break;
      }
      left++;
      right--;
    }
    System.out.println(result);
  }
}

/*
* 다른 방식으로 반복문 사용하기
for(int i = 0 ; i < len / 2; i++){
  srt.charAt(i) != str.charAt(len - i - 1) -> 다룰 경우 처리
}

// 문자열 뒤집어서 비교하기
String str = in.next().toUpperCase();
String reverse = new StringBuilder(str).reverse().toString();
if(str.equalsIgnoreCase(reverse)) return "YES"
*/