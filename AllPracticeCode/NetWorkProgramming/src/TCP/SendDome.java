package TCP;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class SendDome {
    //如果没有对应服务器在等待与该客户端响应那就会抛出以下异常
    //Exception in thread "main" java.net.ConnectException: Connection timed out: connect
    public static void main(String[] args) throws IOException {
        //创建客户端的Socket对象
        //Socket s = new Socket(InetAddress.getByName("192.168.3.251"), 10000);
        Socket s = new Socket("192.168.3.72", 10000);
        //获取输出流，写数据
        OutputStream os = s.getOutputStream();
        os.write("服务端收到请回复".getBytes());
        //释放资源
        os.close();
        s.close();
    }
}
