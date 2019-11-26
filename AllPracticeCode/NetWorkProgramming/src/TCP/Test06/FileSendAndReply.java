package TCP.Test06;

import java.io.*;
import java.net.Socket;

public class FileSendAndReply {
    public static void main(String[] args) throws IOException {
        //创建客户端Socket对象
        Socket s = new Socket("192.168.3.72", 30258);

        BufferedReader br = new BufferedReader(new FileReader("F:\\File\\JavaSE\\java.txt\\java.txt"));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));

        String line;
        while ((line = br.readLine()) != null) {
            bw.write(line);
            bw.newLine();
            bw.flush();
        }

        s.shutdownOutput();

        InputStream is = s.getInputStream();
        byte[] bys = new byte[1024];
        int len = is.read(bys);
        System.out.println(new String(bys, 0, len));

        br.close();
        s.close();
    }
}
