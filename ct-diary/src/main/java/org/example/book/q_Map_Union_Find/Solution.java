package org.example.book.q_Map_Union_Find;

import java.util.HashMap;
import java.util.Map;

// Map으로 구현하는 집합
class UnionFind<T>{
  private final Map<T, T> parent = new HashMap<>();

  // 초기 원소 등록(초기 등록시에는 자기 자신을 루트로 지정)
  public void makeSet(T t){
    parent.put(t, t);
  }

  // t가 속한 집합의 루트를 리턴
  public T find(T t){
    // 해당 값이 존재하지 않다면 루트로 지정
    if(!parent.containsKey(t)){
      parent.put(t, t);
      return t;
    }

    // 루트임
    if(parent.get(t).equals(t)){
      return t;
    }

    T root = find(parent.get(t));
    parent.put(t, root);
    return root;
  }

  public void union(T a, T b){
    T rootA = find(a);
    T rootB = find(b);
    if(!rootA.equals(rootB)){
      parent.put(rootB,rootA);
    }
  }
}

