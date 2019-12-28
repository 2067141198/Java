package TCP.http;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Request {
    String method;
    String path;
    String version;
    Map<String, String> header = new HashMap<>();

    public static Request parse(InputStream is) throws IOException {
        Request request = new Request();
        //BufferedReader sc = new BufferedReader(new InputStreamReader(is, "UTF-8"));
        Scanner sc = new Scanner(is);

        String line;
        line = sc.nextLine();
        String[] requestLines = line.split(" ");
        request.method = requestLines[0];
        request.path = requestLines[1];
        request.version = requestLines[2];

        while (!(line = sc.nextLine()).isEmpty()) {
//            request.header.put(line.split(":")[0], line.split(":")[1].trim());
            String[] kv = line.split(":");
            String k = kv[0];
            String v = kv[1];
            request.header.put(k, v);
        }

        return request;
    }

    @Override
    public String toString() {
        return "Request{" +
                "method='" + method + '\'' +
                ", path='" + path + '\'' +
                ", version='" + version + '\'' +
                ", header=" + header +
                '}';
    }
}
