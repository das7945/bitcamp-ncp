package bitcamp.myapp;

import java.util.Scanner;

public class App {
  public static void main(String[] args) {

    // 키보드에서 입력을 받는 도구 준비
    Scanner keyScanner = new Scanner(System.in);


    int no = Integer.parseInt(keyScanner.nextLine());
    //    int no = 1;
    String name = "홍길동";
    String tel = "010-1111-1111";
    String postNo = "06656";
    String basicAddress = "서울시 서초구 반포대로23길";
    String detailAddress = "101동 201호";
    boolean working = false;
    char gender = 'M'; // M(남자), W(여자)
    byte level = 0; // 0(비전공자), 1(준정공자), 2(전공자)
    String createDate = "2022-12-29";

    System.out.println("번호: " + no);
    System.out.println("이름: " + name);
    System.out.println("전화번호: " + tel);
    System.out.println("우편번호: " + postNo);
    System.out.println("주소: " + basicAddress);
    System.out.println("상세주소: " + detailAddress);
    System.out.println("재직자: " + working);
    System.out.println("성별: " + gender);
    System.out.println("전공: " + level);
    System.out.println("가입일: " + createDate);

    System.out.println("---------------------------------");

    System.out.printf("번호: %d\n", no);
    System.out.printf("이름: %s\n", name);
    System.out.printf("전화번호: %s\n", tel);
    System.out.printf("우편번호: %s\n", postNo);
    System.out.printf("주소: %s\n", basicAddress);
    System.out.printf("상세주소: %s\n", detailAddress);

    //    String workingLabel;
    //    if (working) {
    //      workingLabel = "예";
    //    } else {
    //      workingLabel = "아니오";
    //    }
    //    System.out.printf("재직자: %s\n", workingLabel);
    System.out.printf("재직자: %s\n", working ? "예" : "아니오");
    System.out.printf("성별: %s\n", gender == 'M' ? "남자" : "여자");

    String levelTitle;
    switch (level) {
      case 0: levelTitle = "비전공자"; break;
      case 1: levelTitle = "준전공자"; break;
      default: levelTitle = "전공자";
    }
    //    if (level == 0) {
    //      levelTitle = "비전공자";
    //    } else if (level ==1) {
    //      levelTitle = "준정공자";
    //    } else {
    //      levelTitle = "전공자";
    //    }
    System.out.printf("전공: %s\n", levelTitle);
    System.out.printf("가입일: %s\n", createDate);

  }
}
