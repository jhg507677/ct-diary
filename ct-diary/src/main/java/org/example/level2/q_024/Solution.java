package org.example.level2.q_024;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
class Solution {
  public List<String> solution(String[] record) {
    // 먼저 record만큼 반복하여 문구를 채운다.

    // uuid, 닉네임을 연결하는 HasgMap 생성
    // 동작과 uuid를 연결하는 HasgMap 생성
    HashMap<String, String> nameMap = new HashMap();
    HashMap<String, String> moveMap = new HashMap();

    int recordLength = record.length;

    ArrayList<String> changeRecord = new ArrayList<>();
    for(int i = 0; i < recordLength; i++){
      String[] str = record[i].split(" ");
      String uuid = str[1];
      if(str[0].equals("Enter")) {
        nameMap.put(uuid, str[2]);
        moveMap.put(uuid, str[0]);
      }else if(str[0].equals("Leave")){
        String name = nameMap.get(uuid);
        nameMap.put(uuid, name);
        moveMap.put(uuid, str[0]);
      }else if(str[0].equals("Change")){
        // nameMap의 값을 덮어씌워야함
        nameMap.put(uuid, str[2]);
        moveMap.put(uuid, str[0]);
      }
    }

    // Enter했을때 이전에 들어왔던 사람이라면 Enter시의 닉네임으로 변경한다.
    // change했을때 해당 uid 해당 하는 모든 닉네임을 변경한다.
    for(int i = 0; i < record.length; i ++){
      String[] str = record[i].split(" ");
      String uuid = str[1];
      if(str[0].equals("Enter")) {
        changeRecord.add(nameMap.get(uuid) + "님이 들어왔습니다.");
      }else if(str[0].equals("Leave")){
        changeRecord.add(nameMap.get(uuid) + "님이 나갔습니다.");
      }
    }
    return changeRecord;
  }
}