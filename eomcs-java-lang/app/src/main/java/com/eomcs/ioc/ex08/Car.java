package com.eomcs.ioc.ex08;

public class Car {


  public Engine() {
    System.out.println("===> Engine()");
  }

  public void run() {
    System.out.println("엔진을 가동한다.");
  }
  public UltraEngine() {
    System.out.println("===> UltraEngine()");
  }

  @Override
  public void run() {
    super.run();
    System.out.println("쌩쌩...달린다....");
  }

  public Car() {
    System.out.println("===> Car()");
    this.engine = new Engine();
  }

  public void move() {
    this.engine.run();
  }
}
