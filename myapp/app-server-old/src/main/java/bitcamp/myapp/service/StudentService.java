package bitcamp.myapp.service;

import java.util.List;
import bitcamp.myapp.dao.StudentDao;
import bitcamp.myapp.vo.Student;
import bitcamp.util.TransactionManager;

public class StudentService {

  private TransactionManager txManager;
  private StudentDao studentDao;

  public StudentService(TransactionManager txManager, StudentDao studentDao) {
    this.txManager = txManager;
    this.studentDao = studentDao;
  }

  public void add(Student student) {
    try {
      txManager.startTransaction();
      studentDao.insert(student);
      if (student.getAttachedFiles().size() > 0) {
        for (StudentFile studentFile : student.getAttachedFiles()) {
          studentFile.setStudentNo(student.getNo());
        }
        studentFileDao.insertList(student.getAttachedFiles());
      }
      txManager.commit();

    } catch (Exception e) {
      txManager.rollback();
      throw new RuntimeException(e);
    }
  }

  public List<Student> list(String keyword) {
    return studentDao.findAll(keyword);
  }

  public Student get(int no) {
    Student b = studentDao.findByNo(no);
    if (b != null) {
      studentDao.increaseViewCount(no);
    }
    return b;
  }

  public void update(Student student) {
    try {
      txManager.startTransaction();
      if (studentDao.update(student) == 0) {
        throw new RuntimeException("게시글이 존재하지 않습니다!");
      }
      if (student.getAttachedFiles().size() > 0) {
        studentFileDao.insertList(student.getAttachedFiles());
      }
      txManager.commit();

    }  catch (Exception e) {
      txManager.rollback();
      throw e;
    }
  }

  public void delete(int no) {
    try {
      txManager.startTransaction();
      studentFileDao.deleteOfStudent(no);
      if (studentDao.delete(no) == 0) {
        throw new RuntimeException("게시글이 존재하지 않습니다!");
      }
      txManager.commit();

    }  catch (Exception e) {
      txManager.rollback();
      throw e;
    }
  }

  public void deleteFile(int fileNo) {
    studentFileDao.delete(fileNo);
  }
}





