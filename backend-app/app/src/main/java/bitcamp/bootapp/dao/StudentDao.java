package bitcamp.bootapp.dao;

import java.util.Arrays;
import org.springframework.stereotype.Repository;
import bitcamp.bootapp.vo.Student;

@Repository
public class StudentDao {
  private static final int SIZE = 100;

  private int no;
  private int count;
  private Student[] members = new Student[SIZE];

  public void insert(Student member) {
    member.setNo(++no);
    this.members[this.count++] = member;
  }

  public Student[] findAll() {
    return Arrays.copyOf(members, count);
  }

  public Student findByNo(int no) {
    for (int i = 0; i < this.count; i++) {
      if (this.members[i].getNo() == no) {
        return this.members[i];
      }
    }
    return null;
  }

  public void update(Student member) {
    this.members[this.indexOf(member)] = member;
  }

  public void delete(Student member) {
    for (int i = this.indexOf(member) + 1; i < this.count; i++) {
      this.members[i - 1] = this.members[i];
    }
    this.members[--this.count] = null; // 레퍼런스 카운트를 줄인다.
  }

  private int indexOf(Student b) {
    for (int i = 0; i < this.count; i++) {
      if (this.members[i].getNo() == b.getNo()) {
        return i;
      }
    }
    return -1;
  }
}







