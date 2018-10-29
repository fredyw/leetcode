package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/unique-email-addresses/
 */
public class Problem929 {
    public int numUniqueEmails(String[] emails) {
        Set<String> emailSet = new HashSet<>();
        for (String email : emails) {
            String[] emailSplit = email.split("@");
            String localName = emailSplit[0];
            String hostName = emailSplit[1];
            localName = localName.replaceAll("\\.", "");
            int index = localName.indexOf("+");
            if (index >= 0) {
                emailSet.add(localName.substring(0, index) + "@" + hostName);
            }
        }
        return emailSet.size();
    }
}
