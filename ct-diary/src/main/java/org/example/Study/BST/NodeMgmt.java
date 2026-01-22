package org.example.Study.BST;

// 이진 탐색 트리 구현하기
public class NodeMgmt {
  Node head = null;
  public class Node {
    Node left;
    Node right;
    int value;

    public Node(int data){
      this.value = data;
      this.left = null;
      this.right = null;
    }
  }

  // 새로운 노드 값 입력하기
  public boolean insertNode(int data){
    // CASE 1 : Node가 하나도 없을때
    if(this.head == null){
      this.head = new Node(data);
    }else{
      // CASE 2 : Node가 하나 이상 들어가 있을때
      Node findNode = this.head;
      while(true){
        // CASE 2-1 : 현재 노드의 왼쪽에 Node가 들어가야 할 때
        if(data < findNode.value){
          if(findNode.left != null){
            findNode = findNode.left;
          }else{
            findNode.left = new Node(data);
            break;
          }
        }else{
          if(findNode.right != null){
            findNode = findNode.right;
          }else{
            findNode.right = new Node(data);
            break;
          }
        }
        // CASE 2-2 : 현재 노드의 오른쪽에 Node가 들어가야 할 때
      }
    }
    return true;
  }

  public Node search(int data){
    // CASE 1 : Node가 하나도 없을때
    if(this.head == null) return null;
    Node findNode = this.head;

    // CASE 2 : Node가 하나 이상 있을때
    while(findNode != null){
      if(findNode.value == data) return findNode;
      if(data < findNode.value){
        findNode = findNode.left;
      }else{
        findNode = findNode.right;
      }
    }

    return null;
  }

  // 노드 삭제
  public boolean delete(int value){
    // 삭제할 노드가 없는 경우는 false를 리턴하고 함수 종료
    boolean searched = false;
    Node currParentNode = this.head;
    Node currNode = this.head;

    // CASE 0. 노드가 한개도 없을때
    if(this.head == null) return false;

    // CASE 0-1. 노드가 단지 하나만 있고, 해당 노드가 삭제할 Node일때
    if(this.head.value == value && this.head.left == null && this.head.right == null){
      this.head = null;
      return true;
    }

    // currNode값을 찾을때까지 반복
    while(currNode != null){
      if(currNode.value ==  value){
        searched = true;
        break;
      }else if(value < currNode.value){
        currParentNode = currNode;
        currNode = currNode.left;
      }else{
        currParentNode = currNode;
        currNode = currNode.right;
      }
    }

    // 삭제할 노드가 없음
    if(searched == false) return false;

    // 여기까지 실행되면 currNode에는 해당 데이터를 가지고 있는 Node
    // currParentNode에는 해당 데이터를 가지고 있는 Node의 부모 Node

    // CASE 1. Left Node의 경우 그냥 삭제하고 부모의 right을 null로
    if(currNode.left == null && currNode.right == null){
      if(value < currParentNode.value) currParentNode.left = null;
      else currParentNode.right = null;
      return true;
    }
    // CASE 2. Child Node가 한개인경우 부모의 right가 현재 내 노드의 right 로 변경
    if(currNode.left != null && currNode.right == null){

      // 삭제하고자 하는 노드도 부모자식의 왼쪽에 있다면
      if(value < currParentNode.value){
        currParentNode.left = currNode.left;
      }else{
        currParentNode.right = currNode.left;
      }

      return true;
    }else if(currNode.right != null && currNode.left == null){
      if(value < currParentNode.value){
        currParentNode.left = currNode.right;
      }else{
        currParentNode.right = currNode.right;
      }
      return true;
    }

    // CASE 3. Child Node가 두개 이상인 경우
    // 삭제할 Node의 오른쪽 자식중 가장 작은 값을 삭제할 Node의 Parent Node가 가리키게 한다

    // CASE 3-1 : 삭제할 Node가 Child Node를 두 개 가지고 있고,

    // 삭제할 Node가 부모 Node의 왼쪽에 있을때
    if(value < currParentNode.value){
      // 가장 왼쪽의 노드의 값을 찾고 그 노드가 자식 노드를 지니고 있따면 부모 노드도 찾아야함
      Node changeNode =currNode.right;
      Node changeParentNode = currNode.right;
      while(changeNode.left != null){
        changeParentNode = changeNode;
        changeNode = changeNode.left;
        // null이 되는 순간은 가장 작은 값
      }

      // 여기까지 실행되는 changeNode에는 삭제할 Node의 오른쪽 Node 중에서 가장 작은 값을 가진 Node가 들어있음


      // Case 3-1-1:  changeNode의 ChildNode가 없을때
      if(changeNode.right == null){
        changeParentNode.left = null;

      }else{
        // Case 3-1-1:  changeNode의 오른쪽 ChildNode가 존재할때
        changeParentNode.left = changeNode.right;
      }

      // currParent의 왼쪽 child Node에 삭제할 Node의 오른쪽 자식중 가장 작은 값을 가진 changeNode
      currParentNode.left = changeNode;
      changeNode.right = currNode.right;
      changeNode.left = currNode.left;
      return true;
    }

    // 삭제할 Node가 부모노드의 오른족에 있을때
    else{
      Node changeNode =currNode.right;
      Node changeParentNode = currNode.right;
      while(changeNode.left != null){
        changeParentNode = changeNode;
        changeNode = changeNode.left;
        // null이 되는 순간은 가장 작은 값
      }

      if(changeNode.right == null){
        changeParentNode.left = null;

      }else{
        // Case 3-1-1:  changeNode의 오른쪽 ChildNode가 존재할때
        changeParentNode.left = changeNode.right;
      }

      // 삭제할 노드의 오른쪽 자식중 가장 작은값을 가진 node를 연결
      currParentNode.right = changeNode;
      changeNode.right = currNode.right;
      changeNode.left = currNode.left;
      return true;
    }

    return true;
  }
}
