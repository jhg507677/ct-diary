# P.172 Q.13 [same tree]
출처 : 프로그래머스
Level : easy
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
  public boolean isSymmetric(TreeNode root) {
    if(root == null) return true;
    return isMirror(root.left, root.right);

  }

  private boolean isMirror(TreeNode a, TreeNode b){
    // 가장 아래쪽 리프노드까지 모두 내려오면 결과 true로 반환
    if(a == null && b == null) return true;

    if(a == null || b == null) return false;
    if(a.val != b.val) return false;

    return isMirror(a.left, b.right) && isMirror(a.right, b.left);
  }
}
```

## 기술회고

## 회고
언젠간 풀수있기를