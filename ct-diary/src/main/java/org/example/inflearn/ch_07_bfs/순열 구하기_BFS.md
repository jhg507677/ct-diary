```java
import java.util.*;

/**
문제: 중복 허용 순열

1부터 N까지 번호가 적힌 구슬이 있습니다.
이 중 중복을 허용하여 M번을 뽑아 일렬로 나열하는 방법을 모두 출력하세요.

입력
N: 구슬 개수
M: 뽑는 횟수

출력: 가능한 모든 순열을 문자열 배열 형태로 반환

예시: N = 3, M = 2

출력:
[ "1 1", "1 2", "1 3",
  "2 1", "2 2", "2 3",
  "3 1", "3 2", "3 3" ]
*/
class Solution {
    public String[] solution(int n, int m) {
        List<String> result = new ArrayList<>();
        ArrayDeque<List<Integer>> q = new ArrayDeque<>();

        // 1~N까지 초기 큐에 넣기 (각각 리스트로)
        for (int i = 1; i <= n; i++) {
            List<Integer> temp = new ArrayList<>();
            temp.add(i);
            q.addLast(temp);
        }

        // BFS 진행
        while (!q.isEmpty()) {
            int size = q.size(); // 현재 레벨에 있는 노드 개수, n의 갯수와 동일
            for (int i = 0; i < size; i++) {
                List<Integer> nowList = q.pollFirst(); // [1][2][3]

                // 길이가 M이면 결과에 저장
                if (nowList.size() == m) {
                    String s = nowList.stream()
                            .map(String::valueOf)
                            .reduce((a, b) -> a + " " + b)
                            .get();
                    result.add(s);
                    continue; // 더 이상 자식 노드 생성 X
                }

                // 길이가 M이 아니면 다음 숫자 추가
                for (int j = 1; j <= n; j++) {
                    List<Integer> nextList = new ArrayList<>(nowList); // 현재 경로 복사 // 각 큐 안에 arrayList [1], [2], [3] 
                    nextList.add(j); // 다음 숫자 추가  [1, 1], [2, 1], [3, 1] ..
                    q.addLast(nextList);
                }
            }
        }

        return result.toArray(new String[0]);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(Arrays.toString(sol.solution(3, 2)));
        // 출력: [1 1, 1 2, 1 3, 2 1, 2 2, 2 3, 3 1, 3 2, 3 3]
    }
}
```