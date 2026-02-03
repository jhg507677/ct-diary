# P.172 Q.13 [same tree]
출처 : 프로그래머스
Level : medium
사용 알고리즘 : 트리

## 풀이 날짜
- 2026-02-02 X 

## 문제 풀이
```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
  int preIndex = 0;
  Map<Integer, Integer> inMap = new HashMap<>();

  // inorder : 9,3,15,20,7
  public TreeNode buildTree(int[] preorder, int[] inorder) {
    // 중위순회에서 각 값의 위치를 미리 지정
    for(int i = 0; i< inorder.length; i++){
      // 9, 0
      // 3, 1
      // 15, 2
      inMap.put(inorder[i], i); // 중위순회의 값과 인덱스를 넣고
    }

    return dfs(preorder, 0, inorder.length - 1);
  }


  // 중위순회에서 가장 왼쪽에 있는 값이 첫번째로 나오고 가장 오른쪽에 있는 값이 마지막으로 나옴
  private TreeNode dfs(int[] preorder, int left, int right){

    // 현재 만들 서브트리의 범위가 비었음(인덱스니까 평소라면 무조건 오른쪽이 커야함)
    if(left > right) return null;

    // preorder는 루트, 왼쪽, 오른쪽 순서
    // 따라서 preIndex가 가리키는 값이 현재 서브트리의 루트
    int rootVal = preorder[preIndex];
    preIndex++;

    // 중위순회에서 해당 값 가져오기(3의 값의 인덱스 -> 1)
    int mid = inMap.get(rootVal);

    // preorder에서 3 기준으로 나눔 -> [9] | 3 | [15, 20, 7]
    // mid 기준 왼쪽은 왼쪽 서브트리
    // 현재 left=0, right=inorder.length - 1
    root.left = dfs(preorder, left, mid - 1);
    root.right = dfs(preorder, mid + 1, right);

    return root;
  }
}
```

## 기술회고
```java

```
## 회고
!!!!!!!