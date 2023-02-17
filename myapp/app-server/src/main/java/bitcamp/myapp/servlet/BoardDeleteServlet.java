package bitcamp.myapp.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import bitcamp.myapp.dao.BoardDao;
import bitcamp.myapp.vo.Board;
import bitcamp.util.BitcampSqlSessionFactory;
import bitcamp.util.DaoGenerator;

@WebServlet("/board/delete")
public class BoardDeleteServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  private BoardDao boardDao;

  public BoardDeleteServlet() {
    try {
      InputStream mybatisConfigInputStream = Resources.getResourceAsStream(
          "bitcamp/myapp/config/mybatis-config.xml");
      SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
      BitcampSqlSessionFactory sqlSessionFactory = new BitcampSqlSessionFactory(
          builder.build(mybatisConfigInputStream));
      boardDao = new DaoGenerator(sqlSessionFactory).getObject(BoardDao.class);

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    int boardNo = Integer.parseInt(request.getParameter("no"));
    String password = request.getParameter("password");

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();

    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<meta charset='UTF-8'>");
    out.println("<title>비트캠프 - NCP 1기</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>게시판</h1>");

    Board old = boardDao.findByNo(boardNo);
    if (old == null) {
      out.println("<p>해당 번호의 게시글이 없습니다.</p>");
    } else if (!old.getPassword().equals(password)) {
      out.println("<p>암호가 맞지 않습니다!</p>");
    } else {
      this.boardDao.delete(boardNo);
      out.println("<p>삭제했습니다.</p>");
    }
    out.println("</body>");
    out.println("</html>");

    response.setHeader("Refresh", "1;url=list");
  }
}
