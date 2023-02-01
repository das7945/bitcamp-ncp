package com.eomcs.net;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerApp {

  public static void main(String[] args) throws Exception {
    //    Scanner keyScan = new Scanner(System.in);

    try(ServerSocket serverSocket = new ServerSocket(8888);) {
      System.out.println("서버 실행 중...");


      try(
          Socket socket = serverSocket.accept();
          BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
          PrintStream out = new PrintStream(socket.getOutputStream());
          ) {

        System.out.println("계산기");
        System.out.println("계산기");
        System.out.println("계산기");



        while (true) {
          String message = in.readLine();
          System.out.println(message);
          if (message.equals("quit")) {
            break;
          }

          System.out.print("입력> ");
          //      String str = keyScan.nextLine();
          //      out.println(str);
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  //  socket.close();
  //  serverSocket.close();

  //      System.out.println("서버 종료!");
  //      keyScan.close();
}

}