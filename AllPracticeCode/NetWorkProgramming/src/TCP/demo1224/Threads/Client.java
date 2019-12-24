package TCP.demo1224.Threads;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket client = new Socket(InetAddress.getByName("localhost"), 8888);
        //Scanner sc = new Scanner(System.in);
        InputStream is = client.getInputStream();
        OutputStream os = client.getOutputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));

        Scanner sc1 = new Scanner(System.in);
        Scanner sc2 = new Scanner(is);
        while (true) {
            System.out.print("请输入:");
            String message = sc1.nextLine() + "\r\n";
            bw.write(message);
            bw.flush();
            String requestMessage = sc2.nextLine();
            System.out.println(requestMessage);
        }
    }
}
