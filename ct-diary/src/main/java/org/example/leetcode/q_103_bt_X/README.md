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
  // 최대 깊이를 구해라
  public int maxDepth(TreeNode root) {
    int result = 0;
    if(root == null) return result;
    ArrayDeque<TreeNode> queue = new ArrayDeque<>();
    queue.add(root);

    while(!queue.isEmpty()){
      result++;
      int siCount = queue.size(); // 형제 개수 고정
      for(int i = 0 ; i < siCount; i++){
        TreeNode firstSi = queue.pollFirst();
        if(firstSi.left != null) queue.addLast(firstSi.left);
        if(firstSi.right != null) queue.addLast(firstSi.right);
      }
    }
    return result;
  }
}
```

## 기술회고

## 회고
드디어 맞췄네......