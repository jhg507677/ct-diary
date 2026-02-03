package org.example.programmers.level2.q_016;

import java.util.*;
class Solution {
  public int[] solution(int[] progresses, int[] speeds) {
    ArrayList<Integer> result = new ArrayList<>();


    // 1. 남은 일수를 구하고 해당 값을 배열에 저장
    // 2. 처음부터 반복문을 돌면서 max값을 저장하고
    // 2-1. max값보다 큰 값이 나오기전에 count를 +1한다.
    // 2- 2. max값보다 크면 해당 카운트를 결과 배열에 넣는다.

    ArrayDeque<Integer> leftDayList = new ArrayDeque<>();
    for(int i = 0 ; i < progresses.length; i++){
      int leftPercent = 100 - progresses[i];  // [7 , 70, 45]

      // 그냥 올림하면 되는데 기억이 안나
      int leftDay = leftPercent / speeds[i];
      if(leftPercent % speeds[i] != 0) leftDay++;
      leftDayList.add(leftDay);
    }

    // leftDayList = [7, 3, 9] // 7일째에 2개의 기능, 9일째에 1개의 기능이 배포가능
    // [1, 30, 5]
    int max = leftDayList.peekFirst(); // 7
    int count = 0;
    while(!leftDayList.isEmpty()){ // 3,9
      int item = leftDayList.pollFirst();
      // 이전값 7은 9보다 작기 때문에 이전값들 모두 제출

      // 남은 9는 어떻게 하지
      // 남은값들을 처리하는 법을 모르겠네..
      if(max < item) {
        result.add(count);
      }

      // 이전값 7은 7과 같기 때문에 배포 가능
      // 2. 이전값 7이 3보다 크기 때문에 배포 가능
      else {
        count++;
      }

    }
    return result.stream().mapToInt(Integer::intValue).toArray();
  }
}