package org.example.최소직사각형.template;

class Solution {
  public int solution(int[][] sizes) {
    int answer = 0;
    for(int i = 0; i< sizes.length; i++){
      if(sizes[i][0] < sizes[i][1]) {
        int temp = sizes[i][1];
        sizes[i][1] = sizes[i][0];
        sizes[i][0] = temp;
      }
    }


    int oneMax = sizes[0][0];
    int twoMax = sizes[0][1];
    for(int i = 0; i< sizes.length; i++){
      if(sizes[i][0] > oneMax) oneMax = sizes[i][0];
      if(sizes[i][1] > twoMax) twoMax = sizes[i][1];
    }

    return oneMax * twoMax;

    // 한쪽을 가장 크게 만들면 될 것 같은데
    // 반복문을 돌려서 [i][0] 번째를 큰값, [i][1]를 작은값으로 둔후

    // 각 최대값을 구하여 곱하면 완료
  }
}