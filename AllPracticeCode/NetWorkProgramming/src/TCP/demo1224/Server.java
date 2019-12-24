package TCP.demo1224;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8888);
        while (true) {
            System.out.println("等待客户端接入");
            Socket socket = server.accept();
            System.out.println("有客户端接入了");

            InputStream is = socket.getInputStream();
            OutputStream os = socket.getOutputStream();
            PrintWriter pw = new PrintWriter(new OutputStreamWriter(os, StandardCharsets.UTF_8), false);

            Scanner sc = new Scanner(is);
            while (sc.hasNextLine()) {
                String message = sc.nextLine();
                System.out.println("接收到的内容是：" + message);
                String responseMessage = message;
                System.out.println("发送过去的内容是:" + responseMessage);
                pw.println(responseMessage);
                pw.flush();
            }
            server.close();
        }
    }
}
