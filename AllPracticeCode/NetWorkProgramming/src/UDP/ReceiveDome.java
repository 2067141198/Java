package UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class ReceiveDome {
    public static void main(String[] args) throws IOException {
        //创建接收端的Socket对象(DatagramSocket)
        DatagramSocket ds = new DatagramSocket(10088);
        //创建一个数据包，用于接收数据
        byte[] bytes = new byte[1024];
        DatagramPacket dp = new DatagramPacket(bytes, bytes.length);
        //调用DatagramSocket对象的方法接收数据
        ds.receive(dp);
        //解析数据包，并把数据在控制台显示
        byte[] b = dp.getData();
        int len = dp.getLength();
        String s = new String(b, 0, len);
        System.out.println(s);
        //关闭接收端
        ds.close();
    }
}
