package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/encode-and-decode-tinyurl/
 */
public class Problem535 {
    public static class Codec {
        private static final String PREFIX_URL = "http://tinyurl.com/";
        private static final String ALPHANUMERIC = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        private final Map<Integer, String> map = new HashMap<>();
        private int id;

        // Encodes a URL to a shortened URL.
        public String encode(String longUrl) {
            StringBuilder shortUrl = new StringBuilder();
            int key = id;
            if (key == 0) {
                shortUrl.append(ALPHANUMERIC.charAt(key % ALPHANUMERIC.length()));
            } else {
                while (key > 0) {
                    shortUrl.append(ALPHANUMERIC.charAt(key % ALPHANUMERIC.length()));
                    key = key / ALPHANUMERIC.length();
                }
            }
            map.put(id++, longUrl);
            return PREFIX_URL + shortUrl.toString();
        }

        // Decodes a shortened URL to its original URL.
        public String decode(String shortUrl) {
            String url = shortUrl.substring(PREFIX_URL.length());
            int key = 0;
            for (int i = url.length() - 1; i >= 0; i--) {
                key += ALPHANUMERIC.indexOf(url.charAt(i)) * (int) Math.pow(ALPHANUMERIC.length(), i);
            }
            return map.get(key);
        }
    }
}
