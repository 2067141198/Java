package TCP.Test03;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Reseive {
    public static void main(String[] args) throws IOException {
        //创建服务端Socket对象
        ServerSocket ss = new ServerSocket(12365);
        Socket s = ss.accept();
        //包装输入流
        BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
        //包装输入流，将接收到的内容写入文件中
        BufferedWriter bw = new BufferedWriter(new FileWriter("E:File\\JavaSE\\java.txt\\java.txt"));

        String line;
        while ((line = br.readLine()) != null) {
            bw.write(line);
            bw.newLine();
            bw.flush();
        }
        bw.close();
        ss.close();
    }
}
