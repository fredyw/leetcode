package leetcode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

// https://leetcode.com/problems/web-crawler/
public class Problem1236 {
    public interface HtmlParser {
        List<String> getUrls(String url);
    }

    public List<String> crawl(String startUrl, HtmlParser htmlParser) {
        Set<String> answer = new HashSet<>();
        crawl(startUrl, htmlParser, answer);
        return answer.stream().toList();
    }

    private static void crawl(String startUrl, HtmlParser htmlParser, Set<String> urls) {
        if (!urls.add(startUrl)) {
            return;
        }
        String hostname = getHostname(startUrl);
        for (String url : htmlParser.getUrls(startUrl)) {
            if (getHostname(url).equals(hostname)) {
                crawl(url, htmlParser, urls);
            }
        }
    }

    private static String getHostname(String url) {
        String sub = url.substring(7);
        int index = sub.indexOf("/");
        if (index == -1) {
            return sub;
        }
        return sub.substring(0, index);
    }
}
