# P.319 Q.28 [길찾기 게임]
출처 : 프로그래머스
Level : 3

## 풀이 날짜
- 2026.02.02 X

## 문제 풀이
```java
import java.util.*;
class Solution {
  public int[][] solution(int[][] nodeinfo) {
    private static class Node{
      int num, x, y;
      Node left, right;
      public Node(int num, int x, int y){
        this.num = num;
        this.x = x;
        this.y = y;
      }
    }

    // 이진트리 생성 메서드
    private static Node makeTree(int[][] nodeinfo){
      Node[] nodes = new Node[nodeInfo.length];

      // 일단 값을 넣고 정렬하면 됨             
      for(int i = 0 ; i < nodeinfo.length; i++){
        // 순서대로 num, x, y
        nodes[i] = new Node(i +1, nodeinfo[i][0], nodeinfo[i][1]);
      }

      // y기준으로 내림차순 정렬, y가 같다면 x를 기준으로 오름차순 정렬
      Arrays.sort(nodes, (o1, o2) -> {
        if(o1.y == o2.y) return Integer.compare(o1.x, o2.x);
        else return Integer.compare(o2.y, o1.y);
      });

      Node root = nodes[0]; //  맨 처음 노드는 무조건 루트

      for(int i = 1; i < nodes.length; i++){
        Node parent = root;

        // 리프노드가 되면 자연스럽게 탈출하게됨
        while(true){
          // 현재 노드의 X 좌표보다 < 부모노드의 X좌표가 더 크면 왼쪽으로                    
          if(nodes[i].x < parent.x){
            // 현재 부모 노드의 왼쪽 자식 노드가 없으면 바로 부모 노드의 왼쪽 자식 노드를 현재 노드로 하고 반복문 탈출
            if(parent.left == null){
              parent.left = nodes[i];
              break;
            }else{
              parent = parent.left;
            }
          }else{
            if(parent.right == null){
              parent.right = nodes[i];
              break;
            }else{
              parent = parent.right;
            }
          }
        }
      }
      return nodes[0];
    }

    public static volid preOrder(Node node, ArrayList<Integer> answer){
      if(node == null) return;
      answer.add(node.num);
      preOrder(node.left, answer);
      preOrder(node.right, answer);
    }
    public static volid inOrder(Node node, ArrayList<Integer> answer){
      if(node == null) return;
      inOrder(node.left, answer);
      answer.add(node.num);
      inOrder(node.right, answer);

    }
    public static volid postOrder(Node node, ArrayList<Integer> answer){
      if(node == null) return;
      postOrder(node.left, answer);
      postOrder(node.right, answer);
      answer.add(node.num);
    }
    public int[][] solution(int[][] nodeInfo){
      Node root = makeTree(nodeinfo);
      ArrayList<Integer> preOrderResult = new ArrayList<>();
      perOrder(root, preOrderResult);
      ArrayList<Integer> postOrderResult = new ArrayList<>();
      perOrder(root, postOrderResult);

      int[][]result = new int[2][nodeInfo.length];
      result[0] = Arrays.stream(preOrderResult).mapToInt(Integer::intValue).toArray();
      result[1]= Arrays.stream(postOrderResult).mapToInt(Integer::intValue).toArray();
      return result;

    }
  }
```

## 기술 회고

## 회고
언제쯤이면 트리가 익숙해질까...