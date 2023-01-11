package bitcamp.bootapp.vo;

public class Teacher {
  private int no;
  private String name;
  private String tel;
  private String email;
  private String academicBackground; // 최종학력
  private String university; //대학교
  private String major; // 전공
  private String pay; // 강사
  private String createdDate;

  public int getNo() {
    return no;
  }
  public void setNo(int no) {
    this.no = no;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public String getTel() {
    return tel;
  }
  public void setTel(String tel) {
    this.tel = tel;
  }
  public String getEmail() {
    return email;
  }
  public void setEmail(String email) {
    this.email = email;
  }
  public String getAcademicBackground() {
    return academicBackground;
  }
  public void setAcademicBackground(String academicBackground) {
    this.academicBackground = academicBackground;
  }
  public String getUniversity() {
    return university;
  }
  public void setUniversity(String university) {
    this.university = university;
  }
  public String getMajor() {
    return major;
  }
  public void setMajor(String major) {
    this.major = major;
  }
  public String getPay() {
    return pay;
  }
  public void setPay(String pay) {
    this.pay = pay;
  }
  public String getCreatedDate() {
    return createdDate;
  }
  public void setCreatedDate(String createdDate) {
    this.createdDate = createdDate;
  }

}
