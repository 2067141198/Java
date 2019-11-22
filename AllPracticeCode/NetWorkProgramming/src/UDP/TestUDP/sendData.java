package UDP.TestUDP;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class sendData {
    public static void main(String[] args) throws IOException {
        //创建发送端Socket对象
        DatagramSocket ds = new DatagramSocket();
        //创建Scanner对象，用于从键盘读取数据
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            String line = sc.nextLine();
            //以单独一行“666”为键盘输入文本的终止
            if("666".equals(line)){
                break;
            }

            //创建数据，并把数据打包
            byte[] bys = line.getBytes();
            DatagramPacket dp = new DatagramPacket(bys, bys.length, InetAddress.getByName("192.168.3.251"), 10000);
            //调用DatagramSocket对象的方法发送数据
            ds.send(dp);
        }
        //关闭发送端
        ds.close();
    }
}
