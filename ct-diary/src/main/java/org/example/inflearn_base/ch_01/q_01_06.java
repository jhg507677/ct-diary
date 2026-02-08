package org.example.inflearn_base.ch_01;

import java.util.HashSet;
import java.util.Scanner;

public class q_01_06 {
  public static void main(String[] args){
    Scanner in = new Scanner(System.in);
    String param = in.next();
    char[] charArr = param.toCharArray();

    // 순서 보장 안함
    // remove도 안돼
    HashSet<Character> set = new HashSet<>();
    for(char item : charArr){
      set.add(item);
    }

    // set은 중복이 제거된 상태
    StringBuilder result = new StringBuilder();
    for(char item : charArr){

      // 중복문자라면
      if(set.contains(item)) {
        result.append(item);
        set.remove(item);
      }
    }
    System.out.println(result);
  }
}

/*
기술 회고
해당 문제는 indexOf를 사용하면 반복문 하나로 종료가 가능하다
Scanner in = new Scanner(System.in);
String s = in.next();

StringBuilder result = new StringBuilder();

for (int i = 0; i < s.length(); i++) {

  // 처음 나온 문자만 추출 가능
  if (s.indexOf(s.charAt(i)) == i) {
      result.append(s.charAt(i));
    }
}

System.out.println(result.toString());
*/