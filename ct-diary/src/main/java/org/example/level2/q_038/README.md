# P.208 Q.16 [네트워크]
출처 : 프로그래머스
Level : 깊이 우선 탐색

## 풀이 날짜
- 2026-01-23 X

## 기술 회고
1. 반드시 this 입력할것
```java
  class Node{
    int x;
    int y;
    public Node(int x, int y){
      this.x = x;
      this.y = y;
    }
  }
```

2. 초기화에는 2가지 과정이 더 필요함
① 방문/거리 배열 초기화
② 시작 위치(S) 찾기 (무조건 0,0이 아님)
```java
int startX = 0, startY = 0;
  for (int i = 0; i < M; i++) {
map[i] = _map[i].toCharArray();
      for (int j = 0; j < N; j++) {
dist[i][j] = -1;
  if (map[i][j] == 'S') {
startX = i;
startY = j;
        }
          }
          }
```

## 회고

