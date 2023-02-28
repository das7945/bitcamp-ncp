package bitcamp.myapp.config;

import java.io.InputStream;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import bitcamp.myapp.dao.BoardDao;
import bitcamp.myapp.dao.BoardFileDao;
import bitcamp.myapp.dao.MemberDao;
import bitcamp.myapp.dao.StudentDao;
import bitcamp.myapp.dao.TeacherDao;
import bitcamp.util.BitcampSqlSessionFactory;
import bitcamp.util.DaoGenerator;
import bitcamp.util.TransactionManager;


// Spring Ioc컨테이너가 자동 생성 할 클래스를 찾을 있도록 패키지를 지정한다.
@ComponentScan("bitcamp.myapp")
public class AppConfig {
  public AppConfig() {
    System.out.println("AppConfig 객체 생성 ");
  }

  @Bean
  //  @Bean("sqlSessionFactory")
  public SqlSessionFactory SqlSessionFactory() throws Exception {
    System.out.println("SqlSessionFactory 생성 ");
    InputStream mybatisConfigInputStream = Resources.getResourceAsStream(
        "bitcamp/myapp/config/mybatis-config.xml");
    SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
    return new BitcampSqlSessionFactory(
        builder.build(mybatisConfigInputStream));
  }

  @Bean
  public TransactionManager transactionManager(SqlSessionFactory sqlSessionFactory) throws Exception {
    System.out.println("TransactionManager 객체 생성");
    return new TransactionManager((BitcampSqlSessionFactory) sqlSessionFactory);
  }

  @Bean
  public BoardDao boardDao(SqlSessionFactory SqlSessionFactory) {
    return new DaoGenerator(SqlSessionFactory).getObject(BoardDao.class);
  }

  @Bean
  public MemberDao memberDao(SqlSessionFactory SqlSessionFactory) {
    return new DaoGenerator(SqlSessionFactory).getObject(MemberDao.class);
  }

  @Bean
  public StudentDao studentDao(SqlSessionFactory SqlSessionFactory) {
    return new DaoGenerator(SqlSessionFactory).getObject(StudentDao.class);
  }

  @Bean
  public TeacherDao teacherDao(SqlSessionFactory SqlSessionFactory) {
    return new DaoGenerator(SqlSessionFactory).getObject(TeacherDao.class);
  }
  @Bean
  public BoardFileDao boardFileDao(SqlSessionFactory SqlSessionFactory) {
    return new DaoGenerator(SqlSessionFactory).getObject(BoardFileDao.class);
  }
}


