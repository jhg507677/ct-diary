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
  public List<List<Integer>> levelOrder(TreeNode root) {
    // 같은 레벨의 값을 가져오기 위해 너비우선탐색 사용
    List<List<Integer>> result = new ArrayList<>();
    if(root == null) return result;

    // 루트 노드 삽입 후
    ArrayDeque<TreeNode> queue = new ArrayDeque<>();
    queue.add(root);

    // 아직 방문 안한 노드가 있으면 계속 탐색
    while(!queue.isEmpty()){
      int siCount = queue.size(); // 형제들의 노드 갯수
      List<Integer> level = new ArrayList<>();

      // 형제들의 갯수만큼 반복
      for(int i = 0 ; i < siCount; i++){
        TreeNode sibling = queue.pollFirst(); // 형제 한개를 추출해서
        level.add(sibling.val);

        if(sibling.left != null) queue.addLast(sibling.left);
        if(sibling.right != null) queue.addLast(sibling.right);
      }
      result.add(level);
    }
    return result;
  }
}
```

## 기술회고

## 회고
!!!!!!!