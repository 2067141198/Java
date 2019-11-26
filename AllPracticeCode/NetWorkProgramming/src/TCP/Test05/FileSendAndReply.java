package TCP.Test05;

import java.io.*;
import java.net.Socket;

public class FileSendAndReply {
    public static void main(String[] args) throws IOException {
        //创建客户端Socket对象
        Socket s = new Socket("192.168.3.72", 45632);

        //创建文件输出流
        BufferedReader br = new BufferedReader(new FileReader("F:\\File\\JavaSE\\java.txt\\java.txt"));
        //创建输出流
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));

        String line;
        while ((line = br.readLine()) != null) {
            bw.write(line);
            bw.newLine();
            bw.flush();
        }

        s.shutdownOutput();

        //接受反馈
        InputStream is = s.getInputStream();
        byte[] bys = new byte[1024];
        int len = is.read(bys);
        System.out.println(new String(bys, 0, len));

        //释放资源
        br.close();
        s.close();
    }
}
