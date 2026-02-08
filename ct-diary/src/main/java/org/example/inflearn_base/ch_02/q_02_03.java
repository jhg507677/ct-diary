package org.example.inflearn_base.ch_02;

public class q_02_03 {

  public static void main(String[] args) {
    int[] aList = {2,3,3,1,3};
    int[] bList = {1,1,2,2,3};

    char[] result = new char[aList.length];
    for(int i = 0; i < aList.length; i++){
      int a = aList[i];
      int b = bList[i];
      if(a == b) result[i] = 'D';
      else if(
        (a == 1 && b == 3)
        || (a == 2 && b == 1)
        || (a == 3 && b == 2)
      ){
        result[i] = 'A';
      }else{
        result[i] = 'B';
      }
    }

    for(int i = 0; i < aList.length; i++){
      System.out.println(result[i]);
    }
  }
}

