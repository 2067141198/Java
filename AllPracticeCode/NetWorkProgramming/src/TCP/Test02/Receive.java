package TCP.Test02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Receive {
    public static void main(String[] args) throws IOException {
        //创建服务端Socket对象
        ServerSocket ss = new ServerSocket(14725);
        Socket s = ss.accept();

        BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
        //释放资源
        ss.close();
    }
}
