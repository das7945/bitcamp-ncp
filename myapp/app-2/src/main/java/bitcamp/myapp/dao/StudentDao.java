package bitcamp.myapp.dao;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Date;
import java.util.Iterator;
import java.util.List;
import bitcamp.myapp.vo.Board;
import bitcamp.myapp.vo.Student;

public class StudentDao {

  List<Student> list;

  int lastNo;

  public StudentDao(List<Student> list) {
    this.list = list;
  }

  public void insert(Student s) {
    s.setNo(++lastNo);
    s.setCreatedDate(new Date(System.currentTimeMillis()).toString());
    list.add(s);
  }

  public Student[] findAll() {
    Student[] students = new Student[list.size()];
    Iterator<Student> i = list.iterator();
    int index = 0;
    while (i.hasNext()) {
      students[index++] = i.next();
    }
    return students;
  }

  public Student findByNo(int no) {
    Student s = new Student();
    s.setNo(no);

    int index = list.indexOf(s);
    if (index == -1) {
      return null;
    }
    return list.get(index);
  }

  public void update(Student s) {
    int index = list.indexOf(s);
    list.set(index, s);
  }

  public boolean delete(Student s) {
    return list.remove(s);
  }

  public void save(String filename) {
    try (FileWriter out = new FileWriter(filename)){

      list.forEach( b -> {
        try {
          out.write(String.format("%d,%s,%s,%s,%d,%s\n",
              b.getNo(),
              b.getTitle(),
              b.getContent(),
              b.getPassword(),
              b.getViewCount(),
              b.getCreatedDate()));
        } catch (Exception e) {
          System.out.println("데이터 출력 중 오류 발생!");
          e.printStackTrace();
        }
      });
         } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void load(String filename) {
    if (list.size() > 0) { // 중복 로딩 방지!
      return;
    }

    try (BufferedReader in = new BufferedReader(new FileReader(filename))) {

      String line = "";
      while ((line = in.readLine()) != null) {
        String[] values = line.split(",");
        Board b = new Board();
        b.setNo(Integer.parseInt(values[0]));
        b.setTitle(values[1]);
        b.setContent(values[2]);
        b.setPassword(values[3]);
        b.setViewCount(Integer.parseInt(values[4]));
        b.setCreatedDate(values[5]);
        list.add(b);

      }

      if (list.size() > 0) {
        lastNo = list.get(list.size() - 1).getNo();
      }

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}







