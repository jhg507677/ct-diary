package org.example.inflearn_base.ch_01;

import java.util.Scanner;

public class q_01_09 {
  public static void main(String[] args){
    Scanner in=new Scanner(System.in);
    String str = in.next();
    // isLetter가 아닌 나머지들을 순서대로
    StringBuilder result = new StringBuilder();
    for(int i = 0; i< str.length(); i++){
      char c = str.charAt(i);

      if(!Character.isLetter(c)){
        // 이거 안하고 Integer.parseInt() 해줘도 됨
        if(result.isEmpty() && c == '0') continue;
        result.append(c);
      }
    }
    System.out.println(result);
  }
}

// isDigit은 숫자만 출력 가능
/*
정석 풀이
for (char c : str.toCharArray()) {
    if (Character.isDigit(c)) {
        result = result * 10 + (c - '0');
        // (c - '0') -> char '0' ~ '9'를 실제 숫자 값으로 바꿔줌 문자 '0'인것 주의
        // result * 10 + -> 지금까지 만든 숫자를 한 자리 올려서 새 숫자를 붙임
    }
}
*/