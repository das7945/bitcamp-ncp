package bitcamp.myapp.vo;

// 회원 데이터를 담을 메모리를 설계한다.
public class Student extends Member {
  private String postNo;
  private String basicAddress;
  private String detailAddress;
  private int working;
  private int gender;
  private int level;



  @Override
  public String toString() {
    return "Student [no=" + getNo() + ", name=" + getName() + ", tel=" + getTel() + ", createdDate=" + getCreatedDate() + ",postNo=" + postNo + ", basicAddress=" + basicAddress + ", detailAddress="
        + detailAddress + ", working=" + working + ", gender=" + gender + ", level=" + level + "]";
  }
  public String getPostNo() {
    return postNo;
  }
  public void setPostNo(String postNo) {
    this.postNo = postNo;
  }
  public String getBasicAddress() {
    return basicAddress;
  }
  public void setBasicAddress(String basicAddress) {
    this.basicAddress = basicAddress;
  }
  public String getDetailAddress() {
    return detailAddress;
  }
  public void setDetailAddress(String detailAddress) {
    this.detailAddress = detailAddress;
  }
  public int isWorking() {
    return working;
  }
  public void setWorking(int working) {
    this.working = working;
  }
  public int getGender() {
    return gender;
  }
  public void setGender(int gender) {
    this.gender = gender;
  }
  public int getLevel() {
    return level;
  }
  public void setLevel(int level) {
    this.level = level;
  }
}
