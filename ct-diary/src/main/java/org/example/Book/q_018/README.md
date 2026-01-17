# P.172 Q.13 [두 개의 수로 특정값 만들기]
출처 : 코딩 테스트 합격자 되기
Level : x

## 풀이 날짜
- 2026-01-17 

## 문제 풀이
```java

```

## 접근 방식
이중반복문을 통해서 풀었던 O(n 제곱)이라서 효율적 관점에서 탈락


## 정답
```java
class Solution {

  // {0,1,2,3}  
// target =5
// 2 + 3 = 5
// 3 = 5 -2
  public boolean solution(int[] arr, int target) {
    HashSet<Integer> bucket = new HashSet<>();
    for (int i = 0; i < arr.length; i++) {
      // arr[i] == 2라면 이미 3을 가지고 있으면 true;
      if (bucket.contains(target - arr[i]))
        return true;
      bucket.add(arr[i]);
    }
    return false;
  }
}
```

.. 이런 생각을 대체 어떻게 하지..



