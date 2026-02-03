package org.example.programmers.level2.q_007;

import java.util.*;

class Solution{
  public int solution(String dirs){
    Map<Character, int[]> manual = Map.of(
      'U', new int[]{0, 1},
      'D', new int[]{0, -1},
      'R', new int[]{1, 0},
      'L', new int[]{-1, 0}
    );

    int[] cLocation = {5, 5};
    HashSet<String> history = new HashSet<>();
    for(int i = 0; i < dirs.length(); i++){
      char item = dirs.charAt(i);
      int ordX = cLocation[0];
      int ordY = cLocation[1];

      if(item == 'U' && ordY == 10) continue;
      if(item == 'D' && ordY == 0) continue;
      if(item == 'R' && ordX == 10) continue;
      if(item == 'L' && ordX == 0) continue;

      int changeX = ordX + manual.get(item)[0];
      int changeY = ordY + manual.get(item)[1];

      cLocation[0] += manual.get(item)[0];
      cLocation[1] += manual.get(item)[1];
      history.add(ordX + ","+ordY+"/"+changeX+","+changeY);

      // 반대쪽에서 온것도 처음 걸어본 길이 되는거니까 같은 취급을 해줘야함
      history.add(changeX + ","+changeY+"/"+ordX+","+ordY);
    }

    return history.size() / 2;
  }

}