package org.example.inflearn_base.ch_01;

import java.util.Scanner;

public class q_01_04 {
  public static void main(String[] args){
    Scanner in=new Scanner(System.in);
    int size = in.nextInt();
    String[] arr = new String[size];
    for(int i = 0 ; i <size; i++){
      arr[0] = in.next();
    }

    StringBuilder[] result = new StringBuilder[size];

    for(int i = 0 ; i < arr.length; i++){
      result[i] = new StringBuilder();
      for(int j = arr[i].length() -1  ; j >= 0; j--){
        result[i].append(arr[i].charAt(j));
      }
    }

    for(int i = 0 ; i < arr.length; i++){
      System.out.println(result[i]);
    }
  }
}

/*
초기화 잊지말고 result[i] = new StringBuilder();
제발 오타좀 내지말자 제발.....

아래는 답안
StringBuilder().reverse() 가 존재함
public class q_01_04 {
  public static void main(String[] args){
    Scanner in=new Scanner(System.in);
    int size = in.nextInt();
    String[] arr = new String[size];
    String[] result = new String[size];
    for(int i = 0 ; i <size; i++){
      arr[0] = in.next();
    }

    int count = 0;
    for(String str : arr){
      String reverseString =  new StringBuilder(str).reverse().toString();
      result[count] = reversString;
      count++;
    }

    for(int i = 0 ; i < result.length; i++){
      System.out.println(result[i]);
    }
  }

  양옆에 있는 문자를 뒤집으려면
  ArrayList<String> result = new ArrayList<>();

  // hello
  for(String item : result){
    char[] charArr = item.toCharArray();
    int left = 0;
    int right = item.length() - 1;
    while(left < right){
      char temp = charArr[left];
      charArr[left] = charArr[right]
      charArr[right] = temp;
      left++;
      right--;
    }
    String reverse = String.valueOf(charArr);
    result.add(reverse);
  }
*/