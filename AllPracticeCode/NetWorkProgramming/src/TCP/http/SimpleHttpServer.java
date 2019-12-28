package TCP.http;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimpleHttpServer {
    //private static ExecutorService pool = Executors.newFixedThreadPool(10);

    public static void main(String[] args) throws IOException {
        //创建服务器套接字用来接听
        ServerSocket serverSocket = new ServerSocket(8888);
        ExecutorService pool = Executors.newFixedThreadPool(10);
        while (true) {
            Socket socket = serverSocket.accept();
            pool.execute(new Runnable() {
                @Override
                public void run() {
                    final Socket SOCKET = socket;
                    try {
                        InputStream is = SOCKET.getInputStream();
                        OutputStream os = SOCKET.getOutputStream();
                        //解析请求信息
                        Request request = Request.parse(is);
                        System.out.println(request);
                        //处理业务
                        String body = "<h1>你好</h1>";
                        //String body = "alert('不给糖果就捣蛋');";
                        //拼接响应并发送
                        StringBuilder responseSb = new StringBuilder();
                        responseSb.append("HTTP/1.1 200 OK\r\n");
                        //responseSb.append("HTTP/1.1 307 OK\r\n");
                        responseSb.append("Content-Type:text/html;charset=utf-8\r\n");
                        //responseSb.append("Content-Type:application/javascript;charset=UTF-8\r\n");
                        //responseSb.append("Location:https://www.baidu.com/\r\n");
                        responseSb.append("Content-Length:");
                        responseSb.append("Set-Cookie:name=zhangsan\r\n");
                        responseSb.append("Set-Cookie:age=28\r\n");
                        responseSb.append(body.getBytes().length);
                        responseSb.append("\r\n");
                        responseSb.append("\r\n");
                        responseSb.append(body);

                        os.write(responseSb.toString().getBytes(StandardCharsets.UTF_8));
                        os.flush();
                        //关闭连接
                        SOCKET.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }
}
