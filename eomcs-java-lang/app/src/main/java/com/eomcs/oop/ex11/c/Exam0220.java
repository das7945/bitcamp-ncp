// inner class : 바깥 클래스의 인스턴스 멤버 접근하기
package com.eomcs.oop.ex11.c;

class B2 {

  // 인스턴스 멤버
  int v2;
  void m2() {
    System.out.println("B2.v2 = " + this.v2);
  }

  class X {
    void test() {

      System.out.println(B2.this.v2); // ---> this$0.v2
      B2.this.m2();
    }
  }
}

public class Exam0220 {

  public static void main(String[] args) {
    B2 outer = new B2();
    outer.v2 = 100;
    outer.m2();


    B2 outer2 = new B2();
    outer2.v2 = 200;
    outer2.m2();

    // inner 객체 생성
    B2.X inner = outer.new X(); // --> new X(outer)
    B2.X inner2 = outer2.new X(); // --> new X(outer2)

    inner.test();
    inner2.test();

    B2 outer3 = null;
    B2.X inner3 = outer3.new X();
  }

}
