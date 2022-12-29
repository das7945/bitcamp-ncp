
// class A {
//   p1.B obj;
//   p2.C obj2;
//   p2.px.C obj3;
//   p2.px.aaa.bbb.ccc.ddd.D obj4;
// }

import p1.B;
// import p2.C;
import p2.px.C;
import p2.px.aaa.bbb.ccc.ddd.D;

class A {
  B obj;
  p2.C obj2;
  C obj3;
  D obj4;

  public static void main(String[] args) {
    System.out.println("Hello!-A");
  }
}