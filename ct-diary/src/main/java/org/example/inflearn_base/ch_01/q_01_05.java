package org.example.inflearn_base.ch_01;

import java.util.Scanner;

/*
영어 알파벳과 특수문자로 구성된 문자열이 주어지면 영어 알파벳만 뒤집고, 특수문자는 자기
자리에 그대로 있는 문자열을 만들어 출력하는 프로그램을 작성하세요.
▣ 입력설명
첫 줄에 길이가 100을 넘지 않는 문자열이 주어집니다.
▣ 출력설명
첫 줄에 알파벳만 뒤집힌 문자열을 출력합니다.
▣ 입력예제 1
a#b!GE*T@S
▣ 출력예제 1
S#T!EG*b@a
*/
public class q_01_05 {
  private void solution(){
    Scanner scan = new Scanner(System.in);
    String param = scan.next();

    char[] chars = param.toCharArray();
    int left = 0;
    int right = param.length()-1;
    while(left < right){
      if (Character.isLetter(chars[left]) && Character.isLetter(chars[right])) {
        char temp = chars[left];
        chars[left] = chars[right];
        chars[right] = temp;
      }
      left++;
      right--;
    }
    String result = String.valueOf(chars);
    System.out.println(result);
  }
}
/*
Character.isLetter() 해당 char가 알파벳인지
Character.isAlphabetic() 한글도 포함
String.valueOf(char) char 배열을 하나의 String으로 변환
*/