package com.eomcs.oop.ex01;

//# 레퍼런스와 인스턴스 - 인스턴스 주소 주고 받기
//
public class Exam0310 {
  public static void main(String[] args) {
    class Score {
      String name;
      int kor;
      int eng;
      int math;
      int sum;
      float aver;
    }
    // 컴파일 시 작업순서상 제일 먼저 클래스메서드를 읽은 후
    // class Score의 배열과 같은 형태로 준비 상태가 된다.


    // Score 레퍼런스 선언 + 인스턴스 생성(사용할 메모리 확보)
    // new Score(); Score()의 이름에 임의의 주소로 배열에 내용이 들어갈 준비 상태가 됨.
    // 임의의 주소는 s1에 소속됨.
    Score s1 = new Score();

    // s1에 저장된 주소를 s2에도 저장한다.
    // => s1과 s2는 같은 메모리를 가리킨다.
    Score s2 = s1;

    s1.name = "홍길동";

    // s1이 가리키는 메모리는 s2를 사용하여 접근할 수 있다.
    System.out.println(s2.name);
  }
}
