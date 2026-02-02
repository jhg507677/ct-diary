# P.172 Q.13 [몸풀기 문제]
출처 : 코딩 테스트 합격자 되기
Level : x
사용 알고리즘 : 트리

## 풀이 날짜
- 2026.02.01

## 문제 풀이
```java
package org.example.Book.q_025_X;

class Solution
{
  // nodes = {1,2,3,4,5,6,7}
  // 해당 이진 트리에 대해 전위 순회, 중위 순회, 후위 순회 결과 리턴하는 함수
  public static String[] solution(int[] nodes)
  {
    String[] result = new String[3];
    result[0] = preorder(nodes, 0).trim();
    result[1] = inorder(nodes, 0).trim();
    result[2] = postorder(nodes, 0).trim();
    return result;
  }


  // 부모 -> 왼쪽 -> 오른쪽
  private static String preorder(int[] nodes, int idx) {
    if(idx >= nodes.length) return "";

    // 0부터 시작하니까
    return nodes[idx] + " " + preorder(nodes, 2 * idx+ 1) + preorder(nodes, 2 * idx+ 2);

    /*
      1. preorder(nodes, 0)
      부모: nodes[0] = 1 → 문자열에 "1 " 추가
      왼쪽 재귀: preorder(nodes, 1)
      오른쪽 재귀: preorder(nodes, 2)
    */
}

  private static String inorder(int[] nodes, int idx) {
    if(idx >= nodes.length) return "";

    return inorder(nodes, 2 * idx+ 1) + nodes[idx] + " " + inorder(nodes, 2 * idx+ 2);
  }

  private static String postorder(int[] nodes, int idx) {
    if(idx >= nodes.length) return "";

    return postorder(nodes, 2 * idx+ 1) + postorder(nodes, 2 * idx+ 2) + nodes[idx] + " " ;
  }
}
```

## 접근 방식

## 정답



