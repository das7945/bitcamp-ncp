package bitcamp.myapp;

import java.util.Scanner;

public class App {
  public static void main(String[] args) {

    // 키보드에서 입력을 받는 도구 준비
    Scanner keyScanner = new Scanner(System.in);

    System.out.print("번호: ");
    int no = Integer.parseInt(keyScanner.nextLine());
    //    int no = 1;
    System.out.print("이름: ");
    String name = keyScanner.nextLine();
    System.out.print("전화번호: ");
    String tel = keyScanner.nextLine();
    System.out.print("우편번호: ");
    String postNo = keyScanner.nextLine();
    System.out.print("주소: ");
    String basicAddress = keyScanner.nextLine();
    System.out.print("상세주소: ");
    String detailAddress = keyScanner.nextLine();
    System.out.print("재직자?(true/false): ");
    boolean working = Boolean.parseBoolean(keyScanner.nextLine());
    System.out.print("성별?(남자: M, 여자: W): ");
    char gender = keyScanner.nextLine().charAt(0); // M(남자), W(여자)
    System.out.print("전공자?(0: 비전공자), (1: 준정공자), (2: 전공자): ");
    byte level = Byte.parseByte(keyScanner.nextLine()); // 0(비전공자), 1(준정공자), 2(전공자)
    System.out.print("가입일: ");
    String createDate = keyScanner.nextLine();

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
