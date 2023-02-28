package bitcamp.myapp.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import bitcamp.myapp.service.BoardService;
import bitcamp.myapp.vo.Board;
import bitcamp.myapp.vo.BoardFile;
import bitcamp.myapp.vo.Member;

@Controller
@RequestMapping("/board")
public class BoardController {


  @Autowired  private ServletContext servletContext;
  @Autowired  private BoardService boardService;


  @RequestMapping("form")
  public String form() {
    return "/board/form.jsp";
  }

  @RequestMapping("insert")
  public String insert(
      String title,
      String content,
      Part[] files,
      Model model,  // ServletRequest 보관소에 저장할 값을 담는 임시 저장소
      // 이 객체 값을 담아두면 프론트 컨트롤러 (DisatcherServlet)가
      // ServletRequest 보관소로 옮겨 담을 것이다.
      HttpSession session) {
    try {
      Board board = new Board();
      board.setTitle(title);
      board.setContent(content);

      Member loginUser = (Member) session.getAttribute("loginUser");
      Member writer = new Member();
      writer.setNo(loginUser.getNo());
      board.setWriter(writer);

      List<BoardFile> boardFiles = new ArrayList<>();
      for (Part part : files) {
        if (part.getSize() == 0) {
          continue;
        }

        String filename = UUID.randomUUID().toString();
        part.write(servletContext.getRealPath("/board/upload/" + filename));
        BoardFile boardFile = new BoardFile();
        boardFile.setOriginalFilename(part.getSubmittedFileName());
        boardFile.setFilepath(filename);
        boardFile.setMimeType(part.getContentType());
        boardFiles.add(boardFile);
      }
      board.setAttachedFiles(boardFiles);

      boardService.add(board);

    } catch (Exception e) {
      e.printStackTrace();
      model.addAttribute("error", "data");
    }
    return "/board/insert.jsp";
  }

  @RequestMapping("list")
  public String list(
      //      @RequestParam(value = "keyword", required = false) String keyword,
      String keyword,
      Model model) {

    model.addAttribute("boards", boardService.list(keyword));
    return "/board/list.jsp";
  }

  @RequestMapping("view")
  public String view(
      //      @RequestParam("no") int no,
      int no,
      Model model) {

    model.addAttribute("board", boardService.get(no));
    return"/board/view.jsp";
  }

  @RequestMapping("update")
  public String update(
      //      @RequestParam("no") int no,
      //      @RequestParam("title") String title,
      //      @RequestParam("content") String content,
      //      @RequestParam("files") Part[] files,
      int no,
      String title,
      String content,
      Part[] files,
      Model model,
      HttpSession session) {
    try {
      Member loginUser = (Member) session.getAttribute("loginUser");

      Board board = new Board();
      board.setNo(no);
      board.setTitle(title);
      board.setContent(content);

      Board old = boardService.get(board.getNo());
      if (old.getWriter().getNo() != loginUser.getNo()) {
        return "redirect:../auth/fail";
      }

      List<BoardFile> boardFiles = new ArrayList<>();
      for (Part part : files) {
        if (part.getSize() == 0) {
          continue;
        }

        String filename = UUID.randomUUID().toString();
        part.write(servletContext.getRealPath("/board/upload/" + filename));

        BoardFile boardFile = new BoardFile();
        boardFile.setOriginalFilename(part.getSubmittedFileName());
        boardFile.setFilepath(filename);
        boardFile.setMimeType(part.getContentType());
        boardFile.setBoardNo(board.getNo());
        boardFiles.add(boardFile);
      }
      board.setAttachedFiles(boardFiles);

      boardService.update(board);

    }  catch (Exception e) {
      e.printStackTrace();
      model.addAttribute("error", "data");
    }

    return "/board/update.jsp";
  }

  @RequestMapping("delete")
  public String delete(
      @RequestParam("no") int boardNo,
      Model model,
      HttpSession session) {
    try {
      Member loginUser = (Member) session.getAttribute("loginUser");

      Board old = boardService.get(boardNo);
      if (old.getWriter().getNo() != loginUser.getNo()) {
        return "redirect:../auth/fail";
      }
      boardService.delete(boardNo);

    }  catch (Exception e) {
      e.printStackTrace();
      model.addAttribute("error", "data");
    }
    return "/board/delete.jsp";
  }

  @RequestMapping("filedelete")
  public String filedelete(
      //      @RequestParam("boardNo") int boardNo,
      //      @RequestParam("fileNo") int fileNo,
      int boardNo,
      int fileNo,
      HttpSession session) {

    Member loginUser = (Member) session.getAttribute("loginUser");

    Board old = boardService.get(boardNo);
    if (old.getWriter().getNo() != loginUser.getNo()) {
      return "redirect:../auth/fail";
    } else {
      boardService.deleteFile(fileNo);
      return "redirect:view?no=" + boardNo;
    }
  }

}








