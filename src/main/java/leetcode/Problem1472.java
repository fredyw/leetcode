package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/design-browser-history/
 */
public class Problem1472 {
    static class BrowserHistory {
        private List<String> history = new ArrayList<>();
        private int index;

        public BrowserHistory(String homepage) {
            history.add(homepage);
        }

        public void visit(String url) {
            index++;
            if (index < history.size()) {
                history = history.subList(0, index);
            }
            history.add(url);
        }

        public String back(int steps) {
            index -= steps;
            if (index < 0) {
                index = 0;
            }
            return history.get(index);
        }

        public String forward(int steps) {
            index += steps;
            if (index >= history.size()) {
                index = history.size() - 1;
            }
            return history.get(index);
        }
    }
}
