package bitcamp.myapp.controller.teacher;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import bitcamp.myapp.controller.PageController;

public class TeacherFormController implements PageController {

  @Override
  public String execute(HttpServletRequest request, HttpServletResponse response) {

    return "/teacher/form.jsp";
  }
}
