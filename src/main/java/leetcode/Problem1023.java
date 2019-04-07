package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/camelcase-matching/
 */
public class Problem1023 {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> answer = new ArrayList<>();
        for (String query : queries) {
            int i = 0;
            int j = 0;
            boolean found = true;
            if (pattern.charAt(i) != query.charAt(j)) {
                found = false;
            } else {
                while (i < pattern.length() && j < query.length()) {
                    if (Character.isLowerCase(pattern.charAt(i))) {
                        if (pattern.charAt(i) != query.charAt(j)) {
                            found = false;
                            break;
                        }
                    } else { // Character.isUpperCase(pattern.charAt(i))
                        while (j < query.length() && Character.isLowerCase(query.charAt(j))) {
                            j++;
                        }
                        if (j >= query.length() || pattern.charAt(i) != query.charAt(j)) {
                            found = false;
                            break;
                        }
                    }
                    i++;
                    j++;
                }
            }
            while (j < query.length()) {
                if (Character.isUpperCase(query.charAt(j))) {
                    found = false;
                    break;
                }
                j++;
            }
            answer.add(i < pattern.length() ? false : found);
        }
        return answer;
    }

    public static void main(String[] args) {
        Problem1023 prob = new Problem1023();
//        System.out.println(prob.camelMatch(new String[]{"FooBarTest"}, "FB")); // [false]
//        System.out.println(prob.camelMatch(new String[]{"FooBarTest"}, "FBTT")); // [false]
//        System.out.println(prob.camelMatch(new String[]{"FooBarT"}, "FBTT")); // [false]
//        System.out.println(prob.camelMatch(new String[]{"FooBarTTa"}, "FBTTa")); // [true]
//        System.out.println(prob.camelMatch(new String[]{"FBT"}, "FBT")); // [true]
//        System.out.println(prob.camelMatch(new String[]{"FooBarTest"}, "FBT")); // [true]
//        System.out.println(prob.camelMatch(new String[]{
//            "FooBar", "FooBarTest", "FootBall", "FrameBuffer", "ForceFeedBack"}, "FB")); // [true,false,true,true,false]
//        System.out.println(prob.camelMatch(new String[]{
//            "FooBar", "FooBarTest", "FootBall", "FrameBuffer", "ForceFeedBack"}, "FoBa")); // [true,false,true,false,false]
//        System.out.println(prob.camelMatch(new String[]{
//            "FooBar", "FooBarTest", "FootBall", "FrameBuffer", "ForceFeedBack"}, "FoBaT")); // [false,true,false,false,false]
//        System.out.println(prob.camelMatch(new String[]{
//            "CompetitiveProgramming", "CounterPick", "ControlPanel"}, "CooP")); // [false,false,true]
        System.out.println(prob.camelMatch(new String[]{"ControlPanel"}, "CooP")); // [true]
        System.out.println(prob.camelMatch(new String[]{"ConxonpPanel"}, "ConpP")); // [true]
        System.out.println(prob.camelMatch(new String[]{"ControlPanel"}, "CtnP")); // [false]
    }
}
