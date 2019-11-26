package TCP.Test02;

import java.io.*;
import java.net.Socket;

public class ScannerSend {
    public static void main(String[] args) throws IOException {
        //创建客户端Socket对象
        Socket s = new Socket("192.168.3.72", 14725);

        //通过键盘输入
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //封装输出流对象
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
        String line;
        while ((line = br.readLine()) != null) {
            if ("886".equals(line)) {
                break;
            }
            bw.write(line);
            bw.newLine();
            bw.flush();
        }
        s.close();
    }
}
