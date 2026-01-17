# P.162 Q.11 [짝지어 제거하기]
출처 : 프로그래머스

## 접근 방식
붙어 있는 값끼리 제거한다고해서 스택 사용

## 개선사항
- Charcter 철자가 기억이 안남 ArrayDeque<Character> stack = new ArrayDeque<>();
- ArrayDeque대신 Stack 도 있음
- 제발 stack.push()안에 인자 꼭 넣자..

### 히스토리
- 260117 O