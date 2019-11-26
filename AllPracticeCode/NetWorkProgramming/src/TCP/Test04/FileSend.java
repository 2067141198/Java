package TCP.Test04;

import java.io.*;
import java.net.Socket;

public class FileSend {
    public static void main(String[] args) throws IOException {
        //创建客户端Socket对象
        Socket s = new Socket("192.168.3.72", 10258);

        //创建从文件读取是输入流
        BufferedReader br = new BufferedReader(new FileReader("E:\\File\\JavaSE\\java.txt\\java.txt"));
        //创建输出流
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));

        String line;
        while ((line = br.readLine()) != null) {
            if ("886".equals(line))
                break;
            bw.write(line);
            bw.newLine();
            bw.flush();
        }

        br.close();
        s.close();
    }
}
