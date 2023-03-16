package bitcamp.myapp.vo;

import lombok.Data;

@Data
// 회원 데이터를 담을 메모리를 설계한다.
public class Student extends Member  {


  private String postNo;
  private String basicAddress;
  private String detailAddress;
  private boolean working;
  private char gender;
  private byte level;

}
