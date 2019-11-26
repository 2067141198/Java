package TCP.Test05;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class FileReceiveAndReply {
    public static void main(String[] args) throws IOException {
        //创建服务端Socket对象
        ServerSocket ss = new ServerSocket(45632);
        Socket s = ss.accept();

        //创建输入流，接受数据
        BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
        //创建输出流，将接受到的内容写入文件中
        BufferedWriter bw = new BufferedWriter(new FileWriter("F:\\File\\JavaSE\\java.txt\\java1.txt"));

        String line;
        while ((line = br.readLine()) != null) {
            bw.write(line);
            bw.newLine();
            bw.flush();
        }

        //发送反馈
        OutputStream os = s.getOutputStream();
        os.write("发送的内容已经接受到了".getBytes());

        bw.close();
        ss.close();
    }
}
