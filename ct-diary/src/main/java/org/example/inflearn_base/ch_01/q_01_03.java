package org.example.inflearn_base.ch_01;

import java.util.Scanner;

public class q_01_03 {

  // 한개의 문장이 주어질때 가장 긴 단어
  public static void main(String[] args){
    Scanner in=new Scanner(System.in);
    String input1 = in.nextLine();

    String[] strArr = input1.split(" ");
    String maxS = strArr[0];
    for(String item : strArr){
      if(item.length() > maxS.length()) {
        maxS = item;
      }
    }
    System.out.println(maxS);
  }
}
