package org.example.inflearn_base.ch_01;

import java.util.Arrays;
import java.util.Scanner;

public class q_01_10 {

    public static void main(String[] args){
      Scanner in=new Scanner(System.in);
      String str = in.next();
      char target = in.next().charAt(0);
      int n = str.length();
      // 거리 측정
      int[] result= new int[n];

      int count = 201; // 최댓값 * 2 + 1
      for(int i =0 ; i < n; i++){
        char item = str.charAt(i);
        if(item == target) {
          result[i] = 0;
          count = 0;
        }
        else{
          result[i]=count;
        }
        count++;
      }

      // 이젠 반대로 뒤집어서
      for(int i =n - 1 ; i >= 0; i--){
        char item = str.charAt(i);
        if(item == target) count = 0;
        else{
          // 이번엔 바로 업데이트하는 것이 아니라 이전값과 비교해서 더 작은 값을 넣어야함
          if(result[i] > count) result[i]=count;
          // 작은 값 가져오기 : Mach.min(result[i],count)
        }
        count++;
      }


      // 이제 해당 배열을 출력
//      Arrays.stream(result).map(i -> System.out.println(i + ""));
      for(int i =0 ; i < n; i++) {
        System.out.print(result[i] + " ");
      }
    }
}
