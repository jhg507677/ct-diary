package org.example.inflearn_base.ch_01;

import java.util.Scanner;

public class q_01_01 {
  public static int solution(String input1, char input2){
    input1 = input1.toUpperCase();
    input2 = Character.toUpperCase(input2);
      char[] charArr = input1.toCharArray();
      int result = 0;
      for(int i = 0 ; i < charArr.length; i++){
        if(charArr[i] == input2) result++;
      }
      return result;
  }
    public static void main(String[] args){
    Scanner scan = new Scanner(System.in);
    String input1 = scan.next();
    char input2 = scan.next().charAt(0);
    System.out.println(solution(input1, input2));
  }
}

/*
백준 방식은 처음이라 아래 문법이 생소했다.
Scanner scan = new Scanner(System.in);
String input1 = scan.next().toUpperCase();
char input2 = scan.next().toUpperCase().charAt(0);

char를 대문자로 바꾸고싶다면 Character.toUpperCase(char);로 사용 가능

회고
처음에 문제를 자세히 읽지 않아서 대소문자 구분안한다는것을 놓쳐버렸다.
문제를 자세하게 읽어보는 습관을 가지자..!!
*/