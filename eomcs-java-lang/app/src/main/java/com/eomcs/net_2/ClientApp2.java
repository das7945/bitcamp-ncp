package com.eomcs.net;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.Socket;

public class ClientApp2 {

  public static void main(String[] args) throws Exception {
    Socket socket = new Socket("192.168.0.16",8888);
    System.out.println("서버에 연결 되었음!!");

    DataOutputStream out = new DataOutputStream(socket.getOutputStream());
    DataInputStream in = new DataInputStream(socket.getInputStream());

    File file = new File("photo.jpg");

    // 전송 할 파일의 이름을 보낸다.
    out.writeUTF(file.getName());

    // 전송 할 파일의 크기를 먼저 보낸다.
    out.writeLong(file.length());

    FileInputStream fileIn = new FileInputStream(file);
    int b;
    while ((b = fileIn.read()) != -1) {
      out.write(b);
    }
    fileIn.close();


    // 서버의 응답을 읽는다.
    System.out.println(in.readUTF());

    out.close();
    in.close();

    // 3)
    socket.close();

    System.out.println("클라이언트 종료!");
  }

}
