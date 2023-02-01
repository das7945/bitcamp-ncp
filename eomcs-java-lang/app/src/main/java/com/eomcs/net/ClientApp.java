package com.eomcs.net;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class ClientApp {
  public static void main(String[] args) throws Exception {

    try(
        Scanner keyScan = new Scanner(System.in);
        Socket socket = new Socket("localhost", 8888);
        PrintStream out = new PrintStream(socket.getOutputStream());
        Scanner in = new Scanner(socket.getInputStream());
        ) {

      while (true) {
        System.out.print("입력> ");
        String message = keyScan.nextLine();
        out.println(message);

        if (message.equals("quit")) {
          break;
        } catch (Exception e) {
          e.printStackTrace();
        }i
      }
    }
    //
    //    String response = in.nextLine();
    //    System.out.printf("응답: %s\n", response);


    //  out.close();
    //  in.close();
    //  socket.close();

    //  System.out.println("클라이언트 종료!");
    //  keyScan.close();
