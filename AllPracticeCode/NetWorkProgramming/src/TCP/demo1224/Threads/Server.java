package TCP.demo1224.Threads;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    static int count = Runtime.getRuntime().availableProcessors();
    private static ExecutorService executorService = Executors.newFixedThreadPool(count);

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8888);
        while (true) {
            System.out.println("等待客户端接入");
            Socket socket = serverSocket.accept();
            System.out.println("客户端接入");
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    final Socket socket1 = socket;
                    try {
                        InputStream is = socket1.getInputStream();
                        OutputStream os = socket1.getOutputStream();
                        PrintWriter pw = new PrintWriter(os, false);

                        Scanner sc = new Scanner(is);
                        while (sc.hasNextLine()) {
                            System.out.println(Thread.currentThread().getName() + "等待输入");
                            String message = sc.nextLine();
                            System.out.println(Thread.currentThread().getName() + "已经接收数据");

                            String responseMessage = message;
                            pw.println(responseMessage);
                            pw.flush();
                        }
                    } catch (IOException e) {
                    } finally {
                        try {
                            socket1.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
        }
    }
}
