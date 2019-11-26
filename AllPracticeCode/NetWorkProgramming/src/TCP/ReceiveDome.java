package TCP;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ReceiveDome {
    public static void main(String[] args) throws IOException {
        //创建服务端的Socket对象
        ServerSocket ss = new ServerSocket(10000);
        //获取通信的客户端
        Socket s = ss.accept();
        //获取输入流，读数据
        InputStream is = s.getInputStream();
        byte[] bys = new byte[1024];
        int len;
        while ((len = is.read(bys)) != -1) {
            System.out.println(new String(bys, 0, len));
        }
        //释放资源
        is.close();
        ss.close();
    }
}
