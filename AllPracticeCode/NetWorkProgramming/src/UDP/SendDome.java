package UDP;


import java.io.IOException;
import java.net.*;

public class SendDome {
    public static void main(String[] args) throws IOException {
        //创建发送端的Socket对象(DatagramSocket)
        DatagramSocket ds = new DatagramSocket();
        //创建数据，并把数据打包
        byte[] bytes = "UDP 我发送信息过来了".getBytes();
        DatagramPacket dp = new DatagramPacket(bytes, bytes.length, InetAddress.getByName("192.168.3.251"),10088);
        //调用DatagramSocket对象的方法发送数据
        ds.send(dp);
        //关闭发送端
        ds.close();
    }
}
