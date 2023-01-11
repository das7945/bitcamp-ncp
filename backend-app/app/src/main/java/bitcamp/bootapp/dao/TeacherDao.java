package bitcamp.bootapp.dao;

import java.util.Arrays;
import bitcamp.bootapp.vo.Teacher;

public class TeacherDao {
  private static final int SIZE = 100;

  private int no;
  private int count;
  private Teacher[] teachers = new Teacher[SIZE];

  public void insert(Teacher t) {
    t.setNo(++no);
    this.teachers[this.count++] = t;
  }

  public Teacher[] findAll() {
    return Arrays.copyOf(teachers, count);
  }

  public Teacher findByNo(int no) {
    for (int i = 0; i < this.count; i++) {
      if (this.teachers[i].getNo() == no) {
        return this.teachers[i];
      }
    }
    return null;
  }

  public void update(Teacher t) {
    this.teachers[this.indexOf(t)] = t;
  }

  public void delete(Teacher no) {
    for (int i = this.indexOf(no); i < this.count; i++) {
      this.teachers[i] = this.teachers[i + 1];
    }
    this.teachers[--this.count] = null; // 레퍼런스 카운트를 줄인다.
  }

  private int indexOf(Teacher t) {
    for (int i = 0; i < this.count; i++) {
      if (this.teachers[i].getNo() == t.getNo()) {
        return i;
      }
    }
    return -1;
  }
}
