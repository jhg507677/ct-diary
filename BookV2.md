## P.108문제 1. 배열 정렬하기
```java
class Solution {
  boolean solution(int[] param) {
  }
}
```

# 배열
## P.108 문제01. 배열 정렬하기
```java
import java.util.Arrays;
class Solution {
  int[] solution(int[] param) {
    return Arrays.sort(param);
  }
}
```

## P.108 문제02. 배열 제어하기
배열의 중복값을 제거하고 배열 데이터를 내림차순으로 정렬

```java
import java.util.Arrays;
class Solution {
  int[] solution(int[] param) {
    return Arrays.stream(param) // Arrays.stream()의 반환타입은 IntStream
  .distinct()
  .boxed() // IntStream은 오름차순으로만 정렬가능한 sorted() 함수만 존재하기 때문에 Stream<Integer>으로 변환 필요
  .sort(Comparator.reverseOrder())
  .mapToInt(Integer::intValue) // 다시 Stream<Integer>를 intStream으로 변환
  .toArray(); 
  }
}
```

## P.116 문제03. 두 개 봅아서 더하기
```java
import java.util.*;
class Solution {
  public int[] solution(int[] numbers) {
    ArrayList<Integer> result = new ArrayList<>();
    // 마지막 인덱스는 첫 번째 수(i)가 될 수 없기 때문에 -1
    for(int i = 0; i < numbers.length-1; i++){
      for(int j = i+1; j < numbers.length; j++){
        int sum = numbers[i] + numbers[j];
        result.add(sum);
      }
    }
    return result.stream().sorted().distinct().mapToInt(Integer::intValue).toArray();
  }
}
```

## P.119 문제04. 모의고사
```java
import java.util.*;

class Solution {
  public int[] solution(int[] answers) {
    // 패턴 반복
    // 1번 [1, 2, 3, 4, 5]
    // 2번 [2, 1, 2, 3, 2, 4, 2, 5]
    // 3번 [3, 3, 1, 1, 2, 2, 4, 4, 5, 5]

    int[][] pattern = {
      {1,2,3,4,5},
      {2, 1, 2, 3, 2, 4, 2, 5},
      {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
    }
      ;
    int[] score = new int[pattern.length];


    for(int i = 0; i < answers.length; i++){
      for(int j = 0; j < pattern.length; j++){ // 사람 수 만큼 반복
        if(answers[i] == pattern[j][i % pattern[j].length]){
          score[j] += 1;
        }
      }
    }

    // 가상 점수 : {5, 1, 3}

    // 가장 놓은 점수

    ArrayList<Integer> result = new ArrayList<>();
    int max = Arrays.stream(score).max().getAsInt();
    for(int i = 0; i < score.length; i++){
      if(max == score[i]) result.add(i+1);
    }
    return result.stream().sorted().mapToInt(Integer::intValue).toArray();

    // 가장 점수가 높은 인덱스를 뽑아서 + 1의 배열을 리턴
  }
}
```


## P.123 문제05. 행렬의 곱셉 (-2)
```java
class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        
        // 결과를 저장할 2차원 배열 초기화(행, 열의 갯수)
        int[][] result = new int[arr1.length][arr2[0].length];
        
        for(int i =0; i < arr1.length; i++){ // 3
            for(int j =0; j < arr2[0].length; j++){ // 2
                
                
                for(int k =0; k < arr1[0].length; k++){ 
                    //k == 0 1*3
                    //k == 1 4*5
                    // 둘이 더한 값이 result[0[0]
                    result[i][j] += arr1[i][k] * arr2[k][j];
                    
                    // [[1, 4], [3, 2], [4, 1]]	곱하기 [[3, 4], [5, 6]]
                    // result[0][0] = ((1 * 3) + (4 * 5)) (arr1[0][0] * arr2[0][0]) + (arr1[0][1] * arr2[1][0])
                    // result[0][1] = ((1 * 4) + (4 * 6)) (arr1[0][0] * arr2[0][1]) + (arr1[0][1] * arr2[1][1])
                }
            }   
        }
        return result;
    }
}
```

## P.132 문제07. 방문 길이 (-2)
```java
import java.util.*;

class Solution{
    public int solution(String dirs){
        int[] current = {5, 5};
        
        HashSet<String> history = new HashSet<>();
        
        for(int i = 0; i < dirs.length(); i++){
            int x = current[0];
            int y = current[1];
            
            int nx = x;
            int ny = y;
            
            char d = dirs.charAt(i);
            if (d == 'U' && y < 10) ny++;
            else if (d == 'D' && y > 0) ny--;
            else if (d == 'L' && x > 0) nx--;
            else if (d == 'R' && x < 10) nx++;
            else continue;
            
            history.add(x + " , "+ y +" -> " + nx + " , "+  ny);
            history.add(nx + " , "+ ny +" -> " + x + " , "+  y);
            
            current[0] = nx;
            current[1] = ny;
        }
        
        return history.size() / 2;
        
    }
    
}
```

## P.148 문제08. 올바른 괄호() lv2
```java
import java.util.*;
class Solution {
    boolean solution(String s) {
       char[] manual = {'(',')'};
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            // 내가 푼거
            if(stack.isEmpty()) {
                if(s.charAt(i) == ')') return false;
                stack.push(s.charAt(i));
            }
            else{
                if(stack.peek() == '(' && s.charAt(i) == ')'){
                    stack.pop();
                }else{
                    stack.push(s.charAt(i));
                }
            }
            
            // 답안
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(c);
            } else { // ')'
                if (stack.isEmpty()) return false;
                stack.pop();
            }
        }
        if(!stack.isEmpty()) return false;
        else return true;
    }
}
```

## p . 153 문제 09 10진수를 2진수로
```java
class Solution{
    public String solution(int ten){
      ArrayDeque<Integer> two = new ArrayDeque<Integer>();
      // 10 / 2 몫을 스택으로 저장
      while(ten > 0){
        two.push(ten % 2);
        ten = ten / 2;
      }
      
      StringBuilder result = new StringBuilder();
      // 스택은 for문 보다는
//      for(Integer item : two){
//        result.append(item);
//      }
      
      while(!two.isEmpty()){
        result.append(item);
      }
      return result.toString();
      
      // 스트림 사용하면(코테에선 비추)
      two.stream().map(String::valueOf).collect(Collectors.joining());
    }
}
```


## P.157. 문제 10, 괄호 회전하기 lv2
```java

```