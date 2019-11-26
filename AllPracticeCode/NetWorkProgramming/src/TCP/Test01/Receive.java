package TCP.Test01;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Receive {
    public static void main(String[] args) throws IOException {
        //创建客户端Socket对象
        ServerSocket ss = new ServerSocket(12345);
        //监听要连接到此的套接字并接受它
        Socket s = ss.accept();
        //获取输入流读取数据
        InputStream is = s.getInputStream();
        byte[] bys = new byte[1024];
        int len = is.read(bys);
        System.out.println(new String(bys, 0, len));

        //获取输出流，写数据，给客户端回复
        OutputStream os = s.getOutputStream();
        os.write("服务器已收到，Over".getBytes());

        //释放资源
        ss.close();
    }
}
