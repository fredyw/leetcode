package leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.com/problems/rectangle-area/
 */
public class Problem223 {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int area1 = computeArea(A, B, C, D);
        int area2 = computeArea(E, F, G, H);
        Intersection xIntersection = getIntersection(A, C, E, G);
        Intersection yIntersection = getIntersection(B, D, F, H);
        int intersectedArea = 0;
        if (xIntersection.intersected && yIntersection.intersected) {
            intersectedArea = computeArea(
                xIntersection.a, yIntersection.a,
                xIntersection.b, yIntersection.b);
        }
        return area1 + area2 - intersectedArea;
    }

    private int computeArea(int a, int b, int c, int d) {
        int x = Math.abs(a - c);
        int y = Math.abs(b - d);
        return x * y;
    }

    private static class Intersection {
        private boolean intersected;
        private int a;
        private int b;

        private Intersection(boolean intersected, int a, int b) {
            this.intersected = intersected;
            this.a = a;
            this.b = b;
        }

        public static Intersection noIntersection() {
            return new Intersection(false, 0, 0);
        }

        public static Intersection hasIntersection(int a, int b) {
            return new Intersection(true, a, b);
        }
    }

    private Intersection getIntersection(int a, int b, int c, int d) {
        if (b < c || d < a) {
            return Intersection.noIntersection();
        } else {
            List<Integer> list = Arrays.asList(a, b, c, d);
            Collections.sort(list);
            return Intersection.hasIntersection(list.get(1), list.get(2));
        }
    }
}
