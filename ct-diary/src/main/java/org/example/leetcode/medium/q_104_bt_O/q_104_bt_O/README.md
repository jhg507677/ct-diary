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
  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();
    if (root == null) return result;

    ArrayDeque<TreeNode> queue = new ArrayDeque<>();
    queue.add(root);

    boolean leftToRight = true;

    while (!queue.isEmpty()) {
      int size = queue.size();
      List<Integer> level = new ArrayList<>(size);

      for (int i = 0; i < size; i++) {
        TreeNode cur = queue.pollFirst();

        if (leftToRight) {
          level.add(cur.val);
        } else {
          // 0번 인덱스에 현재값을 넣는다. 앞에 끼워넣기가 가능하게 됨
          level.add(0, cur.val);\
        }

        if (cur.left != null) queue.addLast(cur.left);
        if (cur.right != null) queue.addLast(cur.right);
      }

      result.add(level);
      leftToRight = !leftToRight; // 방향 토글
    }

    return result;
  }
}
```

## 기술회고
```java
해당 부분 강조!!!!
// 0번 인덱스에 현재값을 넣는다. 앞에 끼워넣기가 가능하게 됨
level.add(0, cur.val);
```
## 회고
!!!!!!!