package org.example.Book.q_025;

import java.util.HashSet;

/*
이진 트리를 표현할 배열 nodes를 인자로 받는다.
해당이진 트리에 대하여 전위 순회, 중위 순회, 후위 순회 결과를 반환하는 함수를 구하시오.
*/
class Solution
{
  //
  /*
  {1, 2, 3, 4, 5, 6, 7}
          1
       /     \
      2       3
     / \     / \
    4   5   6   7
  */
  public static String[] solution(int[] nodes)
  {
    String[] result = new String[3];
    result[0] = preorder(nodes, 0).trim();
    result[1] = inorder(nodes, 0).trim();
    result[2] = postorder(nodes, 0).trim();
    return result;
  }

   //
  /*
  전위 순회 (Preorder) 루트 → 왼쪽 → 오른쪽
  1. 현재 노드 값 출력
  2. 왼쪽 서브트리 순회
  3. 오른쪽 서브트리 순회
  */
  private static String preorder(int[] nodes, int idx){
    if(idx >= nodes.length){
      return "";
    }

    // 0번부터 시작하니까 다음 왼쪽 인덱스의 값은 2 * 배열 인덱스  +1
    return nodes[idx] + " " + preorder(nodes, 2 * idx + 1) + preorder(nodes, 2 * idx + 2);
  }

  //
  /*
  중위 순회
  왼쪽 → 루트 → 오른쪽
  */
  private static String inorder(int[] nodes, int idx){
    if(idx >= nodes.length){
      return "";
    }
    return inorder(nodes, 2 * idx + 1) + nodes[idx]+ inorder(nodes, 2 * idx + 2);
  }

  // 후위 순회
  /*
   후위 순회 (Postorder)
  */
  private static String postorder(int[] nodes, int idx){
    if(idx >= nodes.length){
      return "";
    }
    return postorder(nodes, 2 * idx + 1) + postorder(nodes, 2 * idx + 2) + nodes[idx] + " ";
  }
}


