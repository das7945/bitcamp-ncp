// 인터페이스 구현 - 한 개라도 빠트리면 추상메서드를 갖고 있는 상태가 된다.
package com.eomcs.oop.ex10.b;

public /*abstract*/ class Exam02 implements Servlet {
  // 인터페이스에 선언된 메서드를 한 개라도 빠트리면
  // 추상 메서드인채로 남아 있기 때문에
  // 일반 클래스가 될 수 없고,
  // 추상 클래스가 되어야 한다.
  @Override
  public void init() {}
  @Override
  public void destroy() {}
  @Override
  public String getServletInfo() {return null;}
  @Override
  public String getServletConfig() {return null;}
}
