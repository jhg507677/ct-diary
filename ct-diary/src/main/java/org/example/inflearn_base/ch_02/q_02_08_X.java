package org.example.inflearn_base.ch_02;

public class q_02_08_X {
  public static int[] solution(int[] arr){
    int n = arr.length;
    int[] rank = new int[n];

    for (int i = 0; i < n; i++) {
      int cnt = 1; // 기본 등수는 1등부터

      // 자기 자신(arr[i]) 보다 큰 값들이 있으면 자기 자신의 등수를 1씩 증가
      for (int j = 0; j < n; j++) {
        if (arr[j] > arr[i]) {
          cnt++;
        }
      }
      rank[i] = cnt;
    }
    return rank;
  }
  public static void main(String[] args) {
    int[] arr = {87, 89, 92, 100, 76};
    for(int x : solution(arr)) System.out.println(x+ " ");
  }
}
