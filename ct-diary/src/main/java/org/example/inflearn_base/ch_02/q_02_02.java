package org.example.inflearn_base.ch_02;

public class q_02_02 {

  public static void main(String[] args){
    int a = 8;
    // 앞에 사람들보다 키가 커야지 보임
    // 앞에 사람은 무조건 보이는 거고 앞에 사람을 max로 두고 max보다 크면 보이는걸로, 같으면 보이지않음
    int[] b = {130,135,148,140,145,150,150,153};
    int result = 1;
    int max = b[0]; // 130

    for(int i = 1 ; i < b.length; i++){
      if(b[i] > max) {
        result++;
        max = b[i];
      }
    }
    System.out.print(result);
  }
}
