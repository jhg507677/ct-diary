package org.example.Book.q_015;

import java.util.ArrayDeque;
import java.util.Arrays;

//class Solution
//{
//  // N : 사람의 수
//  // k 없애는 사람
//  public int solution(int N, int K)
//  {
//    int[] people = new int[N+1];
//    int count = 0;
//    // k가 2라면
//
//    int current = 1;
//    while(people.length >= 1){
//      // // k가 2라면 2 -1 % 5 -> 1번뒤에 있는 사람 삭제
//      int real =  K-1 % people.length;
//
//      people[current+real] = 0; // 제거됨
//    }
//
//
//    return Arrays.stream(people).filter(i -> i == 1).findAny().getAsInt();
//  }
//}

// Queue로 구현하면
class Solution
{
  // N : 사람의 수
  // k 없애는 사람
  public int solution(int N, int K) {

    // 사람의 번호수를 Queue에 삽입
    // 첫번째에 넣은건 가장 마지막ㅇ
    ArrayDeque<Integer> number = new ArrayDeque<Integer>();
    for(int i = 1; i < N+1; i++){
      number.addLast(i);
    }

    while(number.size() > 1){
      // K 번째 요소를 찾기 위해 앞에서부터 제거하고 뒤에 추가
      // 만약에 k가 2라면
      for(int i = 0; i < K -1; i++){
        number.addLast(number.pollFirst()); // 0번째걸 빼서 가장 마지막에 붙이기
      }
      number.pollFirst();
    }
    return number.pollFirst();
  }
}

