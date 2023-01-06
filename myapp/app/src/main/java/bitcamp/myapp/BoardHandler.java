package bitcamp.myapp;

import java.sql.Date;

public class BoardHandler {


  static final int SIZE = 100;
  int count;
  Board[] boards = new Board[SIZE];
  String title;

  BoardHandler(String title) {
    this.title = title;
  }

  void inputBoard() {
    Board m = new Board();
    m.nom = Prompt.inputInt("번호? ");
    m.title = Prompt.inputString("제목? ");
    m.text = Prompt.inputString("내용? ");
    m.password = Prompt.inputString("암호? ");
    m.createdDate = new Date(System.currentTimeMillis()).toString();
    m.views = Prompt.inputInt("조회수? ");

    this.boards[count++] = m;
  }

  void printBoards() {
    System.out.println("번호\t제목\t내용\t암호\t조회수");

    for (int i = 0; i < this.count; i++) {
      Board m = this.boards[i];
      System.out.printf("%d\t%s\t%s\t%s\t%d\n",
          m.nom, m.title, m.text, m.password, m.views);
    }
  }

  void printBoard() {
    int boardNo = Prompt.inputInt("게시글번호? ");

    Board m = this.findByNo(boardNo);

    if (m == null) {
      System.out.println("해당 번호의 게시글이 없습니다.");
      return;
    }

    System.out.printf("    제목: %s\n", m.title);
    System.out.printf("    내용: %s\n", m.text);
    System.out.printf("    암호: %s\n", m.password);
    System.out.printf("  작성일: %s\n", m.createdDate);
    System.out.printf("  조회수: %s\n", m.views);
  }


  void modifyBoard() {
    int boardNo = Prompt.inputInt("게시글번호? ");

    Board old = this.findByNo(boardNo);

    if (old == null) {
      System.out.println("해당 번호의 게시글이 없습니다.");
      return;
    }

    Board m = new Board();
    m.nom = old.nom;
    m.createdDate = old.createdDate;
    m.title = Prompt.inputString(String.format("제목(%s)? ", old.title));
    m.text = Prompt.inputString(String.format("내용(%s)? ", old.text));
    m.password = Prompt.inputString(String.format("암호(%s)? ", old.password));


    String str = Prompt.inputString("정말 변경하시겠습니까?(Y/N) ");
    if (str.equalsIgnoreCase("Y")) {
      this.boards[this.indexOf(old)] = m;
      System.out.println("변경했습니다.");
    } else {
      System.out.println("변경 취소했습니다.");
    }

  }

  void deleteMember() {
    int boardNo = Prompt.inputInt("게시글번호? ");

    Board m = this.findByNo(boardNo);

    if (m == null) {
      System.out.println("해당 번호의 게시글이 없습니다.");
      return;
    }

    String str = Prompt.inputString("정말 삭제하시겠습니까?(Y/N) ");
    if (!str.equalsIgnoreCase("Y")) {
      System.out.println("삭제 취소했습니다.");
      return;
    }

    for (int i = this.indexOf(m) + 1; i < this.count; i++) {
      this.boards[i - 1] = this.boards[i];
    }
    boards[--this.count] = null;

    System.out.println("삭제했습니다.");

  }

  Board findByNo(int nom) {
    for (int i = 0; i < this.count; i++) {
      if (this.boards[i].nom == nom) {
        return this.boards[i];
      }
    }
    return null;
  }

  int indexOf(Board m) {
    for (int i = 0; i < this.count; i++) {
      if (this.boards[i].nom == m.nom) {
        return i;
      }
    }
    return -1;
  }

  void searchBoards() {
    String name = Prompt.inputString("제목? ");

    System.out.println("번호\t제목\t내용\t암호");

    for (int i = 0; i < this.count; i++) {
      Board m = this.boards[i];
      if (m.title.equalsIgnoreCase(name)) {
        System.out.printf("%d\t%s\t%s\t%s\n",m.nom, m.title, m.text, m.password);
      }
    }
  }

  void service() {
    while (true) {
      System.out.printf("[%s]\n", this.title);
      System.out.println("1. 등록");
      System.out.println("2. 목록");
      System.out.println("3. 조회");
      System.out.println("4. 변경");
      System.out.println("5. 삭제");
      System.out.println("0. 이전");
      int menuNo = Prompt.inputInt(String.format("%s>", this.title));

      switch (menuNo) {
        case 0: return;
        case 1: this.inputBoard(); break;
        case 2: this.printBoards(); break;
        case 3: this.printBoard(); break;
        case 4: this.modifyBoard(); break;
        case 5: this.deleteMember(); break;
        default:
          System.out.println("잘못된 메뉴 번호 입니다.");
      }
    }
  }
}
