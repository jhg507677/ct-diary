package org.example.inflearn_base.ch_01;

import javax.xml.stream.events.Characters;

public class q_01_08 {
  // 알파벳 이외의 문자열은 무시
  // 대소문자 구분 안함
  public static void main(String[] args){
    // found7, time: study; Yduts; emit, 7Dnuof 들어왔다치고
    String[] arr = new String[]{"found7,", "time:","study;" ,"Yduts;" ,"emit,", "7Dnuof"};
    String result = "YES";

    // "found7", "time:","study;" ,"Yduts;" ,"emit,", "7Dnuof"
    int left = 0;
    int right = arr.length - 1;
    // 특수문자는 제거한 후 뒤집은 값이 같은지 봐야하는데 특수문자는 제거 어떻게 하지?
//    Characters.isLetter()
    while(left < right){
      String leftS = arr[left].toUpperCase();
      String rightS = arr[right].toUpperCase();
      StringBuilder onlySLeft = new StringBuilder();
      StringBuilder onlySRight = new StringBuilder();

      // 반복문 사용해서 특수문자 제거하는수밖에없나?
      for(int i = 0; i < leftS.toCharArray().length; i++){
        char c = leftS.charAt(i);
        if(Character.isAlphabetic(c)) onlySLeft.append(c);
      }

      for(int i = 0; i < rightS.toCharArray().length; i++){
        char c = rightS.charAt(i);
        if(Character.isAlphabetic(c)) onlySRight.append(c);
      }

      if(!onlySLeft.toString().equals(onlySRight.reverse().toString())){
        result = "NO";
      }
      left++;
      right--;
    }
    System.out.println(result);
    }
}

// Character.isAlphabetic이 기억 안날땐 그냥 Character.isLetter() 하자
// 특수문자 제거하는 법을 몰라서 뻘짓을 했다
// s = s.replaceAll("[^A-Za-z]", "");
// 와 심지어 저거 배열로 안하고 하나의 문자열로 해서 구하면 엄청 간단한 문제였네..
// String s = input.toUpperCase().replaceAll("[^A-Z]", "");
// String rev = new StringBuilder(s).reverse().toString();
// System.out.println(s.equals(rev) ? "YES" : "NO");
