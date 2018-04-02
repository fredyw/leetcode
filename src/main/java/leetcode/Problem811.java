package leetcode;

import java.util.List;

/**
 * https://leetcode.com/problems/subdomain-visit-count/description/
 */
public class Problem811 {
    public List<String> subdomainVisits(String[] cpdomains) {
        // TODO
        return null;
    }

    public static void main(String[] args) {
        Problem811 prob = new Problem811();
        System.out.println(prob.subdomainVisits(new String[]{"9001 discuss.leetcode.com"})); // ["9001 discuss.leetcode.com", "9001 leetcode.com", "9001 com"]
        System.out.println(prob.subdomainVisits(new String[]{"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"})); // ["901 mail.com","50 yahoo.com","900 google.mail.com","5 wiki.org","5 org","1 intel.mail.com","951 com"]

    }
}
