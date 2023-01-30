package com.eomcs.basic;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class test {

  static class Member {
    int no;
    String name;
    public Member(int no, String name) {
      this.no = no;
      this.name = name;
    }
    @Override
    public String toString() {
      return "Member [no=" + no + ", name=" + name + "]";
    }
    @Override
    public int hashCode() {
      return Objects.hash(name, no);
    }
    @Override
    public boolean equals(Object obj) {
      if (this == obj)
        return true;
      if (obj == null)
        return false;
      if (getClass() != obj.getClass())
        return false;
      Member other = (Member) obj;
      return Objects.equals(name, other.name) && no == other.no;
    }



  }

  public static void main(String[] args) {
    HashMap<String, Member> map = new HashMap<>();
    map.put("aaa", new Member(1,"aaa"));
    map.put("bbb", new Member(2,"bbb"));
    map.put("ccc", new Member(3,"ccc"));
    map.put("ddd", new Member(4,"ddd"));
    map.put("eee", new Member(5,"eee"));


    //    System.out.println(list.get(0) == list.get(4));
    //    System.out.println(list.get(0).hashCode() == list.get(4).hashCode());
    //    System.out.println(list.get(0).equals(list.get(4)));

    //    list.remove(1);
    map.remove("yoo");

    print6(map);

    //    String v1 = list.get(0);
    //    String v2 = list.get(4);
    //    System.out.println(v1 == v2);
    //
    //    System.out.println(list.get(2));
  }

  // for (String e : list) <- list가 구현체를 통해 어떻게 적용 될 수 있는지 보는 테스트
  // MyLinkedList에 Iterator를 추가해 줌으로써 list를 사용가능하게 해줌.
  static void print(List<String> list) {
    Iterator<String> i = list.iterator();
    while(i.hasNext());
    System.out.println(i.next());
    System.out.println("---------------------------");
  }

  static void print2(List<String> list) {
    list.forEach( t -> System.out.println(t));
    System.out.println("---------------------------");
  }

  static void print3(List<Member> list) {
    list.forEach(System.out::println);
    System.out.println("---------------------------");
  }

  static void print4(Set<Member> list) {
    list.forEach(System.out::println);
    System.out.println("---------------------------");
  }


  static void print5(Set<Member> list) {
    list.forEach(test :: m);
    System.out.println("---------------------------");
  }

  static void m(Member m) {
    System.out.printf("%d-%s\n", m.hashCode(), m.toString());
  }

  static void print6(Map<String, Member> map) {
    Collection<Member> values =  map.values();
    for ( Member m : values) {
      System.out.println(m);
    }
    System.out.println("---------------------------");
  }


}

