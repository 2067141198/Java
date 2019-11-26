package TCP.Test04;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class FileReseive {
    public static void main(String[] args) throws IOException {
        //创建服务端Socket对象
        ServerSocket ss = new ServerSocket(10258);
        Socket s = ss.accept();

        //创建输出流，接受数据
        BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
        //创建输入流，将读取到的内容写入文件
        BufferedWriter bw = new BufferedWriter(new FileWriter("F:\\File\\JavaSE\\java.txt\\java.txt"));

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
