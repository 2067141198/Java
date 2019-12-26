package Strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class SliptURL {
    public List<String> splitURL(String url, Map<String, String> map) {
        List<String> list = new ArrayList<>();
        String[] str1 = url.split("://");
        String schema = str1[0];
        list.add(schema);

        String[] hostAndPort = str1[1].split("/");
        String host;
        String port;
        if (hostAndPort[0].contains(":")) {
            host = hostAndPort[0].split(":")[0];
            port = hostAndPort[0].split(":")[1];
        } else {
            host = hostAndPort[0];
            port = map.get(host);
        }
        list.add(host);
        list.add(port);

        String url1;
        if (hostAndPort[1].contains("?")) {
            url1 = hostAndPort[1].split("\\?")[0];
        } else {
            url1 = hostAndPort[1];
        }
        list.add(url);

        if (hostAndPort[1].split("\\?")[1].contains("#")) {
            String[] para = hostAndPort[1].split("\\?")[1].split("#")[0].split(":");
            list.addAll(Arrays.asList(para));
            list.add(hostAndPort[1].split("\\?")[1].split("#")[1]);
        } else {
            String[] para = hostAndPort[1].split("\\?")[1].split(":");
            list.addAll(Arrays.asList(para));
        }

        return list;
    }
}
