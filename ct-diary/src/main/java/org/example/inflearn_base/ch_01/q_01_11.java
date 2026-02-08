package org.example.inflearn_base.ch_01;

import java.util.Scanner;

public class q_01_11 {
  public static void main(String[] args){
    Scanner in=new Scanner(System.in);
    String str = in.next();

    // 연속으로 반복
    // 이전값 저장해서 이전값과 현재값이 같으면 카운트 증가 k=1부터 시작
    int count = 1;
    char old = str.charAt(0);
    StringBuilder result = new StringBuilder();
    // 첫번째 글자는 제외
    for(int i = 1; i < str.length(); i++){
      char c = str.charAt(i);

      if(old == c) {
        count++;
      }else{

        // 다른 값이 들어올경우 이전의 값을 넣어줌
        result.append(old);
        if(count != 1) result.append(count);
        count=1;
        old = c;
      }
    }
    result.append(old);
    if(count != 1) result.append(count);
    System.out.println(result);
    }
}

// 이전값으로 비교했을경우에는 마지막 반복문에서는 이전 값을 넣기 때문에 해당 회차의 값은 별도로 넣어줘야함
// 다음 값으로 비교했을때는 위 과정 필요 X
