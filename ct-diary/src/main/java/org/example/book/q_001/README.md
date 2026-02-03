# P.108 Q.13 [배열정렬하기]
출처 : 코딩 테스트 합격자 되기
Level : x

## 풀이 날짜
- 2026-01-26 O

## 문제 풀이
Arrays.sort가 아닌 버블 정렬 사용해서 구현하기
```java
private static int[] bubbleSort(int[] org){
  int[] arr = org.clone();
  int n = arr.length;
  
  for(int i = 0 ; i < arr.length; i++){
    for(int j = 0 ; j < arr.length - i - 1; j++){
      
      // 두개의 값을 변경해야함`      
      if(arr[j] > arr[j + 1]){
        int temp = arr[j];
        arr[j] = arr[j + 1];
        arr[j + 1] = temp;
      }
    } 
  }
}
```

## 접근 방식


## 개선사항