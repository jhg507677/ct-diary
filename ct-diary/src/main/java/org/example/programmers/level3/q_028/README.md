# P.319 Q.28 [양과 늑대]
출처 : 프로그래머스
Level : 3

## 풀이 날짜
- level 3은 다음 기회에 

## 문제 풀이
```java
import java.util.*;


class Solution {
    // 현재 위치, 양의 수 ,늑대의 수, 방문한 노드 저장
    static class Node{
        int location;
        int sheepCount;
        int wolfCount;
        HashSet<Integer> visited; // 인덱스가 들어올것임

        public Node(int location, int sheepCount, int wolfCount, HashSet<Integer> visited){
            this.location = location;
            this.sheepCount = sheepCount;
            this.wolfCount = wolfCount;
            this.visited = visited;
        }
    }
    // 당신이 모은 양의 수보다 =< 늑대의 수가 같거나 더 많아지면 바로 모든 양을 잡아먹어 버립니다.
    // 각 노드에 있는 양 또는 늑대에 대한 정보가 담긴 배열 info, 2진 트리의 각 노드들의 연결 관계를 담은 2차원 배열 edges가 매개변수로 주어질 때
    
    
    
    private static ArrayList<Integer>[] tree; // [ ArrayList 객체, ArrayList 객체, ArrayList 객체 ]

  // 1. 트리 구축  
  // info : [0,0,1,1,1,0,1,0,1,0,1,1]
  private static void buildTree(int[] info, int[][] edges){
        tree = new ArrayList[info.length]; // 배열의 길이 설정해줘야함
        // [[0,1],[1,2],[1,4],[0,8],[8,7],[9,10],[9,11],[4,3],[6,5],[4,6],[8,9]]
        for(int[] item : edges){
           if(tree[item[0]] == null) tree[item[0]] = new ArrayList<>();
            tree[item[0]].add(item[1]);
        }
    }
    
 
    public int solution(int[] info, int[][] edges) {
        buildTree(info, edges);
       int answer = 0;
        
        // 전체 탐색을 해야하므로 너비 우선 탐색으로
        // 현재 위치, 양의 수 ,늑대의 수, 방문한 노드 저장
        ArrayDeque<Node> queue = new ArrayDeque<>();
        queue.addLast(new Node(0, 1, 0, new HashSet<>()));
        
        while(!queue.isEmpty()){
            Node now = queue.pollFirst();
            
            // 최대 양의 수 갱신            
            answer = Math.max(answer, now.sheepCount);
            
            // 방문할 노드 집합에 현재 노드의 이웃 노드 추가             
            if (tree[now.location] != null) now.visited.addAll(tree[now.location]);
            
            // 인덱스
            for(int next : now.visited){
                // 현재 방문한 곳은 삭제                
                HashSet<Integer> temp = new HashSet<>(now.visited);
                temp.remove(next);
                
                // 요번에 만나는게 늑대라면                
                if(info[next] == 1){
                    // 현재 늑대 + 1 한값보다  양의 갯수가 더 많으면
                    if(now.sheepCount > now.wolfCount + 1){
                        queue.add(new Node(next, now.sheepCount, now.wolfCount + 1, temp));
                    }
                }
                
                // 만난게 양이라면                
                else{
                    queue.add(new Node(next, now.sheepCount + 1, now.wolfCount, temp)); 
                }
            }
        }
        
        // 각 노드를 방문하면서 최대 만날 수 있는 양의 갯수         
        return answer;
    }
}


```

## 접근 방식

## 개선사항