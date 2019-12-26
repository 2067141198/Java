package Strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class SimpleHttpClient {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append("GET / HTTP/1.0\r\n");
        sb.append("Host:www.baidu.com\r\n");
        sb.append("\r\n");

        Socket socket = new Socket("www.baidu.com", 80);
        socket.getOutputStream().write(sb.toString().getBytes());
        socket.getOutputStream().flush();
        socket.shutdownOutput();

        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));

        String line;
        /*while((line = br.readLine()) != null) {
            System.out.println(line);
        }*/

        /*byte[] bytes = new byte[4096];
        int len;
        if ((len = socket.getInputStream().read(bytes)) != -1) {
            System.out.println(new String(bytes, 0, len));
        }*/

        line = br.readLine();
        //解析响应行
        List<String> list = new ArrayList<>();
        list.addAll(Arrays.asList(line.split(" ")));

        Map<String, String> map = new HashMap<>();
        line = br.readLine();
        while ((!"".equals(line)) && line != null) {
            map.put(line.split(":")[0], line.split(":")[1]);
            line = br.readLine();
        }
        br.readLine();
        System.out.println(list);
        System.out.println(map);
        System.out.println("=============");
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }

        socket.close();
    }
}
