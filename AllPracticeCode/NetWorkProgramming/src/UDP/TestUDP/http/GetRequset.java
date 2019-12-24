package UDP.TestUDP.http;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GetRequset {

    private static final int PORT = 9999;
    //获取处理器核数
    private static final int COUNT = Runtime.getRuntime().availableProcessors();
    private static final ExecutorService EXE = Executors.newFixedThreadPool(COUNT);

    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(PORT);
        //获取客户端请求，阻塞式方法
        Socket s = ss.accept();
        EXE.submit(new HttpTask(s));
    }

    static class HttpTask implements Runnable {
        private Socket s;

        HttpTask(Socket s) {
            this.s = s;
        }

        @Override
        public void run() {
            InputStream is = null;
            InputStreamReader isr = null;
            BufferedReader br = null;
            OutputStream os = null;
            PrintWriter pw = null;
            try {
                try {
                    Request request = new Request();
                    is = s.getInputStream();
                    isr = new InputStreamReader(is, StandardCharsets.UTF_8);
                    br = new BufferedReader(isr);
                    //请求数据的解析，http协议报的解包
                    //解析请求行
                    String[] requestLine = br.readLine().split(" ");
                    request.setMethod(requestLine[0]);
                    String url = requestLine[1];
                    if (url.contains("?")) {
                        String parameters = url.substring(url.indexOf('?') + 1);
                        request.parseParemeters(parameters);
                        url = url.substring(0, url.indexOf('?'));
                    }
                    request.setUrl(url);
                    request.setVersion(requestLine[2]);

                    String header;
                    while ((header = br.readLine()) != null && header.length() != 0) {
                        request.addHeader(header.split(":")[0], header.split(":")[1].trim());
                    }

                    //首先判断方法是否为POST（才会有正文），从请求头中获取Content-length的值，判断正文是否为空
                    if ("POST".equals(request.getMethod())) {
                        if (request.getParameterValue("Content-length").equals("0")) {
                            int len = Integer.parseInt(request.getParameterValue("Content-length"));
                            char[] ch = new char[len];
                            br.read(ch, 0, len);
                            String requestBody = new String(ch);
                            request.parseParemeters(requestBody);
                        }
                    }
                    System.out.println(request);

                    os = s.getOutputStream();
                    pw = new PrintWriter(os, true);
                    if ("/302".equals(request.getUrl())) {
                        pw.println("HTTP/1.1 302 重定向");
                        pw.println("Content-Type:text/html;charset=utf-8");
                        pw.println("Location:https://www.weibo.com");
                    } else if ("login".equals(request.getUrl())) {
                        pw.println("HTTP1.1 200 OK");
                        pw.println("Content-Type:text/html;charset=utf-8");
                        pw.println();
                        pw.println("<h2>欢迎用户" + request.getParameterValue("username") + "</h2>");
                    } else {
                        InputStream htmlIs = GetRequset.class.getClassLoader().getResourceAsStream("." + request.getUrl());
                        if (htmlIs != null) {
                            pw.println("HTTP1.1 200 OK");
                            pw.println("Content-Type:text/html;charset=utf-8");
                            pw.println();

                            BufferedReader htmlBr = new BufferedReader(new InputStreamReader(htmlIs));
                            String line;
                            while ((line = htmlBr.readLine()) != null) {
                                pw.println(line);
                                pw.flush();
                            }

                        } else {

                        }
                    }

                } finally {
                    if (br != null) {
                        br.close();
                    }
                    if (isr != null) {
                        isr.close();
                    }
                    if (is != null) {
                        is.close();
                    }
                    if (pw != null) {
                        pw.close();
                    }
                    if (os != null) {
                        os.close();
                    }
                    s.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

class Request {
    private String method;
    private String url;
    private String version;
    //请求头
    private Map<String, String> requestHeads = new HashMap<>();
    //参数列表
    private Map<String, String> parameters = new HashMap<>();

    void addHeader(String key, String value) {
        requestHeads.put(key, value);
    }

    String getHeaderValue(String key) {
        return requestHeads.get(key);
    }

    //解析参数的参数字符串
    void parseParemeters(String s) {
        String[] parameters = s.split("&");
        for (String s1 : parameters) {
            this.addParameter(s1.split("=")[0], s1.split("=")[1]);
        }
    }

    //添加参数的key和value
    void addParameter(String key, String value) {
        parameters.put(key, value);
    }

    String getParameterValue(String key) {
        return parameters.get(key);
    }

    String getMethod() {
        return method;
    }

    void setMethod(String method) {
        this.method = method;
    }

    String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Map<String, String> getRequestHeads() {
        return requestHeads;
    }

    public void setRequestHeads(Map<String, String> requestHeads) {
        this.requestHeads = requestHeads;
    }

    public Map<String, String> getParameters() {
        return parameters;
    }

    public void setParameters(Map<String, String> parameters) {
        this.parameters = parameters;
    }

    @Override
    public String toString() {
        return "Request{\n" +
                "method='" + method + '\'' +
                ",\n url='" + url + '\'' +
                ",\n version='" + version + '\'' +
                ",\n requestHeads=" + requestHeads +
                ",\n parameters=" + parameters +
                '}';
    }
}
