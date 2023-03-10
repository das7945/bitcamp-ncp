// 템플릿 메서드를 구현한 클래스 사용
// 템플릿 메서드
// => 기본 적인 실행 흐름은 정의하고
//    구체적인 행위는 서브 클래스에게 위임하는 설계 기법
//
package com.eomcs.oop.ex10.c;

public class Exam01 {

  public static void main(String[] args) {

    Restaurant r = new Restaurant(); // 주소값 200
    Farm f = new Farm(); // 주소값 300

    work(r); //r = 주소값 200

    System.out.println("---------------------");

    work(f); // f = 주소값 300
  }

  static void work(Building obj)  {
    // 레스토랑이나 농장 건축의 기본 흐름은 이미 수퍼 클래스에 정의되어 있다.
    // 착수와 완료는 서브 클래스 마다 다르다.
    obj.build();
  }

  //  static void work(Building obj <- r의 주소값 200)  {
  //    // 레스토랑이나 농장 건축의 기본 흐름은 이미 수퍼 클래스에 정의되어 있다.
  //    // 착수와 완료는 서브 클래스 마다 다르다.
  //    obj.build(); // obj.build();에서 obj는 r의 주소값 200으로 build()을 호출
  //  }

}
