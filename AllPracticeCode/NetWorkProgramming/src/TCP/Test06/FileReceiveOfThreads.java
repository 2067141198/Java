package TCP.Test06;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class FileReceiveOfThreads {
    public static void main(String[] args) throws IOException {
        Object obj = new Object();
        ServerSocket ss = new ServerSocket(30258);
        Socket s = ss.accept();
        for (int i = 0; i < 5; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    synchronized (obj) {
                        BufferedWriter bw = null;
                        try {
                            BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));

                            //创建文件，以防重名，每次创建都让文件名的后缀数加1
                            int count = 10;
                            File file = new File("F:\\File\\JavaSE\\java.txt\\java" + count + ".txt");
                            while (file.exists()) {
                                count++;
                                file = new File("F:\\File\\JavaSE\\java.txt\\java" + count + ".txt");
                            }
                            bw = new BufferedWriter(new FileWriter(file));

                            String line;
                            while ((line = br.readLine()) != null) {
                                bw.write(line);
                                bw.newLine();
                                bw.flush();
                            }

                            //给出反馈
//                        OutputStream os = s.getOutputStream();
//                        os.write("接收到了".getBytes());
                            BufferedWriter bwr = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
                            bwr.write("接收到了");
                            bwr.newLine();
                            bwr.flush();

                        } catch (IOException e) {
                            e.printStackTrace();
                        } finally {
                            try {
                                if (bw != null)
                                    bw.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }).start();
        }
        ss.close();
    }
}
