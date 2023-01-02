package com.eomcs.lang.ex07;

import java.util.Scanner;

//# 메서드 : 사용 전
//
public class Exam0110 {
  public static void main(String[] args) {
    Scanner keyScan = new Scanner(System.in);
    System.out.print("밑변의 길이? ");
    int len = keyScan.nextInt();
    keyScan.close();

    int starLen = 1;  // 3
    while (starLen <= len) {  // 3 <= 3
      // 별 앞에 공백 출력
      int spaceCnt = 1;
      int spaceLen = (len - starLen) / 2;  // (3 - 3) / 2 = 0
      while (spaceCnt <= spaceLen) {  // 1 <= 0
        System.out.print(" ");
        spaceCnt++;
      }

      // 별 출력
      int starCnt = 1;
      while (starCnt <= starLen) { // 1 <= 3
        System.out.print("*");
        starCnt++;
      }

      // 출력 줄 바꾸기
      System.out.println();
      starLen += 2;
    }
  }
}