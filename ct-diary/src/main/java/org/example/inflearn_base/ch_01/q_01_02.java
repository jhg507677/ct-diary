package org.example.inflearn_base.ch_01;

import java.util.Scanner;

public class q_01_02 {
  public static String solution(String input1){
    StringBuilder result = new StringBuilder();
    for(char item : input1.toCharArray()){
      if(Character.isLowerCase(item)){
        result.append(Character.toUpperCase(item));
      } else if(Character.isUpperCase(item)){
        result.append(Character.toLowerCase(item));
      } else {
        result.append(item); // 숫자나 특수문자는 그대로
      }
    }
    return result.toString();
  }

  public static void main(String[] args){
    Scanner scan = new Scanner(System.in);
    String input1 = scan.next();
    System.out.println(solution(input1));
  }
}

/*
* 소문자로 변환
Character.toLowerCase(item)
* 소문자인지 확인
* Character.isLowerCase(item)
* 대문자로 변환
Character.isUpperCase(item)
* 대문자인지 확인
* Character.toUpperCase(item)
*
아스키 코드로 구현할려면
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String input = in.next();
        StringBuilder result = new StringBuilder();

        for(char item : input.toCharArray()){
            // 소문자 a~z : 97~122
            if(item >= 'a' && item <= 'z'){
                result.append((char)(item - 32)); // 대문자로 변환
            }
            // 대문자 A~Z : 65~90
            else if(item >= 'A' && item <= 'Z'){
                result.append((char)(item + 32)); // 소문자로 변환
            }
            else {
                result.append(item); // 숫자나 특수문자는 그대로
            }
        }

        System.out.print(result.toString());
    }
}

*/