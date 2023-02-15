package bitcamp.util;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import org.apache.ibatis.session.SqlSessionFactory;
import bitcamp.myapp.dao.BoardDao;

public class DaoGenerator {

  SqlSessionFactory sqlSessionFactory;

  public DaoGenerator(SqlSessionFactory sqlSessionFactory) {
    this.sqlSessionFactory = sqlSessionFactory;
  }

  @SuppressWarnings("unchecked")
  public <T>T getObject(Class<T> classInfo) {

    String className = classInfo.getName();

    return (T) Proxy.newProxyInstance(
        getClass().getClassLoader(),
        new Class[] {classInfo},
        new MyInvocationHandler()
        );
  }

  class MyInvocationHandler implements InvocationHandler {

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
      System.out.printf("%s() 메서드 호출\n", method.getName());

      if (method.getReturnType() == int.class) {
        return 1;
      }
      return null;
    }
  }

  public static void main(String[] args) {
    DaoGenerator generator = new DaoGenerator(null);
    BoardDao dao = generator.getObject(BoardDao.class);

    dao.insert(null);
    dao.findAll();
    dao.findByNo(1);
    dao.update(null);
    dao.delete(1);
  }
}
