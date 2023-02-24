package bitcamp.myapp.listener;

import java.io.InputStream;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import bitcamp.myapp.controller.AuthFailController;
import bitcamp.myapp.controller.LoginController;
import bitcamp.myapp.controller.LoginFormController;
import bitcamp.myapp.controller.LogoutController;
import bitcamp.myapp.controller.board.BoardDeleteController;
import bitcamp.myapp.controller.board.BoardFileDeleteController;
import bitcamp.myapp.controller.board.BoardFormController;
import bitcamp.myapp.controller.board.BoardInsertController;
import bitcamp.myapp.controller.board.BoardListController;
import bitcamp.myapp.controller.board.BoardUpdateController;
import bitcamp.myapp.controller.board.BoardViewController;
import bitcamp.myapp.controller.student.StudentDeleteController;
import bitcamp.myapp.controller.student.StudentFormController;
import bitcamp.myapp.controller.student.StudentInsertController;
import bitcamp.myapp.controller.student.StudentListController;
import bitcamp.myapp.controller.student.StudentUpdateController;
import bitcamp.myapp.controller.student.StudentViewController;
import bitcamp.myapp.controller.teacher.TeacherDeleteController;
import bitcamp.myapp.controller.teacher.TeacherFormController;
import bitcamp.myapp.controller.teacher.TeacherInsertController;
import bitcamp.myapp.controller.teacher.TeacherListController;
import bitcamp.myapp.controller.teacher.TeacherUpdateController;
import bitcamp.myapp.controller.teacher.TeacherViewController;
import bitcamp.myapp.dao.BoardDao;
import bitcamp.myapp.dao.BoardFileDao;
import bitcamp.myapp.dao.MemberDao;
import bitcamp.myapp.dao.StudentDao;
import bitcamp.myapp.dao.TeacherDao;
import bitcamp.myapp.service.BoardService;
import bitcamp.myapp.service.StudentService;
import bitcamp.myapp.service.TeacherService;
import bitcamp.myapp.service.impl.DefaultBoardService;
import bitcamp.myapp.service.impl.DefaultStudentService;
import bitcamp.myapp.service.impl.DefaultTeacherService;
import bitcamp.util.BitcampSqlSessionFactory;
import bitcamp.util.DaoGenerator;
import bitcamp.util.TransactionManager;

@WebListener
public class ContextLoaderListener implements ServletContextListener {
  @Override
  public void contextInitialized(ServletContextEvent sce) {
    try {
      InputStream mybatisConfigInputStream = Resources.getResourceAsStream(
          "bitcamp/myapp/config/mybatis-config.xml");
      SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
      BitcampSqlSessionFactory sqlSessionFactory = new BitcampSqlSessionFactory(
          builder.build(mybatisConfigInputStream));

      TransactionManager txManager = new TransactionManager(sqlSessionFactory);

      BoardDao boardDao = new DaoGenerator(sqlSessionFactory).getObject(BoardDao.class);
      MemberDao memberDao = new DaoGenerator(sqlSessionFactory).getObject(MemberDao.class);
      StudentDao studentDao = new DaoGenerator(sqlSessionFactory).getObject(StudentDao.class);
      TeacherDao teacherDao = new DaoGenerator(sqlSessionFactory).getObject(TeacherDao.class);
      BoardFileDao boardFileDao = new DaoGenerator(sqlSessionFactory).getObject(BoardFileDao.class);

      BoardService boardService = new DefaultBoardService(txManager, boardDao, boardFileDao);
      StudentService studentService = new DefaultStudentService(txManager, memberDao, studentDao);
      TeacherService teacherService = new DefaultTeacherService(txManager, memberDao, teacherDao);

      LoginFormController loginFormController = new LoginFormController();
      LoginController loginController = new LoginController(studentService, teacherService);
      LogoutController logoutController = new LogoutController();
      AuthFailController authFailController = new AuthFailController();

      BoardListController boardListController = new BoardListController(boardService);
      BoardFormController boardFormController = new BoardFormController();
      BoardInsertController boardInsertController = new BoardInsertController(boardService);
      BoardViewController boardViewController = new BoardViewController(boardService);
      BoardUpdateController boardUpdateController = new BoardUpdateController(boardService);
      BoardDeleteController boardDeleteController = new BoardDeleteController(boardService);
      BoardFileDeleteController boardFileDeleteController = new BoardFileDeleteController(boardService);

      StudentListController studentListController = new StudentListController(studentService);
      StudentFormController studentFormController = new StudentFormController();
      StudentInsertController studentInsertController = new StudentInsertController(studentService);
      StudentViewController studentViewController = new StudentViewController(studentService);
      StudentUpdateController studentUpdateController = new StudentUpdateController(studentService);
      StudentDeleteController studentDeleteController = new StudentDeleteController(studentService);

      TeacherListController teacherListController = new TeacherListController(teacherService);
      TeacherFormController teacherFormController = new TeacherFormController();
      TeacherInsertController teacherInsertController = new TeacherInsertController(teacherService);
      TeacherViewController teacherViewController = new TeacherViewController(teacherService);
      TeacherUpdateController teacherUpdateController = new TeacherUpdateController(teacherService);
      TeacherDeleteController teacherDeleteController = new TeacherDeleteController(teacherService);

      // 서블릿 컨텍스트 보관소를 알아낸다.
      ServletContext ctx = sce.getServletContext();

      // 프론트 컨트롤러가 사용할 페이지 컨트롤러를 보관한다.
      ctx.setAttribute("/auth/form", loginFormController);
      ctx.setAttribute("/auth/login", loginController);
      ctx.setAttribute("/auth/logout", logoutController);
      ctx.setAttribute("/auth/fail", authFailController);

      ctx.setAttribute("/board/list", boardListController);
      ctx.setAttribute("/board/form", boardFormController);
      ctx.setAttribute("/board/insert", boardInsertController);
      ctx.setAttribute("/board/delete", boardDeleteController);
      ctx.setAttribute("/board/view", boardViewController);
      ctx.setAttribute("/board/filedelete", boardFileDeleteController);
      ctx.setAttribute("/board/update", boardUpdateController);

      ctx.setAttribute("/student/list", studentListController);
      ctx.setAttribute("/student/form", studentFormController);
      ctx.setAttribute("/student/insert", studentInsertController);
      ctx.setAttribute("/student/view", studentViewController);
      ctx.setAttribute("/student/update", studentUpdateController);
      ctx.setAttribute("/student/delete", studentDeleteController);

      ctx.setAttribute("/teacher/list", teacherListController);
      ctx.setAttribute("/teacher/form", teacherFormController);
      ctx.setAttribute("/teacher/insert", teacherInsertController);
      ctx.setAttribute("/teacher/view", teacherViewController);
      ctx.setAttribute("/teacher/update", teacherUpdateController);
      ctx.setAttribute("/teacher/delete", teacherDeleteController);

    } catch (Exception e) {
      System.out.println("웹 애플리케이션 자원을 준비하는 중에 오류 발생!");
      e.printStackTrace();
    }
  }

  @Override
  public void contextDestroyed(ServletContextEvent sce) {
    // 웹 애플리케이션이 종료될 때 서블릿 컨테이너가 호출한다.
    System.out.println("ContextLoaderListener.contextDestroyed() 호출됨!");
  }
}
