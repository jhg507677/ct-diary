# P.162 Q.11 [올바른 괄호]
출처 : 프로그래머스
레벨 : 2
## 접근 방식


## 개선사항


## 히스토리
- 260127 O

## 기술회고
아래 부분 빠뜨릴뻔
```java
  // 서로 다른 모양이라면 뿐만아니라 서로 같은 방향을 바라보게 추가해야함
// 기존에 있는게 ( 이고 새로 들어온것이 ) 라면
if(manual.containsKey(stack.peek()) && manual.get(stack.peek()) == item){
  stack.pop();
  continue;
}
```