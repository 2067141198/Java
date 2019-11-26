package TCP.Test01;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Send {
    public static void main(String[] args) throws IOException {
        //创建客户端Socket对象
        Socket s = new Socket("192.168.3.72", 12345);

        //获取输出流，输出数据
        OutputStream os = s.getOutputStream();
        os.write("客户端请求服务端支援，收到请回复，Over".getBytes());

        //获取输入流，接受服务端的消息
        InputStream is = s.getInputStream();
        byte[] bys = new byte[1024];
        int len = is.read(bys);
        System.out.println(new String(bys, 0, len));

        //释放资源
        s.close();
    }
}
