package org.example.programmers.level1.q_019_O;

import java.util.HashMap;

class Solution {
  public String solution(String[] participant, String[] completion) {
//         String answer = "";

//         // 완주한 사람 ["stanko", "ana", "mislav"]


//         for(int i = 0 ; i < completion.length; i++){
//             completionHash.add(completion[i]);
//         }

//          for(int i = 0 ; i < participant.length; i++){
//             if(!completionHash.contains(participant[i])) answer =  participant[i];
//         }
//          return answer;
    HashMap<String, Integer> hash = new HashMap();
    for(int i = 0 ; i < participant.length; i++){
      // 동명이인이라면
      if(hash.containsKey(participant[i])) {
        hash.put(participant[i], hash.get(participant[i])+1);
      }else{
        hash.put(participant[i], 1);
      }
    }

    // eden
    for(int i = 0 ; i < completion.length; i++){
      // 완주한 사람이라면
      if(hash.containsKey(completion[i])) {
        hash.put(completion[i], hash.get(completion[i])-1);
      }
    }


    for(String key : hash.keySet()){
      if(hash.get(key) != 0) return key;
    }
    return "";

  }
}

// 아 동명이인...
