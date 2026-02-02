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
    public boolean isSameTree(TreeNode p, TreeNode q) {
      if(p == null && q == null) return true;

      // 한개만 null이라면
      if(p == null || q == null) return false;

      if(p.val != q.val) return false;
      return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
```

## 기술회고

## 회고
어떻게 이런생각을 하지..?