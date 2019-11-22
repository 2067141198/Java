package UDP.TestUDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class ReceiveData {
    public static void main(String[] args) throws IOException {
        //创建接收端Socket对象
        DatagramSocket ds = new DatagramSocket(10000);
        while(true) {
            //创建一个数据包，用于接收数据
            byte[] bys = new byte[1024];
            DatagramPacket dp = new DatagramPacket(bys, bys.length);
            //调用DatagramSocket对象的方法接收数据
            ds.receive(dp);
            //解析数据包，并把数据在控制台显示
            byte[] b = dp.getData();
            int len = dp.getLength();
            String s = new String(b, 0, len);
            System.out.println(s);
        }
        //ds.close();
    }
}
