package com.eomcs.lang.ex06;

// # 흐름 제어문 - for(;;) 와 배열
//
public class Exam0442 {
  public static void main(String[] args) {
    String[] names = {"0홍길동", "1임꺽정", "2유관순", "3윤봉길", "4안중근"};

    // 증가치 조정
    System.out.println(names.length);
    for (int i = 0; i < names.length; i += 2) {
      System.out.println(names[i]);
    }

  }
}
