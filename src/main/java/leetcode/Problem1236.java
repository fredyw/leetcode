package leetcode;

import java.util.List;

// https://leetcode.com/problems/web-crawler/
public class Problem1236 {
    public interface HtmlParser {
        List<String> getUrls(String url);
    }

    public List<String> crawl(String startUrl, HtmlParser htmlParser) {
        return List.of();
    }
}
