package org.example.Book.q_015;

import java.util.ArrayDeque;

// 요세푸스 문제
// N명의 사람이 원 형태
// 각 사람은 1부터 N까지 번호표
// k번째 사람 제거
class Solution
{
  // N : 총 사람 수
  // k는 제거할 사람 수
  public int solution(int N, int K) {

    // 1번부터 시작
    ArrayDeque<Integer> queue = new ArrayDeque<>();

    // queue는 꼭 반복문을 돌려야지만 값을 넣을 수 있을까?
    for(int i = 1; i < N + 1; i++){
      queue.addLast(i);
    }


    // 마지막 한명만 남을때까지
    while(queue.size() == 1){
      // q의 k번째 사람 제거를 할려면 k번째가 아닌 그 앞에 있는 사람은 뒤로 보내면 됨
      // 즉 1, 2, 3이고 K가 2이면 3은 뒤로 보내면 됨 3, 1 ,2하고 2는 삭제
      for(int i = 0; i < K; i++){
        int temp = queue.pollFirst();
        if(temp != K){
          queue.addLast(temp);
        }
        // k라면 해당 값은 그냥 삭제
      }
    }


    // return : 마지막에 살아있는 사람의 번호
    return queue.pollFirst();
  }
}

