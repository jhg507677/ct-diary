# P.172 Q.13 [최소직사각형]
출처 : 프로그래머스
Level : 1
사용 알고리즘 : 완전탐색
## 풀이 날짜
- 2026-01-26 o

## 문제 풀이
```java
class Solution {
    public int solution(int[][] sizes) {
      // 최댓값
        int maxW = 0;
        int maxH = 0;

        for (int[] size : sizes) {
            // 각 행중에 큰값을 w, 작은값을 h로 둔 후에 w의 최댓값과 h의 최댓값을 구할 수 있다.          
            int w = Math.max(size[0], size[1]);
            int h = Math.min(size[0], size[1]);

            maxW = Math.max(maxW, w);
            maxH = Math.max(maxH, h);
        }

        return maxW * maxH;
    }
}
```

## 접근 방식

## 기술 회고
반복문 1개로 가능한 문제였다.
최댓값은 Math.max()로 구할것