// 예외 처리 문법을 적용하기 전 - 오류일 때 리턴하는 값은 희귀한 값으로 지정한다.
package com.eomcs.exception.ex1;

public class Calculator3 {
  public static int compute(String op, int a, int b) throws Throwable {
    switch (op) {
      case "+": return a + b;
      case "-": return a - b;
      case "*": return a * b;
      case "/": return a / b;
      case "%": return a % b;
      default:
        // -1은 일반적인 계산으로 나올 수 있는 흔한 값이다.
        // 흔한 값 대신에 다음과 같이
        // 일반적인 계산결과로 잘 나오지 않는 값을 지정해 보자.

        throw new Throwable("해당 연산자를 지원하지 않습니다.");
    }
  }
}
