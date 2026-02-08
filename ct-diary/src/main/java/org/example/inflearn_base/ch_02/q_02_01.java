package org.example.inflearn_base.ch_02;

public class q_02_01 {
  public static void main(String[] args){
    int[] arr = {7, 3, 9, 5, 6, 12};

    StringBuilder sb = new StringBuilder();
    int first = 6;
    for(int i = 0; i < arr.length; i++){
      if(arr[i] > first) sb.append(" "+arr[i]);
      first = arr[i];
    }
    System.out.println(sb);
  }
}
